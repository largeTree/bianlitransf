package com.bianlitransf.biz.entity;

import com.qiuxs.cuteframework.core.persistent.database.entity.impl.AbstractEntity;

/**
 * 附件表实体类
 *	for table attachment
 * @author qiuxs
 *
 */

public class Attachment extends AbstractEntity<Long> {

	private static final long serialVersionUID = 1L;

	/** 存储路径 */
	private String path;

	/** 文件名 */
	private String name;

	/**
	 * get the 存储路径
	 * @return path
	 */
	public String getPath() {
		return this.path;
	}

	/**
	 * set the 存储路径
	 * @param path
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * get the 文件名
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * set the 文件名
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

}