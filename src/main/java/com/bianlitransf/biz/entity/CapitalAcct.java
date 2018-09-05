package com.bianlitransf.biz.entity;

import java.math.BigDecimal;

import com.qiuxs.cuteframework.core.basic.utils.ExceptionUtils;
import com.qiuxs.cuteframework.core.basic.utils.NumberUtils;
import com.qiuxs.cuteframework.core.persistent.database.entity.impl.AbstractEntity;

/**
 * 实体类
 *	for table capital_acct
 * @author qiuxs
 *
 */

public class CapitalAcct extends AbstractEntity<Long> {

	private static final long serialVersionUID = 1L;

	/** 子账户类型：可用余额 */
	public static final int SUB_ACCT_BAL = 1;
	/** 子账户类型：已锁定余额 */
	public static final int SUB_ACCT_BLK = 2;
	/** 子账户类型：已提现金额 */
	public static final int SUB_ACCT_CASHIN = 3;

	/** 所有者 */
	private Long ownerId;

	/** 账户余额 */
	private BigDecimal balMoney;

	/** 已被锁定余额 */
	private BigDecimal blkMoney;

	/** 已提现金额 */
	private BigDecimal cashinMoney;

	/**
	 * 增加金额
	 * @author qiuxs
	 *
	 * @param moeny
	 * @param subAcct
	 * @return
	 *
	 * 创建时间：2018年9月2日 下午5:10:00
	 */
	public BigDecimal addMoney(BigDecimal money, int subAcct) {
		switch (subAcct) {
		case SUB_ACCT_BAL:
			this.setBalMoney(this.getBalMoney().add(money));
			return this.getBalMoney();
		case SUB_ACCT_BLK:
			this.setBlkMoney(this.getBlkMoney().add(money));
			return this.getBlkMoney();
		case SUB_ACCT_CASHIN:
			this.setCashinMoney(this.getCashinMoney().add(money));
			return this.getCashinMoney();
		default:
			ExceptionUtils.throwLogicalException("sub_acct_error");
		}
		// 实际不会走到这句代码
		return null;
	};

	/**
	 * 减少金额
	 * @author qiuxs
	 *
	 * @param money
	 * @param subAcct
	 * @return
	 *
	 * 创建时间：2018年9月2日 下午5:10:06
	 */
	public BigDecimal subtractMoney(BigDecimal money, int subAcct) {
		BigDecimal result = null;
		switch (subAcct) {
		case SUB_ACCT_BAL:
			this.setBalMoney(this.getBalMoney().subtract(money));
			result = this.getBalMoney();
			break;
		case SUB_ACCT_BLK:
			this.setBlkMoney(this.getBlkMoney().subtract(money));
			result = this.getBlkMoney();
			break;
		case SUB_ACCT_CASHIN:
			this.setCashinMoney(this.getCashinMoney().subtract(money));
			result = this.getCashinMoney();
			break;
		default:
			ExceptionUtils.throwLogicalException("sub_acct_error");
		}
		// 账户余额不允许为负数
		if (NumberUtils.lessThanZero(result)) {
			ExceptionUtils.throwLogicalException("acc_bal_not_enough");
		}
		return result;
	};

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
	 * get the 账户余额
	 * @return balMoney
	 */
	public BigDecimal getBalMoney() {
		return this.balMoney;
	}

	/**
	 * set the 账户余额
	 * @param balMoney
	 */
	public void setBalMoney(BigDecimal balMoney) {
		this.balMoney = balMoney;
	}

	/**
	 * get the 已被锁定余额
	 * @return blkMoney
	 */
	public BigDecimal getBlkMoney() {
		return this.blkMoney;
	}

	/**
	 * set the 已被锁定余额
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
		return this.cashinMoney;
	}

	/**
	 * set the 已提现金额
	 * @param cashinMoney
	 */
	public void setCashinMoney(BigDecimal cashinMoney) {
		this.cashinMoney = cashinMoney;
	}

}