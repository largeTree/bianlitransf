package com.bianlitransf.biz.service;

import java.math.BigDecimal;
import java.util.Map;

import com.bianlitransf.biz.dao.ExchangeBillDao;
import com.bianlitransf.biz.entity.ExchangeBill;
import com.qiuxs.cuteframework.core.persistent.database.service.ifc.IDataPropertyService;

public interface IExchangeBillService extends IDataPropertyService<Long, ExchangeBill, ExchangeBillDao> {

	/**
	 * 保存兑换单
	 * @author qiuxs
	 *
	 * @param params
	 * @param exchangeBill
	 *
	 * 创建时间：2018年8月29日 下午8:14:58
	 */
	public void saveBill(Map<String, String> params, ExchangeBill exchangeBill);

	/**
	 * 汇总当前用户的兑换单
	 * @author qiuxs
	 *
	 * @return
	 *
	 * 创建时间：2018年9月3日 下午8:50:49
	 */
	public Map<String, Object> summaryExgBills();
	
	/**
	 * 合计已兑换积分
	 * @author qiuxs
	 *
	 * @param ownerId
	 * @return
	 *
	 * 创建时间：2018年9月6日 下午10:27:21
	 */
	public BigDecimal summaryScore(Long ownerId);

}
