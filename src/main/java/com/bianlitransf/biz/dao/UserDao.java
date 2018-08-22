package com.bianlitransf.biz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.qiuxs.cuteframework.core.persistent.database.dao.IBaseDao;
import com.bianlitransf.biz.entity.User;

/**
 * Dao接口
 *
 * @author qiuxs
 *
 */
@Repository
public interface UserDao extends IBaseDao<Long, User> {

	/**
	 * 根据手机号获取用户
	 * @author qiuxs
	 *
	 * @param phone
	 * @return
	 *
	 * 创建时间：2018年8月20日 下午6:23:31
	 */
	public User getByPhone(@Param("phone") String phone);
	
	/**
	 * 根据手机号获取下级
	 * @author qiuxs
	 *
	 * @param phone
	 * @return
	 *
	 * 创建时间：2018年8月20日 下午6:24:05
	 */
	public List<User> getFollower(@Param("phone") String phone);

}
