package com.bianlitransf.biz.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.qiuxs.cuteframework.core.persistent.database.dao.IBaseDao;
import com.bianlitransf.biz.entity.SessionRec;

/**
 * Dao接口
 *
 * @author qiuxs
 *
 */
@Repository
public interface SessionRecDao extends IBaseDao<Long, SessionRec> {

	public SessionRec getBySessionId(@Param("sessionId") String sessionId);

	public void deleteBySessionId(@Param("sessionId") String sessionId);

	public void deleteByUserId(@Param("userId") Long userId);

}
