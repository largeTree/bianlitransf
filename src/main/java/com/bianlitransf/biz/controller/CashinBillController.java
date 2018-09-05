package com.bianlitransf.biz.controller;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bianlitransf.biz.dao.CashinBillDao;
import com.bianlitransf.biz.entity.CashinBill;
import com.bianlitransf.biz.service.ICashinBillCombService;
import com.bianlitransf.biz.service.ICashinBillService;
import com.qiuxs.cuteframework.core.basic.utils.ExceptionUtils;
import com.qiuxs.cuteframework.core.basic.utils.NumberUtils;
import com.qiuxs.cuteframework.core.basic.utils.StringUtils;
import com.qiuxs.cuteframework.web.WebConstants;
import com.qiuxs.cuteframework.web.annotation.Api;
import com.qiuxs.cuteframework.web.controller.AbstractDataController;
import com.qiuxs.cuteframework.web.controller.api.Param;

/**
 * 控制器
 *
 * @author qiuxs
 *
 */
@RestController
@RequestMapping(value = WebConstants.DEFAULT_API_PREFIX
		+ "/cashinbill", produces = WebConstants.DEFAULT_REQUEST_PRODUCES)
public class CashinBillController extends AbstractDataController<Long, CashinBill, CashinBillDao, ICashinBillService> {

	@Resource
	private ICashinBillService cashinbillService;

	@Resource
	private ICashinBillCombService cashinBillCombService;

	@Api
	public void saveCashinBill(@Param("userName") String userName, @Param("alipayNo") String alipayNo,
			@Param("money") BigDecimal money) {
		if (StringUtils.isBlank(alipayNo)) {
			ExceptionUtils.throwLogicalException("params_is_required", "支付宝");
		}
		if (StringUtils.isBlank(userName)) {
			ExceptionUtils.throwLogicalException("params_is_required", "真实姓名");
		}
		if (NumberUtils.isEmpty(money)) {
			ExceptionUtils.throwLogicalException("params_is_required", "提现金额");
		}
		this.cashinbillService.saveBill(userName, alipayNo, money);
	}

	@Api
	public void confrimBill(@Param("billId") Long billId, @Param("desc") String desc) {
		this.cashinBillCombService.confrimBill(billId, desc);
	}

	@Api
	public void refuseBill(@Param("billId") Long billId, @Param("desc") String desc) {
		this.cashinBillCombService.refuseBill(billId, desc);
	}

	@Override
	protected ICashinBillService getService() {
		return this.cashinbillService;
	}

}
