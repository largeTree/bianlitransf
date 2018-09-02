package com.bianlitransf.biz.service;

import com.bianlitransf.biz.dao.SessionRecDao;
import com.bianlitransf.biz.entity.SessionRec;
import com.qiuxs.cuteframework.core.basic.bean.UserLite;
import com.qiuxs.cuteframework.core.persistent.database.service.ifc.IDataPropertyService;

public interface ISessionRecService extends IDataPropertyService<Long, SessionRec, SessionRecDao> {

	/***
	 * 从数据库中加载会话
	 * @author qiuxs
	 *
	 * @param sessionId
	 * @return
	 *
	 * 创建时间：2018年9月2日 下午10:14:46
	 */
	public UserLite loadSession(String sessionId);

	/**
	 * 删除数据库中的会话
	 * @author qiuxs
	 *
	 * @param sessionId
	 *
	 * 创建时间：2018年9月2日 下午10:14:58
	 */
	public void deleteSession(String sessionId);

}
