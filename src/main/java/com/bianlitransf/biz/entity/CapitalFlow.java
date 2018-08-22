package com.bianlitransf.biz.entity;

import java.util.Date;
import java.math.BigDecimal;

import com.qiuxs.cuteframework.core.persistent.database.entity.impl.AbstractEntity;

/**
 * 实体类
 *	for table capital_flow
 * @author fankaidi
 *
 */

public class CapitalFlow extends AbstractEntity<Long> {

	/** 来源单据 */
	private Long srcBill;

	/** 所有者 */
	private Long ownerId;

	/** 状态 */
	private Integer status;

	/** 业务类型 */
	private Integer bizType;

	/** 收支类型 */
	private Integer inOutType;

	/** 金额 */
	private BigDecimal money;

	/** 确认时间 */
	private Date confirmTime;

	/** 确认操作人 */
	private Long confirmerId;

	/** 描述 */
	private String desc;


	/**
	 * get the 来源单据
	 * @return srcBill
	 */
	public Long getSrcBill() {
		return this.srcBill;
	}

	/**
	 * set the 来源单据
	 * @param srcBill
	 */
	public void setSrcBill(Long srcBill) {
		this.srcBill = srcBill;
	}

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
	 * get the 业务类型
	 * @return bizType
	 */
	public Integer getBizType() {
		return this.bizType;
	}

	/**
	 * set the 业务类型
	 * @param bizType
	 */
	public void setBizType(Integer bizType) {
		this.bizType = bizType;
	}

	/**
	 * get the 收支类型
	 * @return inOutType
	 */
	public Integer getInOutType() {
		return this.inOutType;
	}

	/**
	 * set the 收支类型
	 * @param inOutType
	 */
	public void setInOutType(Integer inOutType) {
		this.inOutType = inOutType;
	}

	/**
	 * get the 金额
	 * @return money
	 */
	public BigDecimal getMoney() {
		return this.money;
	}

	/**
	 * set the 金额
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