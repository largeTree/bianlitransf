package com.bianlitransf.biz.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qiuxs.cuteframework.web.WebConstants;
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
@RequestMapping(value = WebConstants.DEFAULT_API_PREFIX + "/capitalacct", produces = WebConstants.DEFAULT_REQUEST_PRODUCES)
public class CapitalAcctController extends AbstractDataController<Long, CapitalAcct, CapitalAcctDao, ICapitalAcctService> {

	@Resource
	private ICapitalAcctService capitalacctService;

	@Override
	protected ICapitalAcctService getService() {
		return this.capitalacctService;
	}

}
