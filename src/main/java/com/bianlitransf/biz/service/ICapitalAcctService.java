package com.bianlitransf.biz.service;

import com.bianlitransf.biz.dao.CapitalAcctDao;
import com.bianlitransf.biz.entity.CapitalAcct;
import com.qiuxs.cuteframework.core.persistent.database.service.ifc.IDataPropertyService;

public interface ICapitalAcctService extends IDataPropertyService<Long, CapitalAcct, CapitalAcctDao> {

	/**
	 * 根据所有者获取账户，不存在时创建
	 * @author qiuxs
	 *
	 * @param ownerId
	 * @return
	 *
	 * 创建时间：2018年9月2日 下午5:28:45
	 */
	public CapitalAcct getAcctMustByOwner(Long ownerId);

}
