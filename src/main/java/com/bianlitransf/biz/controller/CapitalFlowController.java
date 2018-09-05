package com.bianlitransf.biz.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qiuxs.cuteframework.core.basic.utils.MapUtils;
import com.qiuxs.cuteframework.core.persistent.database.dao.page.PageInfo;
import com.qiuxs.cuteframework.web.WebConstants;
import com.qiuxs.cuteframework.web.annotation.Api;
import com.qiuxs.cuteframework.web.controller.AbstractDataController;
import com.qiuxs.cuteframework.web.controller.api.Param;
import com.bianlitransf.biz.BizConstants;
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
@RequestMapping(value = WebConstants.DEFAULT_API_PREFIX
		+ "/capitalflow", produces = WebConstants.DEFAULT_REQUEST_PRODUCES)
public class CapitalFlowController
		extends AbstractDataController<Long, CapitalFlow, CapitalFlowDao, ICapitalFlowService> {

	@Resource
	private ICapitalFlowService capitalflowService;

	@Api
	public List<CapitalFlow> capitalFlow(@Param("inOutType") Integer inOutType, PageInfo pageInfo) {
		List<CapitalFlow> list = this.getService()
				.findByMap(MapUtils.genMap("inOutType", inOutType, 
						"type", CapitalFlow.TYPE_CUST,
						"status", BizConstants.STATUS_VALID,
						"orderBy", "createdTime desc"), pageInfo);
		return list;
	}

	@Override
	protected ICapitalFlowService getService() {
		return this.capitalflowService;
	}

}
