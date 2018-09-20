package com.bianlitransf.biz.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bianlitransf.biz.BizConstants;
import com.bianlitransf.biz.dao.UserDao;
import com.bianlitransf.biz.entity.User;
import com.bianlitransf.biz.service.IUserService;
import com.qiuxs.cuteframework.core.basic.Constants;
import com.qiuxs.cuteframework.core.basic.bean.UserLite;
import com.qiuxs.cuteframework.core.basic.utils.ExceptionUtils;
import com.qiuxs.cuteframework.core.basic.utils.NumberUtils;
import com.qiuxs.cuteframework.core.basic.utils.StringUtils;
import com.qiuxs.cuteframework.core.basic.utils.security.MD5Util;
import com.qiuxs.cuteframework.core.context.UserContext;
import com.qiuxs.cuteframework.core.persistent.database.modal.BaseField;
import com.qiuxs.cuteframework.core.persistent.database.modal.PropertyWrapper;
import com.qiuxs.cuteframework.core.persistent.database.service.AbstractDataPropertyService;
import com.qiuxs.cuteframework.core.persistent.database.service.filter.IServiceFilter;
import com.qiuxs.cuteframework.core.persistent.database.service.filter.impl.IdGenerateFilter;

/**
 * 服务类
 *
 * @author qiuxs
 *
 */
@Service
public class UserService extends AbstractDataPropertyService<Long, User, UserDao> implements IUserService {

	private static final String TABLE_NAME = "user";

	public UserService() {
		super(Long.class, User.class, TABLE_NAME);
	}

	@Resource
	private UserDao userDao;

	@Override
	protected UserDao getDao() {
		return this.userDao;
	}

	@Override
	public User getByPhone(String phone, boolean must) {
		User user = this.getDao().getByPhone(phone);
		if (user == null && must) {
			ExceptionUtils.throwLogicalException("user_not_exists", phone);
		}
		return user;
	}

	@Override
	@Transactional
	public void resetPass(String oldPass, String pass) {
		UserLite userLite = UserContext.getUserLite();
		User user = this.getById(userLite.getUserId());
		if (!user.getPassword().equals(MD5Util.MD5Encode(oldPass, Constants.DEFAULT_CHARSET))) {
			ExceptionUtils.throwLogicalException("旧密码错误");
		}
		user.setPassword(MD5Util.MD5Encode(pass, Constants.DEFAULT_CHARSET));
		this.update(user);
	}

	@Override
	@Transactional
	public void updatePass(String phone, String pass) {
		User user = this.getByPhone(phone, true);
		user.setPassword(MD5Util.MD5Encode(pass, Constants.DEFAULT_CHARSET));
		this.update(user);
	}

	@Override
	@Transactional
	public void register(String phone, String pass, String verifyCode, String referee) {
		User oldUser = this.getByPhone(phone, false);
		if (oldUser != null) {
			ExceptionUtils.throwLogicalException("phone_alread_exists", phone);
		}
		User user = new User();
		user.setStatus(Constants.TRUE);
		user.setPhone(phone);
		user.setPassword(MD5Util.MD5Encode(pass, Constants.DEFAULT_CHARSET));
		// 普通用户
		user.setLevel(BizConstants.LEVEL_USER);
		// 推荐人
		if (StringUtils.isNotBlank(referee)) {
			User refereer = this.getByPhone(referee, false);
			if (refereer != null) {
				user.setRefereeId(refereer.getId());
			} else {
				ExceptionUtils.throwLogicalException("refereer_not_exists", referee);
			}
		}
		this.setId(user);
		// 
		StringBuilder levelCode = new StringBuilder();
		levelCode.append(".");
		if (!NumberUtils.isEmpty(user.getRefereeId())) {
			levelCode.append(user.getRefereeId()).append(".");
		}
		levelCode.append(user.getId()).append(".");
		user.setLevelCode(levelCode.toString());
		this.create(user);
	}

	@Override
	protected void initServiceFilters(List<IServiceFilter<Long, User>> serviceFilters) {
		serviceFilters.add(new IdGenerateFilter<>(TABLE_NAME));
	}

	@Override
	public String getCaption(Long code) {
		User user = this.getById(code);
		if (user != null) {
			return user.getName();
		}
		return null;
	}

	@Override
	protected void initProps(List<PropertyWrapper<?>> props) {
		PropertyWrapper<?> prop = null;

		prop = new PropertyWrapper<Long>(new BaseField("id", "id", Long.class), null);
		props.add(prop);

		prop = new PropertyWrapper<String>(new BaseField("phone", "手机号", String.class), null);
		props.add(prop);

		prop = new PropertyWrapper<String>(new BaseField("password", "密码", String.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Long>(new BaseField("refereeId", "推荐人ID", Long.class), this);
		props.add(prop);

		prop = new PropertyWrapper<Integer>(new BaseField("level", "等级", Integer.class), BizConstants.LEVEL_TRANSTALER);
		props.add(prop);

		prop = new PropertyWrapper<String>(new BaseField("levelCode", "等级编码", String.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Integer>(new BaseField("status", "状态", Integer.class), BizConstants.STATUS_TRANSTLATER);
		props.add(prop);

		prop = new PropertyWrapper<String>(new BaseField("name", "用户姓名", String.class), null);
		props.add(prop);

		prop = new PropertyWrapper<String>(new BaseField("alipayNo", "支付宝账号", String.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Date>(new BaseField("createdTime", "创建时间", Date.class), null);
		props.add(prop);

	}

}
