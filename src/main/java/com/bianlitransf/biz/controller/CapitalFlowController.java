package com.bianlitransf.biz.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qiuxs.cuteframework.web.WebConstants;
import com.qiuxs.cuteframework.web.controller.AbstractDataController;

import com.bianlitransf.biz.dao.CapitalFlowDao;
import com.bianlitransf.biz.entity.CapitalFlow;
import com.bianlitransf.biz.service.ICapitalFlowService;

/**
 * 控制器
 *
 * @author fankaidi
 *
 */
@RestController
@RequestMapping(value = WebConstants.DEFAULT_API_PREFIX + "/capitalflow", produces = WebConstants.DEFAULT_REQUEST_PRODUCES)
public class CapitalFlowController extends AbstractDataController<Long, CapitalFlow, CapitalFlowDao, ICapitalFlowService> {

	@Resource
	private ICapitalFlowService capitalflowService;

	@Override
	protected ICapitalFlowService getService() {
		return this.capitalflowService;
	}

}
