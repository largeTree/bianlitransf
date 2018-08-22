package com.bianlitransf.biz.entity;

import com.qiuxs.cuteframework.core.persistent.database.entity.impl.AbstractEntity;

/**
 * 实体类
 *	for table user
 * @author qiuxs
 *
 */

public class User extends AbstractEntity<Long> {
	
	private static final long serialVersionUID = 1203797632251575994L;

	/** 手机号 */
	private String phone;

	/** 密码 */
	private String password;

	/** 推荐人ID */
	private Long refereeId;

	/** 等级 */
	private Integer level;

	/** 等级编码 */
	private String levelCode;

	/** 状态 */
	private Integer status;

	/** 用户姓名 */
	private String name;

	/** 支付宝账号 */
	private String alipayNo;


	/**
	 * get the 手机号
	 * @return phone
	 */
	public String getPhone() {
		return this.phone;
	}

	/**
	 * set the 手机号
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * get the 密码
	 * @return password
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * set the 密码
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * get the 推荐人ID
	 * @return refereeId
	 */
	public Long getRefereeId() {
		return this.refereeId;
	}

	/**
	 * set the 推荐人ID
	 * @param refereeId
	 */
	public void setRefereeId(Long refereeId) {
		this.refereeId = refereeId;
	}

	/**
	 * get the 等级
	 * @return level
	 */
	public Integer getLevel() {
		return this.level;
	}

	/**
	 * set the 等级
	 * @param level
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}

	/**
	 * get the 等级编码
	 * @return levelCode
	 */
	public String getLevelCode() {
		return this.levelCode;
	}

	/**
	 * set the 等级编码
	 * @param levelCode
	 */
	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}

	/**
	 * get the 状态
	 * @return status
	 */
	public Integer getStatus() {
		return this.status;
	}

	/**
	 * set the 状态
	 * @param status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * get the 用户姓名
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * set the 用户姓名
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * get the 支付宝账号
	 * @return alipayNo
	 */
	public String getAlipayNo() {
		return this.alipayNo;
	}

	/**
	 * set the 支付宝账号
	 * @param alipayNo
	 */
	public void setAlipayNo(String alipayNo) {
		this.alipayNo = alipayNo;
	}

}