package com.bianlitransf.biz.service.impl;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bianlitransf.biz.BizConstants;
import com.bianlitransf.biz.entity.ExchangeBill;
import com.bianlitransf.biz.entity.ScoreExchangeDetail;
import com.bianlitransf.biz.entity.User;
import com.bianlitransf.biz.service.ICapitalFlowCombService;
import com.bianlitransf.biz.service.IExchangeBillCombService;
import com.bianlitransf.biz.service.IExchangeBillService;
import com.bianlitransf.biz.service.IScoreExchangeDetailService;
import com.bianlitransf.biz.service.IUserService;
import com.qiuxs.cuteframework.core.basic.bean.UserLite;
import com.qiuxs.cuteframework.core.basic.utils.ExceptionUtils;
import com.qiuxs.cuteframework.core.basic.utils.StringUtils;
import com.qiuxs.cuteframework.core.context.UserContext;

@Service
public class ExchangeBillCombService implements IExchangeBillCombService {

	@Resource
	private IExchangeBillService exchangeBillService;

	@Resource
	private ICapitalFlowCombService capitalFlowCombService;

	@Resource
	private IScoreExchangeDetailService scoreExchangeDetailService;

	@Resource
	private IUserService userService;

	/**
	 * 审核通过
	 * @author qiuxs
	 *
	 * @param exgBillId
	 *
	 * 创建时间：2018年9月2日 下午4:16:54
	 */
	@Transactional
	@Override
	public void confrimExgBill(Long exgBillId, String desc) {
		ExchangeBill exgBill = exchangeBillService.getById(exgBillId);

		// 仅能将状态为已创建的单子审核通过
		if (exgBill.getStatus() != ExchangeBill.STATUS_CREATED) {
			ExceptionUtils.throwLogicalException("exg_bill_status_invalid");
		}

		// 单据所有者
		User owner = userService.getById(exgBill.getOwnerId());

		// 产生资金流水
		this.capitalFlowCombService.saveFlow(exgBillId, BizConstants.BIZ_TYPE_SCORE_TRANSF, exgBill.getMoney(),
				owner.getId());

		// 兑换人是普通会员且有推荐人时给推荐人分润
		if (owner.getLevel() == BizConstants.LEVEL_USER && owner.getRefereeId() > 0) {
			ScoreExchangeDetail scoreExgDet = scoreExchangeDetailService.getById(exgBill.getExgDetId());

			// 分润金额
			BigDecimal money = scoreExgDet.getPrice2().subtract(scoreExgDet.getPrice1());

			// 分润金额为高级会员价格减掉普通会员价格
			this.capitalFlowCombService.saveFlow(exgBillId, BizConstants.BIZ_TYPE_SHARE_PROFIT,
					money, owner.getRefereeId());

		}

		// 更新兑换单为已通过状态
		exgBill.setStatus(ExchangeBill.STATUS_CONFRIMED);

		// 填充审核人信息
		UserLite userLite = UserContext.getUserLite();
		exgBill.setConfirmerId(userLite.getUserId());
		exgBill.setConfirmTime(new Date());
		exgBill.setDesc(StringUtils.isBlank(desc) ? "审核通过" : desc);
		
		this.exchangeBillService.save(exgBill);
	}

	/**
	 * 拒绝兑换单
	 * @author qiuxs
	 *
	 * @param exgBillId
	 *
	 * 创建时间：2018年9月2日 下午4:17:19
	 */
	@Transactional
	@Override
	public void refuseExgBill(Long exgBillId, String desc) {
		ExchangeBill exgBill = exchangeBillService.getById(exgBillId);
		exgBill.setStatus(ExchangeBill.STATUS_REFUSED);
		exgBill.setDesc(StringUtils.isBlank(desc) ? "审核失败" : desc);
		this.exchangeBillService.save(exgBill);
	}

}
