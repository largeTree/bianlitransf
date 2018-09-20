package com.bianlitransf.biz.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bianlitransf.biz.BizConstants;
import com.bianlitransf.biz.dao.ExchangeBillDao;
import com.bianlitransf.biz.entity.ExchangeBill;
import com.bianlitransf.biz.entity.ScoreExchangeDetail;
import com.bianlitransf.biz.entity.User;
import com.bianlitransf.biz.service.IExchangeBillService;
import com.bianlitransf.biz.service.IScoreExchangeDetailService;
import com.bianlitransf.biz.service.IUserService;
import com.qiuxs.cuteframework.core.basic.bean.UserLite;
import com.qiuxs.cuteframework.core.basic.utils.ExceptionUtils;
import com.qiuxs.cuteframework.core.context.UserContext;
import com.qiuxs.cuteframework.core.persistent.database.modal.BaseField;
import com.qiuxs.cuteframework.core.persistent.database.modal.PropertyWrapper;
import com.qiuxs.cuteframework.core.persistent.database.service.AbstractDataPropertyService;
import com.qiuxs.cuteframework.core.persistent.database.service.filter.IServiceFilter;
import com.qiuxs.cuteframework.core.persistent.database.service.filter.impl.IdGenerateFilter;

/**
 * 服务类
 *
 * @author qiuxs
 *
 */
@Service
public class ExchangeBillService extends AbstractDataPropertyService<Long, ExchangeBill, ExchangeBillDao>
		implements IExchangeBillService {

	private static final String TABLE_NAME = "exchange_bill";

	public ExchangeBillService() {
		super(Long.class, ExchangeBill.class, TABLE_NAME);
	}

	@Resource
	private ExchangeBillDao exchangeBillDao;

	@Resource
	private IScoreExchangeDetailService exgDetService;

	@Resource
	private IUserService userService;

	@Override
	protected ExchangeBillDao getDao() {
		return this.exchangeBillDao;
	}

	@Override
	public BigDecimal summaryScore(Long ownerId) {
		return this.getDao().summaryScore(ownerId);
	}
	
	@Override
	public Map<String, Object> summaryExgBills() {
		List<Map<String, Number>> summarys = this.getDao().summaryExgBills(UserContext.getUserId());
		Map<String, Object> data = new HashMap<>();
		Number refused = 0;
		Number confrimed = 0;
		Number created = 0;
		for (Map<String, Number> row : summarys) {
			if (((Number) row.get("status")).intValue() == BizConstants.BILL_STATUS_CREATED) {
				created = row.get("count");
			} else if (((Number) row.get("status")).intValue() == BizConstants.BILL_STATUS_CONFRIMED) {
				confrimed = row.get("count");
			} else if (((Number) row.get("status")).intValue() == BizConstants.BILL_STATUS_REFUSED) {
				refused = row.get("count");
			}
		}
		data.put("refused", refused);
		data.put("confrimed", confrimed);
		data.put("created", created);
		return data;
	}

	@Override
	public void saveBill(Map<String, String> params, ExchangeBill exchangeBill) {
		UserLite userLite = UserContext.getUserLite();
		User user = this.userService.getById(userLite.getUserId());
		// 兑换单所有者
		exchangeBill.setOwnerId(user.getId());
		exchangeBill.setStatus(BizConstants.BILL_STATUS_CREATED);

		// 判断兑换码是否重复
		if (this.isExistsBizKeys(exchangeBill.getExgDetId(), exchangeBill.getVoucherCode())) {
			ExceptionUtils.throwLogicalException("voucher_code_repeat");
		}

		// 设置兑换券明细
		ScoreExchangeDetail exgDet = exgDetService.getById(exchangeBill.getExgDetId());
		exchangeBill.setExgDetName(exgDet.getName());
		BigDecimal price;
		if (user.getLevel() == BizConstants.LEVEL_USER) {
			price = exgDet.getPrice1();
		} else {
			price = exgDet.getPrice2();
		}
		exchangeBill.setMoney(price);
		exchangeBill.setScore(exgDet.getScore());
		this.save(exchangeBill);
	}

	/***
	 * 是否存在相同记录
	 * @author qiuxs
	 *
	 * @param exgDetId
	 * @param voucherCode
	 * @return
	 *
	 * 创建时间：2018年9月2日 下午4:04:28
	 */
	public boolean isExistsBizKeys(Long exgDetId, String voucherCode) {
		return this.getDao().isExistsBizKeys(exgDetId, voucherCode) > 0;
	}

	@Override
	protected void initServiceFilters(List<IServiceFilter<Long, ExchangeBill>> serviceFilters) {
		serviceFilters.add(new IdGenerateFilter<>(TABLE_NAME));
	}

	@Override
	protected void initProps(List<PropertyWrapper<?>> props) {
		PropertyWrapper<?> prop = null;

		prop = new PropertyWrapper<Long>(new BaseField("id", "id", Long.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Long>(new BaseField("ownerId", "所有者", Long.class), this.userService);
		props.add(prop);

		prop = new PropertyWrapper<Integer>(new BaseField("status", "状态", Integer.class), BizConstants.BILL_STATUS_TRANSTLATER);
		props.add(prop);

		prop = new PropertyWrapper<Integer>(new BaseField("exgDetId", "兑换券ID", Integer.class), null);
		props.add(prop);

		prop = new PropertyWrapper<String>(new BaseField("exgDetName", "兑换券名称", String.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Integer>(new BaseField("score", "兑换积分", Integer.class), null);
		props.add(prop);

		prop = new PropertyWrapper<BigDecimal>(new BaseField("money", "兑换金", BigDecimal.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Date>(new BaseField("createdTime", "创建时间", Date.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Date>(new BaseField("confirmTime", "确认时间", Date.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Long>(new BaseField("confirmerId", "确认操作人", Long.class), this.userService);
		props.add(prop);

		prop = new PropertyWrapper<String>(new BaseField("desc", "描述", String.class), null);
		props.add(prop);

	}

}
