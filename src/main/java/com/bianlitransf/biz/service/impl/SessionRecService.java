package com.bianlitransf.biz.service.impl;

import java.util.List;
import javax.annotation.Resource;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.qiuxs.cuteframework.core.persistent.database.modal.PropertyWrapper;
import com.qiuxs.cuteframework.core.basic.bean.UserLite;
import com.qiuxs.cuteframework.core.basic.utils.JsonUtils;
import com.qiuxs.cuteframework.core.persistent.database.modal.BaseField;
import com.qiuxs.cuteframework.core.persistent.database.service.AbstractDataPropertyService;
import com.qiuxs.cuteframework.core.persistent.database.service.filter.IServiceFilter;
import com.qiuxs.cuteframework.core.persistent.database.service.filter.impl.IdGenerateFilter;
import com.bianlitransf.biz.dao.SessionRecDao;
import com.bianlitransf.biz.entity.SessionRec;
import com.bianlitransf.biz.service.ISessionRecService;
/**
 * 服务类
 *
 * @author qiuxs
 *
 */
@Service
public class SessionRecService extends AbstractDataPropertyService<Long, SessionRec, SessionRecDao> implements ISessionRecService {

	private static final String TABLE_NAME = "session_rec";

	public SessionRecService() {
		super(Long.class, SessionRec.class, TABLE_NAME);
	}

	@Resource
	private SessionRecDao sessionRecDao;

	@Override
	protected SessionRecDao getDao() {
		return this.sessionRecDao;
	}
	
	@Override
	public void deleteSession(String sessionId) {
		this.getDao().deleteBySessionId(sessionId);
	}
	
	@Override
	protected boolean preCreate(SessionRec bean) {
		// 每个用户仅允许一个会话，保存前先删除原来的
		this.getDao().deleteByUserId(bean.getUserId());
		return super.preCreate(bean);
	}
	
	@Override
	public UserLite loadSession(String sessionId) {
		SessionRec sessionRec = this.getDao().getBySessionId(sessionId);
		if (sessionRec != null) {
			return JsonUtils.parseObject(sessionRec.getSessionBean(), UserLite.class);
		}
		return null;
	}
	
	@Override
	protected void initServiceFilters(List<IServiceFilter<Long, SessionRec>> serviceFilters) {
		serviceFilters.add(new IdGenerateFilter<>(TABLE_NAME));
	}

	@Override
	protected void initProps(List<PropertyWrapper<?>> props) {
		PropertyWrapper<?> prop = null;

		prop = new PropertyWrapper<Long>(new BaseField("id", "id", Long.class), null);
		props.add(prop);

		prop = new PropertyWrapper<String>(new BaseField("sessionId", "sessionId", String.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Long>(new BaseField("userId", "用户ID", Long.class), null);
		props.add(prop);

		prop = new PropertyWrapper<String>(new BaseField("sessionBean", "会话对象json", String.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Date>(new BaseField("loginTime", "登陆时间", Date.class), null);
		props.add(prop);

	}

}
