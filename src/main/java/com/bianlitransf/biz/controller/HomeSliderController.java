package com.bianlitransf.biz.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qiuxs.cuteframework.web.WebConstants;
import com.qiuxs.cuteframework.web.controller.AbstractDataController;

import com.bianlitransf.biz.dao.HomeSliderDao;
import com.bianlitransf.biz.entity.HomeSlider;
import com.bianlitransf.biz.service.IHomeSliderService;

/**
 * 首页滚动图控制器
 *
 * @author qiuxs
 *
 */
@RestController
@RequestMapping(value = WebConstants.DEFAULT_API_PREFIX + "/homeslider", produces = WebConstants.DEFAULT_REQUEST_PRODUCES)
public class HomeSliderController extends AbstractDataController<Long, HomeSlider, HomeSliderDao, IHomeSliderService> {

	@Resource
	private IHomeSliderService homesliderService;

	@Override
	protected IHomeSliderService getService() {
		return this.homesliderService;
	}

}
