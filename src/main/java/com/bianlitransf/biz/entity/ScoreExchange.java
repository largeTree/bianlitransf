package com.bianlitransf.biz.entity;

import com.qiuxs.cuteframework.core.persistent.database.entity.impl.AbstractEntity;

/**
 * 实体类
 *	for table score_exchange
 * @author fankaidi
 *
 */

public class ScoreExchange extends AbstractEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6687549276459551549L;

	/** 积分兑换类型 */
	private Integer type;

	/** 图标地址 */
	private String iconUrl;

	/** 名称 */
	private String name;

	/** 排序 */
	private Integer disorder;

	/** mark1 */
	private String mark1;


	/**
	 * get the 积分兑换类型
	 * @return type
	 */
	public Integer getType() {
		return this.type;
	}

	/**
	 * set the 积分兑换类型
	 * @param type
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * get the 图标地址
	 * @return iconUrl
	 */
	public String getIconUrl() {
		return this.iconUrl;
	}

	/**
	 * set the 图标地址
	 * @param iconUrl
	 */
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	/**
	 * get the 名称
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * set the 名称
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * get the 排序
	 * @return disorder
	 */
	public Integer getDisorder() {
		return this.disorder;
	}

	/**
	 * set the 排序
	 * @param disorder
	 */
	public void setDisorder(Integer disorder) {
		this.disorder = disorder;
	}

	/**
	 * get the mark1
	 * @return mark1
	 */
	public String getMark1() {
		return this.mark1;
	}

	/**
	 * set the mark1
	 * @param mark1
	 */
	public void setMark1(String mark1) {
		this.mark1 = mark1;
	}

}