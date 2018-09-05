package com.bianlitransf.biz.entity;

import java.math.BigDecimal;

import com.qiuxs.cuteframework.core.persistent.database.entity.impl.AbstractEntity;

/**
 * 实体类
 *	for table capital_flow
 * @author fankaidi
 *
 */

public class CapitalFlow extends AbstractEntity<Long> {

	private static final long serialVersionUID = 1L;

	/** 收入 */
	public static final int IN_OUT_TYPE_IN = 1;
	/** 支出 */
	public static final int IN_OUT_TYPE_OUT = 2;

	/** 用户流水 */
	public static final int TYPE_CUST = 1;
	/** 系统流水 */
	public static final int TYPE_SYS = 2;

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

	/** 描述 */
	private String desc;

	/** 账户ID */
	private Long acctId;

	/** 子账户 */
	private Integer subAcct;

	/** 余额 */
	private BigDecimal balMoney;

	/** 已锁定金额 */
	private BigDecimal blkMoney;

	/** 已提现金额 */
	private BigDecimal cashinMoney;

	/** 流水类型 */
	private Integer type;

	/** 撤销标记 */
	private Integer revokeFlag;

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

	/**
	 * get the 账户ID
	 * @return acctId
	 */
	public Long getAcctId() {
		return acctId;
	}

	/**
	 * set the 账户ID
	 * @param acctId
	 */
	public void setAcctId(Long acctId) {
		this.acctId = acctId;
	}

	/**
	 * get the 子账户
	 * @return subAcct
	 */
	public Integer getSubAcct() {
		return subAcct;
	}

	/**
	 * set the 子账户
	 * @param subAcct
	 */
	public void setSubAcct(Integer subAcct) {
		this.subAcct = subAcct;
	}

	/**
	 * get the 余额
	 * @return balMoney
	 */
	public BigDecimal getBalMoney() {
		return balMoney;
	}

	/**
	 * set the 余额
	 * @param balMoney
	 */

	public void setBalMoney(BigDecimal balMoney) {
		this.balMoney = balMoney;
	}

	/**
	 * get the 已锁定余额
	 * @return blkMoney
	 */
	public BigDecimal getBlkMoney() {
		return blkMoney;
	}

	/**
	 * set the 已锁定余额
	 * @param blkMoney
	 */
	public void setBlkMoney(BigDecimal blkMoney) {
		this.blkMoney = blkMoney;
	}

	/**
	 * get the 已提现金额
	 * @return cashinMoney
	 */
	public BigDecimal getCashinMoney() {
		return cashinMoney;
	}

	/**
	 * set the 已提现金额
	 * @param cashinMoney
	 */
	public void setCashinMoney(BigDecimal cashinMoney) {
		this.cashinMoney = cashinMoney;
	}

	/**
	 * get the 流水类型
	 * @return type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * set the 流水类型
	 * @param type
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * get the 撤销标记
	 * @return revokeFlag
	 */
	public Integer getRevokeFlag() {
		return revokeFlag;
	}

	/**
	 * set the 撤销标记
	 * @param revokeFlag
	 */
	public void setRevokeFlag(Integer revokeFlag) {
		this.revokeFlag = revokeFlag;
	}

}