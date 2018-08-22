package com.bianlitransf.biz.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bianlitransf.biz.entity.User;
import com.bianlitransf.biz.service.IUserService;
import com.bianlitransf.biz.service.SmsService;
import com.qiuxs.cuteframework.core.basic.Constants;
import com.qiuxs.cuteframework.core.basic.bean.UserLite;
import com.qiuxs.cuteframework.core.basic.utils.ExceptionUtils;
import com.qiuxs.cuteframework.core.basic.utils.generator.GUIDGenerator;
import com.qiuxs.cuteframework.core.basic.utils.security.MD5Util;
import com.qiuxs.cuteframework.core.context.UserContext;
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
		this.userService.resetPass(oldPass,pass);
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
	public UserLite login(@Param("phone") String phone, @Param("pass") String pass) {
		User user = this.userService.getByPhone(phone, true);
		if (!user.getPassword().equals(MD5Util.MD5Encode(pass, Constants.DEFAULT_CHARSET))) {
			ExceptionUtils.throwLogicalException("pass_error");
		}
		UserLite userLite = new UserLite();
		userLite.setLoginId(phone);
		userLite.setLoginTime(new Date());
		userLite.setName(user.getName());
		userLite.setUserId(user.getId());
		userLite.setSessionId(new GUIDGenerator().toString());
		UserContext.addUserLite(userLite);
		return userLite;
	}

	@Api
	public UserLite check(@Param("sessionId") String sessionId) {
		UserLite userLite = UserContext.getUserLite(sessionId);
		return userLite;
	}

}
