package com.bianlitransf.biz.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qiuxs.cuteframework.web.WebConstants;
import com.qiuxs.cuteframework.web.controller.AbstractDataController;

import com.bianlitransf.biz.dao.ScoreExchangeClassDao;
import com.bianlitransf.biz.entity.ScoreExchangeClass;
import com.bianlitransf.biz.service.IScoreExchangeClassService;

/**
 * 控制器
 *
 * @author fankaidi
 *
 */
@RestController
@RequestMapping(value = WebConstants.DEFAULT_API_PREFIX + "/scoreexchangeclass", produces = WebConstants.DEFAULT_REQUEST_PRODUCES)
public class ScoreExchangeClassController extends AbstractDataController<Long, ScoreExchangeClass, ScoreExchangeClassDao, IScoreExchangeClassService> {

	@Resource
	private IScoreExchangeClassService scoreexchangeclassService;

	@Override
	protected IScoreExchangeClassService getService() {
		return this.scoreexchangeclassService;
	}

}
