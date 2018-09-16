package com.bianlitransf.biz.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bianlitransf.biz.ScoreMinScoreDto;
import com.bianlitransf.biz.entity.ScoreExchange;
import com.qiuxs.cuteframework.core.persistent.database.dao.IBaseDao;

/**
 * Dao接口
 *
 * @author fankaidi
 *
 */
@Repository
public interface ScoreExchangeDao extends IBaseDao<Long, ScoreExchange> {

	public List<ScoreMinScoreDto> scoreExgSummary();

}
