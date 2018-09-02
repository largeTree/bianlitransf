package com.bianlitransf.biz.service;

public interface IExchangeBillCombService {

	/**
	 * 拒绝兑换单
	 * @author qiuxs
	 *
	 * @param exgBillId
	 * 		兑换单ID
	 * @param desc
	 * 		备注信息
	 *
	 * 创建时间：2018年9月2日 下午8:17:43
	 */
	public void refuseExgBill(Long exgBillId, String desc);

	/**
	 * 确认兑换单
	 * @author qiuxs
	 *
	 * @param exgBillId
	 * 		兑换单ID
	 * @param desc
	 * 		备注信息
	 *
	 * 创建时间：2018年9月2日 下午8:17:54
	 */
	public void confrimExgBill(Long exgBillId, String desc);

}
