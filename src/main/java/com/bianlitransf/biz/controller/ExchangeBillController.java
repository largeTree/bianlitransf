package com.bianlitransf.biz.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qiuxs.cuteframework.web.WebConstants;
import com.qiuxs.cuteframework.web.controller.AbstractDataController;

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
@RequestMapping(value = WebConstants.DEFAULT_API_PREFIX + "/exchangebill", produces = WebConstants.DEFAULT_REQUEST_PRODUCES)
public class ExchangeBillController extends AbstractDataController<Long, ExchangeBill, ExchangeBillDao, IExchangeBillService> {

	@Resource
	private IExchangeBillService exchangebillService;

	@Override
	protected IExchangeBillService getService() {
		return this.exchangebillService;
	}

}
