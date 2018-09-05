package com.bianlitransf.biz.service;

import java.math.BigDecimal;

public interface ICashinBillCombService {

	/**
	 * 提交提现
	 * @author qiuxs
	 *
	 * @param cashinBill
	 *
	 * 创建时间：2018年9月4日 下午10:30:01
	 */
	public void cashin(Long ownerId, BigDecimal money);

	/**
	 * 管理员确认提现单
	 * @author qiuxs
	 *
	 * @param billId
	 * @param desc
	 *
	 * 创建时间：2018年9月4日 下午10:30:07
	 */
	public void confrimBill(Long billId, String desc);

	/**
	 * 管理员拒绝提现单
	 * @author qiuxs
	 *
	 * @param billId
	 * @param desc
	 *
	 * 创建时间：2018年9月4日 下午10:30:15
	 */
	public void refuseBill(Long billId, String desc);
}
