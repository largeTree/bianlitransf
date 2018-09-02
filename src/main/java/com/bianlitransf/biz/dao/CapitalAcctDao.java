package com.bianlitransf.biz.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.qiuxs.cuteframework.core.persistent.database.dao.IBaseDao;
import com.bianlitransf.biz.entity.CapitalAcct;

/**
 * Dao接口
 *
 * @author qiuxs
 *
 */
@Repository
public interface CapitalAcctDao extends IBaseDao<Long, CapitalAcct> {

	CapitalAcct getByOwnerId(@Param("ownerId") Long ownerId);

}
