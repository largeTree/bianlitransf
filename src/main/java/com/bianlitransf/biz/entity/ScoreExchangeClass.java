package com.bianlitransf.biz.entity;

import com.qiuxs.cuteframework.core.persistent.database.entity.impl.AbstractEntity;

/**
 * 实体类
 *	for table score_exchange_class
 * @author fankaidi
 *
 */

public class ScoreExchangeClass extends AbstractEntity<Long> {

	private static final long serialVersionUID = 2983386425340492250L;

	/** 积分兑换ID */
	private Long scoreExid;

	/** 名称 */
	private String name;

	/** 图标地址 */
	private String iconUrl;

	/** 资源类型，链接或html内容 */
	private Integer resType;

	/** 具体内容，链接或具体html内容 */
	private String target;


	/**
	 * get the 积分兑换ID
	 * @return scoreExid
	 */
	public Long getScoreExid() {
		return this.scoreExid;
	}

	/**
	 * set the 积分兑换ID
	 * @param scoreExid
	 */
	public void setScoreExid(Long scoreExid) {
		this.scoreExid = scoreExid;
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
	 * get the 资源类型，链接或html内容
	 * @return resType
	 */
	public Integer getResType() {
		return this.resType;
	}

	/**
	 * set the 资源类型，链接或html内容
	 * @param resType
	 */
	public void setResType(Integer resType) {
		this.resType = resType;
	}

	/**
	 * get the 具体内容，链接或具体html内容
	 * @return target
	 */
	public String getTarget() {
		return this.target;
	}

	/**
	 * set the 具体内容，链接或具体html内容
	 * @param target
	 */
	public void setTarget(String target) {
		this.target = target;
	}

}