package com.bianlitransf.biz.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qiuxs.cuteframework.web.WebConstants;
import com.qiuxs.cuteframework.web.controller.AbstractDataController;

import com.bianlitransf.biz.dao.CreditCardDao;
import com.bianlitransf.biz.entity.CreditCard;
import com.bianlitransf.biz.service.ICreditCardService;

/**
 * 控制器
 *
 * @author qiuxs
 *
 */
@RestController
@RequestMapping(value = WebConstants.DEFAULT_API_PREFIX + "/creditcard", produces = WebConstants.DEFAULT_REQUEST_PRODUCES)
public class CreditCardController extends AbstractDataController<Long, CreditCard, CreditCardDao, ICreditCardService> {

	@Resource
	private ICreditCardService creditcardService;

	@Override
	protected ICreditCardService getService() {
		return this.creditcardService;
	}

}
