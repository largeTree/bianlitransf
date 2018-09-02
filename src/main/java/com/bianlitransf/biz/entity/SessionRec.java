package com.bianlitransf.biz.entity;

import java.util.Date;

import com.qiuxs.cuteframework.core.persistent.database.entity.impl.AbstractEntity;

/**
 * 实体类
 *	for table session_rec
 * @author qiuxs
 *
 */

public class SessionRec extends AbstractEntity<Long> {

	private static final long serialVersionUID = 1L;
	
	/** sessionId */
	private String sessionId;

	/** 用户ID */
	private Long userId;

	/** 会话对象json */
	private String sessionBean;

	/** 登陆时间 */
	private Date loginTime;


	/**
	 * get the sessionId
	 * @return sessionId
	 */
	public String getSessionId() {
		return this.sessionId;
	}

	/**
	 * set the sessionId
	 * @param sessionId
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * get the 用户ID
	 * @return userId
	 */
	public Long getUserId() {
		return this.userId;
	}

	/**
	 * set the 用户ID
	 * @param userId
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * get the 会话对象json
	 * @return sessionBean
	 */
	public String getSessionBean() {
		return this.sessionBean;
	}

	/**
	 * set the 会话对象json
	 * @param sessionBean
	 */
	public void setSessionBean(String sessionBean) {
		this.sessionBean = sessionBean;
	}

	/**
	 * get the 登陆时间
	 * @return loginTime
	 */
	public Date getLoginTime() {
		return this.loginTime;
	}

	/**
	 * set the 登陆时间
	 * @param loginTime
	 */
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

}