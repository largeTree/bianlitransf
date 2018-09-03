package com.bianlitransf.biz.controller;

import java.math.BigDecimal;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qiuxs.cuteframework.core.basic.utils.MapUtils;
import com.qiuxs.cuteframework.core.context.UserContext;
import com.qiuxs.cuteframework.web.WebConstants;
import com.qiuxs.cuteframework.web.annotation.Api;
import com.qiuxs.cuteframework.web.controller.AbstractDataController;

import com.bianlitransf.biz.dao.CapitalAcctDao;
import com.bianlitransf.biz.entity.CapitalAcct;
import com.bianlitransf.biz.service.ICapitalAcctService;

/**
 * 控制器
 *
 * @author qiuxs
 *
 */
@RestController
@RequestMapping(value = WebConstants.DEFAULT_API_PREFIX
		+ "/capitalacct", produces = WebConstants.DEFAULT_REQUEST_PRODUCES)
public class CapitalAcctController
		extends AbstractDataController<Long, CapitalAcct, CapitalAcctDao, ICapitalAcctService> {

	@Resource
	private ICapitalAcctService capitalacctService;

	@Api
	public Map<String, Object> capitalInfo() {
		CapitalAcct acct = this.getService().getAcctMustByOwner(UserContext.getUserId());
		BigDecimal balMoney = acct.getBalMoney(); // 可用余额
		BigDecimal blkMoney = acct.getBlkMoney(); // 锁定金额，一般是正在提现中的金额
		BigDecimal totalMoney = balMoney.add(acct.getCashinMoney()); // 总金额
		
		Map<String, Object> capitalInfo = MapUtils.genMap("totalMoney", totalMoney, 
				"balMoney", balMoney, 
				"blkMoney", blkMoney);
		return capitalInfo;
	}

	@Override
	protected ICapitalAcctService getService() {
		return this.capitalacctService;
	}

}
