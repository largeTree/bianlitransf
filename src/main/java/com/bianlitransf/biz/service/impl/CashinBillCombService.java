package com.bianlitransf.biz.service.impl;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bianlitransf.biz.BizConstants;
import com.bianlitransf.biz.entity.CashinBill;
import com.bianlitransf.biz.service.ICapitalFlowCombService;
import com.bianlitransf.biz.service.ICashinBillCombService;
import com.bianlitransf.biz.service.ICashinBillService;
import com.qiuxs.cuteframework.core.basic.utils.ExceptionUtils;
import com.qiuxs.cuteframework.core.basic.utils.NumberUtils;
import com.qiuxs.cuteframework.core.basic.utils.StringUtils;
import com.qiuxs.cuteframework.core.context.UserContext;

@Service
public class CashinBillCombService implements ICashinBillCombService {

	@Resource
	private ICapitalFlowCombService capitalFlowCombService;

	@Resource
	private ICashinBillService cashinBillService;

	@Override
	@Transactional
	public void cashin(Long ownerId, BigDecimal money) {
		CashinBill cashinBill = new CashinBill();
		cashinBill.setOwnerId(ownerId);
		cashinBill.setMoney(money);

		if (NumberUtils.isEmpty(money)) {
			ExceptionUtils.throwLogicalException("cashin_money_must_be_ge_zero");
		}
		// 设置为已创建
		cashinBill.setStatus(BizConstants.BILL_STATUS_CREATED);
		// 保存提现单
		this.cashinBillService.save(cashinBill);
		// 保存流水
		// 金额取反、提现10元则减少余额10元
		this.capitalFlowCombService.saveFlow(cashinBill.getId(), BizConstants.BIZ_TYPE_CASHIN, cashinBill.getMoney().negate(),
				cashinBill.getOwnerId(), false);
	}

	@Override
	@Transactional
	public void confrimBill(Long billId, String desc) {
		CashinBill cashinBill = this.cashinBillService.getById(billId);
		// 仅能通过为创建状态的单据
		if (cashinBill.getStatus() != BizConstants.BILL_STATUS_CREATED) {
			ExceptionUtils.throwLogicalException("exg_bill_status_invalid");
		}

		// 保存流水
		this.capitalFlowCombService.saveFlow(billId, BizConstants.BIZ_TYPE_CASHIN_CONFIRM, cashinBill.getMoney(),
				cashinBill.getOwnerId(), false);

		// 设置为已通过
		cashinBill.setConfirmerId(UserContext.getUserId());
		cashinBill.setConfirmTime(new Date());
		cashinBill.setStatus(BizConstants.BIZ_TYPE_CASHIN_CONFIRM);
		cashinBill.setDesc(StringUtils.isBlank(desc) ? "审核通过" : desc);

		this.cashinBillService.save(cashinBill);
	}

	@Override
	@Transactional
	public void refuseBill(Long billId, String desc) {
		CashinBill cashinBill = this.cashinBillService.getById(billId);
		// 仅能拒绝为创建状态的单据
		if (cashinBill.getStatus() != BizConstants.BILL_STATUS_CREATED) {
			ExceptionUtils.throwLogicalException("exg_bill_status_invalid");
		}
		cashinBill.setStatus(BizConstants.BILL_STATUS_REFUSED);
		cashinBill.setDesc(StringUtils.isBlank(desc) ? "审批失败" : desc);
		// 金额取反、提现10元则减少余额10元
		this.capitalFlowCombService.saveFlow(billId, BizConstants.BIZ_TYPE_CASHIN, cashinBill.getMoney().negate(), cashinBill.getOwnerId(), true);
	}

}
