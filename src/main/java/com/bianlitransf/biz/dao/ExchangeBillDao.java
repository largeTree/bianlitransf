package com.bianlitransf.biz.dao;

import org.springframework.stereotype.Repository;

import com.qiuxs.cuteframework.core.persistent.database.dao.IBaseDao;
import com.bianlitransf.biz.entity.ExchangeBill;

/**
 * Dao接口
 *
 * @author qiuxs
 *
 */
@Repository
public interface ExchangeBillDao extends IBaseDao<Long, ExchangeBill> {

}
