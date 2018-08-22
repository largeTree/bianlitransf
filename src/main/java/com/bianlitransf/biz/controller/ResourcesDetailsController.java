package com.bianlitransf.biz.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qiuxs.cuteframework.web.WebConstants;
import com.qiuxs.cuteframework.web.controller.AbstractDataController;

import com.bianlitransf.biz.dao.ResourcesDetailsDao;
import com.bianlitransf.biz.entity.ResourcesDetails;
import com.bianlitransf.biz.service.IResourcesDetailsService;

/**
 * 控制器
 *
 * @author qiuxs
 *
 */
@RestController
@RequestMapping(value = WebConstants.DEFAULT_API_PREFIX + "/resourcesdetails", produces = WebConstants.DEFAULT_REQUEST_PRODUCES)
public class ResourcesDetailsController extends AbstractDataController<Long, ResourcesDetails, ResourcesDetailsDao, IResourcesDetailsService> {

	@Resource
	private IResourcesDetailsService resourcesdetailsService;

	@Override
	protected IResourcesDetailsService getService() {
		return this.resourcesdetailsService;
	}

}
