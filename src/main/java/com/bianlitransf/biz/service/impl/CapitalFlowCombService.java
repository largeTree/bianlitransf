package com.bianlitransf.biz.service.impl;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bianlitransf.biz.BizConstants;
import com.bianlitransf.biz.entity.CapitalAcct;
import com.bianlitransf.biz.entity.CapitalFlow;
import com.bianlitransf.biz.service.ICapitalAcctService;
import com.bianlitransf.biz.service.ICapitalFlowCombService;
import com.bianlitransf.biz.service.ICapitalFlowService;
import com.qiuxs.cuteframework.core.basic.utils.ExceptionUtils;
import com.qiuxs.cuteframework.core.basic.utils.NumberUtils;

/**
 * 账户流水服务类
 *  业务类型对应操作说明
 *  
 *  积分兑换：增加账户余额 {@link com.bianlitransf.biz.entity.CapitalAcct#SUB_ACCT_BAL}
 *	@see com.bianlitransf.biz.BizConstants#BIZ_TYPE_SCORE_TRANSF = 1;
 *
 *  提现：减少账户余额  {@link com.bianlitransf.biz.entity.CapitalAcct#SUB_ACCT_BAL}
 *  	同时自动增加账户已锁定余额 {@link com.bianlitransf.biz.entity.CapitalAcct#SUB_ACCT_BLK}
 *	@see com.bianlitransf.biz.BizConstants#BIZ_TYPE_CASHIN = 2;
 *
 *	提现被确认：增加已提现金额  {@link com.bianlitransf.biz.entity.CapitalAcct#SUB_ACCT_CASHIN}
 *		同时自动减少已锁定金额  {@link com.bianlitransf.biz.entity.CapitalAcct#SUB_ACCT_BLK}
 *	@see com.bianlitransf.biz.BizConstants#BIZ_TYPE_CASHIN_CONFIRM = 3;
 *
 *	分润：增加账户余额 {@link com.bianlitransf.biz.entity.CapitalAcct#SUB_ACCT_BAL}
 *	@see com.bianlitransf.biz.BizConstants#BIZ_TYPE_SHARE_PROFIT = 4;
 *	
 * @author qiuxs
 * 
 * 创建时间 ： 2018年9月2日 下午5:54:59
 *
 */
@Service
public class CapitalFlowCombService implements ICapitalFlowCombService {

	private static Logger log = LogManager.getLogger(CapitalFlowCombService.class);

	@Resource
	private ICapitalFlowService capitalFlowService;

	@Resource
	private ICapitalAcctService capitalAcctService;

	@Transactional
	@Override
	public void saveFlow(Long billId, int bizType, BigDecimal money, Long ownerId) {
		if (NumberUtils.isEmpty(money)) {
			log.warn("want save an emptyFlow [billId = " + billId + ",bizType=" + bizType + ",money=" + money
					+ ",ownerId=" + ownerId + "]");
			return;
		}

		// 保存用户流水
		this.saveFlow(billId, bizType, money, ownerId, this.getSubAcct(bizType), CapitalFlow.TYPE_CUST);

		// 特殊业务类型附加系统流水
		if (bizType == BizConstants.BIZ_TYPE_CASHIN) {
			// 提现操作，同时增加已锁定余额
			this.saveFlow(billId, bizType, money.negate(), ownerId, CapitalAcct.SUB_ACCT_BLK, CapitalFlow.TYPE_SYS);
		} else if (bizType == BizConstants.BIZ_TYPE_CASHIN_CONFIRM) {
			// 提现被确认，同时减少已锁定余额
			this.saveFlow(billId, bizType, money.negate(), ownerId, CapitalAcct.SUB_ACCT_BLK, CapitalFlow.TYPE_SYS);
		}
	}

	private void saveFlow(Long billId, int bizType, BigDecimal money, Long ownerId, int subAcct, int type) {
		// 正值增加余额，负值减少余额
		int inOutType = money.compareTo(BigDecimal.ZERO) == 1 ? CapitalFlow.IN_OUT_TYPE_IN
				: CapitalFlow.IN_OUT_TYPE_OUT;

		// 产生自己的资金流水
		CapitalFlow capitalFlow = new CapitalFlow();
		capitalFlow.setSrcBill(billId);
		capitalFlow.setBizType(bizType);
		capitalFlow.setMoney(money.abs()); // 流水金额总是为正  根据出入类型决定实际金额 
		capitalFlow.setInOutType(inOutType);
		capitalFlow.setOwnerId(ownerId);
		capitalFlow.setStatus(BizConstants.STATUS_VALID);
		capitalFlow.setType(type);

		// 设置子账户类型
		capitalFlow.setSubAcct(subAcct);
		CapitalAcct acct = this.capitalAcctService.getAcctMustByOwner(ownerId);
		capitalFlow.setAcctId(acct.getId());

		// 修改账户余额
		if (inOutType == CapitalFlow.IN_OUT_TYPE_IN) {
			acct.addMoney(capitalFlow.getMoney(), capitalFlow.getSubAcct());
		} else {
			acct.subtractMoney(capitalFlow.getMoney(), capitalFlow.getSubAcct());
		}
		
		// 记录到当前流水为止的账户余额
		capitalFlow.setBalMoney(acct.getBalMoney());
		capitalFlow.setBlkMoney(acct.getBlkMoney());
		capitalFlow.setCashinMoney(money);
		
		// 保存落库
		this.capitalFlowService.save(capitalFlow);
		this.capitalAcctService.save(acct);
	}

	/***
	 * 根据业务类型选择子账户
	 * @author qiuxs
	 *
	 * @param bizType
	 * @return
	 *
	 * 创建时间：2018年9月2日 下午5:37:20
	 */
	private Integer getSubAcct(int bizType) {
		switch (bizType) {
		case BizConstants.BIZ_TYPE_SCORE_TRANSF:// 兑换积分确认
		case BizConstants.BIZ_TYPE_SHARE_PROFIT:// 分润
		case BizConstants.BIZ_TYPE_CASHIN:// 提现
			return CapitalAcct.SUB_ACCT_BAL;
		case BizConstants.BIZ_TYPE_CASHIN_CONFIRM:// 提现确认
			return CapitalAcct.SUB_ACCT_CASHIN;
		default:
			ExceptionUtils.throwLogicalException("biz_type_incorrect");
		}
		// 实际不会走到这行代码
		return null;
	}

}
