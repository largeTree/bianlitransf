package com.bianlitransf.biz.dao;

import org.springframework.stereotype.Repository;

import com.qiuxs.cuteframework.core.persistent.database.dao.IBaseDao;
import com.bianlitransf.biz.entity.HomeSlider;

/**
 * 首页滚动图Dao接口
 *
 * @author qiuxs
 *
 */
@Repository
public interface HomeSliderDao extends IBaseDao<Long, HomeSlider> {

}
