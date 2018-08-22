package com.bianlitransf.biz.entity;

import com.qiuxs.cuteframework.core.persistent.database.entity.impl.AbstractEntity;

/**
 * 实体类
 *	for table resources_details
 * @author qiuxs
 *
 */

public class ResourcesDetails extends AbstractEntity<Long> {

	private static final long serialVersionUID = 3767425670862908871L;

	/** 资源ID */
	private Long resId;

	/** 相对路径 */
	private String relUrl;

	/** 资源类型 */
	private Integer resType;

	/** 资源目标 */
	private String target;


	/**
	 * get the 资源ID
	 * @return resId
	 */
	public Long getResId() {
		return this.resId;
	}

	/**
	 * set the 资源ID
	 * @param resId
	 */
	public void setResId(Long resId) {
		this.resId = resId;
	}

	/**
	 * get the 相对路径
	 * @return relUrl
	 */
	public String getRelUrl() {
		return this.relUrl;
	}

	/**
	 * set the 相对路径
	 * @param relUrl
	 */
	public void setRelUrl(String relUrl) {
		this.relUrl = relUrl;
	}

	/**
	 * get the 资源类型
	 * @return resType
	 */
	public Integer getResType() {
		return this.resType;
	}

	/**
	 * set the 资源类型
	 * @param resType
	 */
	public void setResType(Integer resType) {
		this.resType = resType;
	}

	/**
	 * get the 资源目标
	 * @return target
	 */
	public String getTarget() {
		return this.target;
	}

	/**
	 * set the 资源目标
	 * @param target
	 */
	public void setTarget(String target) {
		this.target = target;
	}

}