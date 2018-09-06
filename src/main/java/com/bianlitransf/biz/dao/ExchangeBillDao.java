package com.bianlitransf.biz.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.qiuxs.cuteframework.core.persistent.database.dao.IBaseDao;
import com.bianlitransf.biz.entity.ExchangeBill;

/**
 * Dao接口
 *
 * @author qiuxs
 *
 */
@Repository
public interface ExchangeBillDao extends IBaseDao<Long, ExchangeBill> {

	public long isExistsBizKeys(@Param("exgDetId") Long exgDetId, @Param("voucherCode") String voucherCode);

	/**
	 * 合计兑换单数量，按状态分组
	 * @author qiuxs
	 *
	 * @param ownerId
	 * @return
	 *
	 * 创建时间：2018年9月3日 下午9:03:34
	 */
	public List<Map<String, Number>> summaryExgBills(@Param("ownerId") Long ownerId);
	
	/**
	 * 合计积分总数
	 * @author qiuxs
	 *
	 * @param ownerId
	 * @return
	 *
	 * 创建时间：2018年9月6日 下午10:26:01
	 */
	public BigDecimal summaryScore(@Param("ownerId") Long ownerId);

}
