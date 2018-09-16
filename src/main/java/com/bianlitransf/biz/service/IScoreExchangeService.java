package com.bianlitransf.biz.service;

import java.util.List;

import com.bianlitransf.biz.ScoreMinScoreDto;
import com.bianlitransf.biz.dao.ScoreExchangeDao;
import com.bianlitransf.biz.entity.ScoreExchange;
import com.qiuxs.cuteframework.core.persistent.database.service.ifc.IDataPropertyService;

public interface IScoreExchangeService extends IDataPropertyService<Long, ScoreExchange, ScoreExchangeDao> {
	
	public List<ScoreMinScoreDto> scoreExgSummary();
	
}
