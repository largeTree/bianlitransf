package com.bianlitransf.biz.service;

import com.bianlitransf.biz.dao.UserDao;
import com.bianlitransf.biz.entity.User;
import com.qiuxs.cuteframework.core.persistent.database.service.ifc.IDataPropertyService;

public interface IUserService extends IDataPropertyService<Long, User, UserDao> {

	public User getByPhone(String phone, boolean must);

	public void register(String phone, String pass, String verifyCode, String referee);

	public void updatePass(String phone, String pass);

	public void resetPass(String oldPass, String pass);
	
}
