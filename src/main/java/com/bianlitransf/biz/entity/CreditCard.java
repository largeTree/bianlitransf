package com.bianlitransf.biz.entity;


import com.qiuxs.cuteframework.core.persistent.database.entity.impl.AbstractEntity;

/**
 * 实体类
 *	for table credit_card
 * @author qiuxs
 *
 */

public class CreditCard extends AbstractEntity<Long> {

	private static final long serialVersionUID = 1L;
	
	/** 图标 */
	private String iconUrl;

	/** 银行名 */
	private String name;

	/** 目标地址 */
	private String targetUrl;


	/**
	 * get the 图标
	 * @return iconUrl
	 */
	public String getIconUrl() {
		return this.iconUrl;
	}

	/**
	 * set the 图标
	 * @param iconUrl
	 */
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	/**
	 * get the 银行名
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * set the 银行名
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * get the 目标地址
	 * @return targetUrl
	 */
	public String getTargetUrl() {
		return this.targetUrl;
	}

	/**
	 * set the 目标地址
	 * @param targetUrl
	 */
	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}

}