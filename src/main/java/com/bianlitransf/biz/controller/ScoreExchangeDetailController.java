package com.bianlitransf.biz.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qiuxs.cuteframework.web.WebConstants;
import com.qiuxs.cuteframework.web.controller.AbstractDataController;

import com.bianlitransf.biz.dao.ScoreExchangeDetailDao;
import com.bianlitransf.biz.entity.ScoreExchangeDetail;
import com.bianlitransf.biz.service.IScoreExchangeDetailService;

/**
 * 控制器
 *
 * @author fankaidi
 *
 */
@RestController
@RequestMapping(value = WebConstants.DEFAULT_API_PREFIX + "/scoreexchangedetail", produces = WebConstants.DEFAULT_REQUEST_PRODUCES)
public class ScoreExchangeDetailController extends AbstractDataController<Long, ScoreExchangeDetail, ScoreExchangeDetailDao, IScoreExchangeDetailService> {

	@Resource
	private IScoreExchangeDetailService scoreexchangedetailService;

	@Override
	protected IScoreExchangeDetailService getService() {
		return this.scoreexchangedetailService;
	}

}
