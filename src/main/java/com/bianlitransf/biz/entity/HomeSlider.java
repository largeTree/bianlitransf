package com.bianlitransf.biz.entity;

import com.qiuxs.cuteframework.core.persistent.database.entity.impl.AbstractEntity;

/**
 * 首页滚动图实体类
 *	for table home_slider
 * @author qiuxs
 *
 */

public class HomeSlider extends AbstractEntity<Long> {

	private static final long serialVersionUID = 1L;

	/** 图片ID */
	private Long docId;

	/** 标题 */
	private String title;

	/** 具体内容 */
	private String target;

	/** 备注 */
	private String rem;

	/**
	 * get the 图片ID
	 * @return docId
	 */
	public Long getDocId() {
		return this.docId;
	}

	/**
	 * set the 图片ID
	 * @param docId
	 */
	public void setDocId(Long docId) {
		this.docId = docId;
	}

	/**
	 * get the 标题
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * set the 标题
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * get the 具体内容
	 * @return target
	 */
	public String getTarget() {
		return this.target;
	}

	/**
	 * set the 具体内容
	 * @param target
	 */
	public void setTarget(String target) {
		this.target = target;
	}

	/**
	 * get the 备注
	 * @return rem
	 */
	public String getRem() {
		return rem;
	}

	/**
	 * set the 备注
	 * @param rem
	 */
	public void setRem(String rem) {
		this.rem = rem;
	}

}