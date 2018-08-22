package com.bianlitransf.biz.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qiuxs.cuteframework.web.WebConstants;
import com.qiuxs.cuteframework.web.controller.AbstractDataController;

import com.bianlitransf.biz.dao.ResourcesDao;
import com.bianlitransf.biz.entity.Resources;
import com.bianlitransf.biz.service.IResourcesService;

/**
 * 控制器
 *
 * @author qiuxs
 *
 */
@RestController
@RequestMapping(value = WebConstants.DEFAULT_API_PREFIX + "/resources", produces = WebConstants.DEFAULT_REQUEST_PRODUCES)
public class ResourcesController extends AbstractDataController<Long, Resources, ResourcesDao, IResourcesService> {

	@Resource
	private IResourcesService resourcesService;

	@Override
	protected IResourcesService getService() {
		return this.resourcesService;
	}

}
