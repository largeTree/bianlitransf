package com.bianlitransf.biz.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bianlitransf.biz.dao.ScoreExchangeDao;
import com.bianlitransf.biz.entity.ScoreExchange;
import com.bianlitransf.biz.service.IScoreExchangeService;
import com.qiuxs.cuteframework.web.WebConstants;
import com.qiuxs.cuteframework.web.controller.AbstractDataController;

/**
 * 控制器
 *
 * @author fankaidi
 *
 */
@RestController
@RequestMapping(value = WebConstants.DEFAULT_API_PREFIX + "/scoreexchange", produces = WebConstants.DEFAULT_REQUEST_PRODUCES)
public class ScoreExchangeController extends AbstractDataController<Long, ScoreExchange, ScoreExchangeDao, IScoreExchangeService> {

	@Resource
	private IScoreExchangeService scoreexchangeService;

	@Override
	protected IScoreExchangeService getService() {
		return this.scoreexchangeService;
	}

}
