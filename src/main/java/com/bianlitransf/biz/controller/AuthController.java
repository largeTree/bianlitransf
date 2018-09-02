package com.bianlitransf.biz.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bianlitransf.biz.entity.SessionRec;
import com.bianlitransf.biz.entity.User;
import com.bianlitransf.biz.service.ISessionRecService;
import com.bianlitransf.biz.service.IUserService;
import com.bianlitransf.biz.service.SmsService;
import com.qiuxs.cuteframework.core.basic.Constants;
import com.qiuxs.cuteframework.core.basic.bean.UserLite;
import com.qiuxs.cuteframework.core.basic.utils.ExceptionUtils;
import com.qiuxs.cuteframework.core.basic.utils.JsonUtils;
import com.qiuxs.cuteframework.core.basic.utils.generator.GUIDGenerator;
import com.qiuxs.cuteframework.core.basic.utils.security.MD5Util;
import com.qiuxs.cuteframework.core.context.UserContext;
import com.qiuxs.cuteframework.tech.task.AsyncTaskExecutor;
import com.qiuxs.cuteframework.tech.task.RunnableAsyncTask;
import com.qiuxs.cuteframework.web.WebConstants;
import com.qiuxs.cuteframework.web.annotation.Api;
import com.qiuxs.cuteframework.web.controller.BaseController;
import com.qiuxs.cuteframework.web.controller.api.Param;

@RestController
@RequestMapping(value = "/auth", produces = WebConstants.DEFAULT_REQUEST_PRODUCES)
public class AuthController extends BaseController {

	@Resource
	private IUserService userService;

	@Resource
	private SmsService smsService;

	@Resource
	private ISessionRecService sessionRecService;

	@Api
	public void getVerifyCode(@Param("phone") String phone) {
		this.smsService.sendCaptch(phone);
	}

	@Api
	public void getVerifyCodeWithUser(@Param("phone") String phone) {
		this.userService.getByPhone(phone, true);
		this.smsService.sendCaptch(phone);
	}

	@Api
	public void updatePass(@Param("oldPass") String oldPass, @Param("newPass") String pass) {
		this.userService.resetPass(oldPass, pass);
	}

	@Api
	public void resetPass(@Param("phone") String phone, @Param("verifyCode") String verifyCode,
			@Param("pass") String pass) {
		this.smsService.checkCaptch(phone, verifyCode);
		this.userService.updatePass(phone, pass);
	}

	@Api
	public void register(@Param("phone") String phone, @Param("pass") String pass,
			@Param("verify") String verifyCode, @Param("referee") String referee) {
		this.smsService.checkCaptch(phone, verifyCode);
		this.userService.register(phone, pass, verifyCode, referee);
	}

	@Api
	public void logout() {
		String sessionId = UserContext.getUserLite().getSessionId();
		UserContext.removeSession(sessionId);
		this.sessionRecService.deleteSession(sessionId);
	}

	@Api
	public UserLite login(@Param("phone") String phone, @Param("pass") String pass) {
		User user = this.userService.getByPhone(phone, true);
		return this.loginInner(user, pass);
	}

	@Api
	public UserLite login1(@Param("phone") String phone, @Param("pass") String pass) {
		User user = this.userService.getByPhone(phone, true);
		if (user.getLevel() > 0) {
			ExceptionUtils.throwLogicalException("user_not_exists", phone);
		}
		return this.loginInner(user, pass);
	}

	private UserLite loginInner(User user, String pass) {
		if (!user.getPassword().equals(MD5Util.MD5Encode(pass, Constants.DEFAULT_CHARSET))) {
			ExceptionUtils.throwLogicalException("pass_error");
		}
		UserLite userLite = new UserLite();
		userLite.setLoginId(user.getPhone());
		userLite.setLoginTime(new Date());
		userLite.setName(user.getName());
		userLite.setUserId(user.getId());
		userLite.setSessionId(new GUIDGenerator().toString());
		UserContext.addUserLite(userLite);
		// 会话持久化
		AsyncTaskExecutor.execute(new RunnableAsyncTask<UserLite>(userLite) {
			@Override
			public void execute(UserLite preparParam) {
				SessionRec sessionRec = new SessionRec();
				sessionRec.setUserId(preparParam.getUserId());
				sessionRec.setSessionBean(JsonUtils.toJSONString(userLite));
				sessionRec.setSessionId(preparParam.getSessionId());
				sessionRec.setLoginTime(preparParam.getLoginTime());
				AuthController.this.sessionRecService.save(sessionRec);
			}
		}, false);
		return userLite;
	}

	@Api
	public UserLite check(@Param("sessionId") String sessionId) {
		UserLite userLite = UserContext.getUserLite(sessionId, true);
		if (userLite == null) {
			userLite = this.sessionRecService.loadSession(sessionId);
			if (userLite != null) {
				// 持久化中有的话 恢复到缓存中
				UserContext.addUserLite(userLite);
			}
		}
		if (userLite == null) {
			// 不存在会话 抛出异常
			ExceptionUtils.throwLoginException();
		}
		return userLite;
	}

}
