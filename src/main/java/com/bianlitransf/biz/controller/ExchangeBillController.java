package com.bianlitransf.biz.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bianlitransf.biz.dao.ExchangeBillDao;
import com.bianlitransf.biz.entity.ExchangeBill;
import com.bianlitransf.biz.service.IExchangeBillCombService;
import com.bianlitransf.biz.service.IExchangeBillService;
import com.qiuxs.cuteframework.web.WebConstants;
import com.qiuxs.cuteframework.web.annotation.Api;
import com.qiuxs.cuteframework.web.controller.AbstractDataController;
import com.qiuxs.cuteframework.web.controller.api.Param;

/**
 * 控制器
 *
 * @author fankaidi
 *
 */
@RestController
@RequestMapping(value = WebConstants.DEFAULT_API_PREFIX
		+ "/exchangebill", produces = WebConstants.DEFAULT_REQUEST_PRODUCES)
public class ExchangeBillController
		extends AbstractDataController<Long, ExchangeBill, ExchangeBillDao, IExchangeBillService> {

	@Resource
	private IExchangeBillService exchangebillService;

	@Resource
	private IExchangeBillCombService exchangeBillCombService;

	@Api
	public Map<String, Object> summaryExgBills() {
		return this.getService().summaryExgBills();
	}

	@Api
	public void confirmExchangeBill(@Param("exgBillId") Long exgBillId, @Param("desc") String desc) {
		this.exchangeBillCombService.confrimExgBill(exgBillId, desc);
	}

	@Api
	public void refuseExgBill(@Param("exgBillId") Long exgBillId, @Param("desc") String desc) {
		this.exchangeBillCombService.refuseExgBill(exgBillId, desc);
	}

	@Api
	public Long report(Map<String, String> params, @Param("jsonParam") String jsonParam) {
		ExchangeBill exchangeBill = this.fromJSON(jsonParam);
		this.getService().saveBill(params, exchangeBill);
		return exchangeBill.getId();
	}

	@Override
	protected IExchangeBillService getService() {
		return this.exchangebillService;
	}

}
