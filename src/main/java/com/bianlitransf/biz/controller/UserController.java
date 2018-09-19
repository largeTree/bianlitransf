package com.bianlitransf.biz.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bianlitransf.biz.BizConstants;
import com.bianlitransf.biz.dao.UserDao;
import com.bianlitransf.biz.entity.CapitalAcct;
import com.bianlitransf.biz.entity.User;
import com.bianlitransf.biz.service.ICapitalAcctService;
import com.bianlitransf.biz.service.IExchangeBillService;
import com.bianlitransf.biz.service.IUserService;
import com.qiuxs.cuteframework.core.basic.utils.DateFormatUtils;
import com.qiuxs.cuteframework.core.basic.utils.MapUtils;
import com.qiuxs.cuteframework.core.context.UserContext;
import com.qiuxs.cuteframework.core.persistent.database.dao.page.PageInfo;
import com.qiuxs.cuteframework.web.WebConstants;
import com.qiuxs.cuteframework.web.annotation.Api;
import com.qiuxs.cuteframework.web.bean.ListResult;
import com.qiuxs.cuteframework.web.controller.AbstractDataController;

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

	@Resource
	private ICapitalAcctService capitalAcctService;

	@Resource
	private IExchangeBillService exchangeBillService;

	@Api
	public Map<String, Object> myReflection() {
		Long userId = UserContext.getUserId();
		User user = this.getService().getById(userId);
		BigDecimal score = this.exchangeBillService.summaryScore(userId);
		String level = null;
		if (user.getLevel() == BizConstants.LEVEL_USER) {
			level = "用户";
		} else {
			level = "会员";
		}
		CapitalAcct acctMustByOwner = capitalAcctService.getAcctMustByOwner(userId);
		BigDecimal totalMoney = acctMustByOwner.getBalMoney().add(acctMustByOwner.getCashinMoney())
				.add(acctMustByOwner.getBlkMoney());
		Map<String, Object> retMap = MapUtils.genMap("level", level, "score", score, "money", totalMoney, "date",
				DateFormatUtils.formatDate(user.getCreatedTime()));
		return retMap;
	}

	@Api
	public List<User> myTeam(PageInfo pageInfo) {
		List<User> users = this.getService().findByMap(MapUtils.genMap("refereeId", UserContext.getUserId(),
				"status", BizConstants.STATUS_VALID),
				pageInfo);
		for (User user : users) {
			user.setName(user.getName().charAt(0) + "**");
			user.setPhone(user.getPhone().substring(0, 3) + "****" + user.getPhone().substring(7, 11));
			user.setPassword(null);
		}
		return users;
	}

	@Api
	public User myInviter() {
		User user = this.getService().getById(UserContext.getUserId());
		if (user.getRefereeId() > 0) {
			User inviter = this.getService().getById(user.getRefereeId());
			inviter.setPhone(inviter.getPhone().substring(0, 3) + "^_^" + inviter.getPhone().substring(7, 11));
			inviter.setPassword(null);
			return inviter;
		}
		return null;
	}

	@Override
	public ListResult list(Map<String, String> params, PageInfo pageInfo) {
		User curUser = this.userService.getById(UserContext.getUserId());
		// 不等于超级管理员的用户查询用户列表时不能查询到超级管理员
		if (curUser.getLevel() != BizConstants.LEVEL_SA) {
			params.put("levelGte", String.valueOf(BizConstants.LEVEL_ADMIN));
		}
		ListResult list = super.list(params, pageInfo);
		List<?> userList = list.getList();
		for (Object user : userList) {
			((User) user).setPassword(null);
		}
		return list;
	}

	@Api
	public Map<String, Object> getSelfInfo() {
		User self = this.getService().getById(UserContext.getUserId());
		CapitalAcct acct = this.capitalAcctService.getAcctMustByOwner(self.getId());
		return MapUtils.genMap("name", self.getName(), "alipayNo", self.getAlipayNo(), "balMoney", acct.getBalMoney());
	}

	@Override
	protected IUserService getService() {
		return this.userService;
	}

}
