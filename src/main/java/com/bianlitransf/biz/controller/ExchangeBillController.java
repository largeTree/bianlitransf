package com.bianlitransf.biz.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qiuxs.cuteframework.web.WebConstants;
import com.qiuxs.cuteframework.web.annotation.Api;
import com.qiuxs.cuteframework.web.controller.AbstractDataController;
import com.qiuxs.cuteframework.web.controller.api.Param;
import com.bianlitransf.biz.dao.ExchangeBillDao;
import com.bianlitransf.biz.entity.ExchangeBill;
import com.bianlitransf.biz.service.IExchangeBillService;

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
