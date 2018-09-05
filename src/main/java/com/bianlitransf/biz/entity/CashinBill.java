package com.bianlitransf.biz.entity;

import java.util.Date;
import java.math.BigDecimal;

import com.qiuxs.cuteframework.core.persistent.database.entity.impl.AbstractEntity;

/**
 * 实体类
 *	for table cashin_bill
 * @author qiuxs
 *
 */

public class CashinBill extends AbstractEntity<Long> {

	private static final long serialVersionUID = 1L;
	
	/** 所有者 */
	private Long ownerId;

	/** 金额 */
	private BigDecimal money;

	/** 状态 */
	private Integer status;

	/** 备注 */
	private String desc;

	/** 审核人 */
	private Long confirmerId;

	/** 审核时间 */
	private Date confirmTime;


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
	 * get the 备注
	 * @return desc
	 */
	public String getDesc() {
		return this.desc;
	}

	/**
	 * set the 备注
	 * @param desc
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * get the 审核人
	 * @return confirmerId
	 */
	public Long getConfirmerId() {
		return this.confirmerId;
	}

	/**
	 * set the 审核人
	 * @param confirmerId
	 */
	public void setConfirmerId(Long confirmerId) {
		this.confirmerId = confirmerId;
	}

	/**
	 * get the 审核时间
	 * @return confirmTime
	 */
	public Date getConfirmTime() {
		return this.confirmTime;
	}

	/**
	 * set the 审核时间
	 * @param confirmTime
	 */
	public void setConfirmTime(Date confirmTime) {
		this.confirmTime = confirmTime;
	}

}