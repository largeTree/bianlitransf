package com.bianlitransf.biz.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bianlitransf.biz.dao.ScoreExchangeClassDao;
import com.bianlitransf.biz.entity.ScoreExchangeClass;
import com.bianlitransf.biz.service.IScoreExchangeClassService;
import com.qiuxs.cuteframework.core.basic.utils.MapUtils;
import com.qiuxs.cuteframework.core.persistent.database.dao.page.PageInfo;
import com.qiuxs.cuteframework.web.WebConstants;
import com.qiuxs.cuteframework.web.annotation.Api;
import com.qiuxs.cuteframework.web.controller.AbstractDataController;
import com.qiuxs.cuteframework.web.controller.api.Param;

/**
 * 控制器
 *
 * @author fankaidi
 *
 */
@RestController
@RequestMapping(value = WebConstants.DEFAULT_API_PREFIX
		+ "/scoreexchangeclass", produces = WebConstants.DEFAULT_REQUEST_PRODUCES)
public class ScoreExchangeClassController
		extends AbstractDataController<Long, ScoreExchangeClass, ScoreExchangeClassDao, IScoreExchangeClassService> {

	@Resource
	private IScoreExchangeClassService scoreexchangeclassService;

	@Api
	public List<ScoreExchangeClass> findByExgId(@Param("exgId") Long exgId, PageInfo pageInfo) {
		List<ScoreExchangeClass> classes = this.scoreexchangeclassService.findByMap(MapUtils.genMap("scoreExid", exgId),
				pageInfo);
		return classes;
	}

	@Override
	protected IScoreExchangeClassService getService() {
		return this.scoreexchangeclassService;
	}

}
