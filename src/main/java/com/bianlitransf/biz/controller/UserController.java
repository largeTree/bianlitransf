package com.bianlitransf.biz.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qiuxs.cuteframework.core.context.UserContext;
import com.qiuxs.cuteframework.web.WebConstants;
import com.qiuxs.cuteframework.web.bean.ListResult;
import com.qiuxs.cuteframework.web.controller.AbstractDataController;
import com.bianlitransf.biz.BizConstants;
import com.bianlitransf.biz.dao.UserDao;
import com.bianlitransf.biz.entity.User;
import com.bianlitransf.biz.service.IUserService;

/**
 * 控制器
 *
 * @author qiuxs
 *
 */
@RestController
@RequestMapping(value = WebConstants.DEFAULT_API_PREFIX + "/user", produces = WebConstants.DEFAULT_REQUEST_PRODUCES)
public class UserController extends AbstractDataController<Long, User, UserDao, IUserService> {

	@Resource
	private IUserService userService;

	@Override
	public ListResult list(Map<String, String> params) {
		User curUser = this.userService.getById(UserContext.getUserId());
		// 不等于超级管理员的用户查询用户列表时不能查询到超级管理员
		if (curUser.getLevel() != BizConstants.LEVEL_SA) {
			params.put("levelGte", String.valueOf(BizConstants.LEVEL_ADMIN));
		}
		ListResult list = super.list(params);
		List<?> userList = list.getList();
		for (Object user : userList) {
			((User) user).setPassword(null);
		}
		return list;
	}

	@Override
	protected IUserService getService() {
		return this.userService;
	}

}
