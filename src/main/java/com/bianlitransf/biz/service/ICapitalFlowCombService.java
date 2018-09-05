package com.bianlitransf.biz.service;

import java.math.BigDecimal;

public interface ICapitalFlowCombService {

	/**
	 * 保存资金流水
	 * @author qiuxs
	 *
	 * @param billId
	 * 		单据ID
	 * @param bizType
	 * 		业务类型
	 * @param money
	 * 		金额
	 * @param ownerId
	 * 		所有者
	 * @param revokeFlag
	 * 		是否撤销操作
	 *
	 * 创建时间：2018年9月2日 下午5:15:30
	 */
	public void saveFlow(Long billId, int bizType, BigDecimal money, Long ownerId, boolean revokeFlag);

}
