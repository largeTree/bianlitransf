package com.bianlitransf.biz.entity;

import java.util.Date;
import java.math.BigDecimal;

import com.qiuxs.cuteframework.core.persistent.database.entity.impl.AbstractEntity;

/**
 * 实体类
 *	for table exchange_bill
 * @author fankaidi
 *
 */

public class ExchangeBill extends AbstractEntity<Long> {

	/** 所有者 */
	private Long ownerId;

	/** 状态 */
	private Integer status;

	/** 银行ID */
	private Integer bankId;

	/** 兑换积分 */
	private Integer score;

	/** 兑换金 */
	private BigDecimal money;

	/** 确认时间 */
	private Date confirmTime;

	/** 确认操作人 */
	private Long confirmerId;

	/** 描述 */
	private String desc;


	/**
	 * get the 所有者
	 * @return ownerId
	 */
	public Long getOwnerId() {
		return this.ownerId;
	}

	/**
	 * set the 所有者
	 * @param ownerId
	 */
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
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
	 * get the 银行ID
	 * @return bankId
	 */
	public Integer getBankId() {
		return this.bankId;
	}

	/**
	 * set the 银行ID
	 * @param bankId
	 */
	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}

	/**
	 * get the 兑换积分
	 * @return score
	 */
	public Integer getScore() {
		return this.score;
	}

	/**
	 * set the 兑换积分
	 * @param score
	 */
	public void setScore(Integer score) {
		this.score = score;
	}

	/**
	 * get the 兑换金
	 * @return money
	 */
	public BigDecimal getMoney() {
		return this.money;
	}

	/**
	 * set the 兑换金
	 * @param money
	 */
	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	/**
	 * get the 确认时间
	 * @return confirmTime
	 */
	public Date getConfirmTime() {
		return this.confirmTime;
	}

	/**
	 * set the 确认时间
	 * @param confirmTime
	 */
	public void setConfirmTime(Date confirmTime) {
		this.confirmTime = confirmTime;
	}

	/**
	 * get the 确认操作人
	 * @return confirmerId
	 */
	public Long getConfirmerId() {
		return this.confirmerId;
	}

	/**
	 * set the 确认操作人
	 * @param confirmerId
	 */
	public void setConfirmerId(Long confirmerId) {
		this.confirmerId = confirmerId;
	}

	/**
	 * get the 描述
	 * @return desc
	 */
	public String getDesc() {
		return this.desc;
	}

	/**
	 * set the 描述
	 * @param desc
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

}