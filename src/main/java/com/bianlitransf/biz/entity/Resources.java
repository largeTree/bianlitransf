package com.bianlitransf.biz.entity;

import com.qiuxs.cuteframework.core.persistent.database.entity.impl.AbstractEntity;

/**
 * 实体类
 *	for table resources
 * @author qiuxs
 *
 */

public class Resources extends AbstractEntity<Long> {

	private static final long serialVersionUID = 1792205383819165715L;

	/** 资源大类 */
	private Integer typeCat;

	/** 资源类型 */
	private Integer type;

	/** 图标地址 */
	private String iconUrl;

	/** 资源名 */
	private String name;


	/**
	 * get the 资源大类
	 * @return typeCat
	 */
	public Integer getTypeCat() {
		return this.typeCat;
	}

	/**
	 * set the 资源大类
	 * @param typeCat
	 */
	public void setTypeCat(Integer typeCat) {
		this.typeCat = typeCat;
	}

	/**
	 * get the 资源类型
	 * @return type
	 */
	public Integer getType() {
		return this.type;
	}

	/**
	 * set the 资源类型
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
	 * get the 资源名
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * set the 资源名
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

}