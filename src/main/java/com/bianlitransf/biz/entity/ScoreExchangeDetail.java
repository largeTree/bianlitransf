package com.bianlitransf.biz.entity;

import java.math.BigDecimal;

import com.qiuxs.cuteframework.core.persistent.database.entity.impl.AbstractEntity;

/**
 * 实体类
 *	for table score_exchange_detail
 * @author fankaidi
 *
 */

public class ScoreExchangeDetail extends AbstractEntity<Long> {

	private static final long serialVersionUID = -7713887828201148475L;

	/** 积分兑换类目ID */
	private Long classId;

	/** 所需积分数量 */
	private Integer score;

	/** 兑换券名称 */
	private String name;

	/** 兑换次数说明 */
	private String count;

	/** 普通会员价格 */
	private BigDecimal price1;

	/** 贵宾会员价格 */
	private BigDecimal price2;

	/** 当前价格 */
	private BigDecimal price;

	/**
	 * get the 积分兑换类目ID
	 * @return classId
	 */
	public Long getClassId() {
		return this.classId;
	}

	/**
	 * set the 积分兑换类目ID
	 * @param classId
	 */
	public void setClassId(Long classId) {
		this.classId = classId;
	}

	/**
	 * get the 所需积分数量
	 * @return score
	 */
	public Integer getScore() {
		return this.score;
	}

	/**
	 * set the 所需积分数量
	 * @param score
	 */
	public void setScore(Integer score) {
		this.score = score;
	}

	/**
	 * get the 兑换券名称
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * set the 兑换券名称
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * get the 兑换次数说明
	 * @return count
	 */
	public String getCount() {
		return count;
	}

	/**
	 * set the 兑换次数说明
	 * @param count
	 */
	public void setCount(String count) {
		this.count = count;
	}

	/**
	 * get the 普通会员价格
	 * @return price1
	 */
	public BigDecimal getPrice1() {
		return this.price1;
	}

	/**
	 * set the 普通会员价格
	 * @param price1
	 */
	public void setPrice1(BigDecimal price1) {
		this.price1 = price1;
	}

	/**
	 * get the 贵宾会员价格
	 * @return price2
	 */
	public BigDecimal getPrice2() {
		return this.price2;
	}

	/**
	 * set the 贵宾会员价格
	 * @param price2
	 */
	public void setPrice2(BigDecimal price2) {
		this.price2 = price2;
	}

	/**
	 * get the 当前价格
	 * @return price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * set the 当前价格
	 * @param price
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}