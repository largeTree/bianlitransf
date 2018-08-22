package com.bianlitransf.biz.service.impl;

import java.util.List;
import javax.annotation.Resource;
import java.util.Date;
import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.qiuxs.cuteframework.core.persistent.database.modal.PropertyWrapper;
import com.qiuxs.cuteframework.core.persistent.database.modal.BaseField;
import com.qiuxs.cuteframework.core.persistent.database.service.AbstractDataPropertyService;
import com.qiuxs.cuteframework.core.persistent.database.service.filter.IServiceFilter;
import com.qiuxs.cuteframework.core.persistent.database.service.filter.impl.IdGenerateFilter;
import com.bianlitransf.biz.dao.ExchangeBillDao;
import com.bianlitransf.biz.entity.ExchangeBill;
import com.bianlitransf.biz.service.IExchangeBillService;
/**
 * 服务类
 *
 * @author fankaidi
 *
 */
@Service
public class ExchangeBillService extends AbstractDataPropertyService<Long, ExchangeBill, ExchangeBillDao> implements IExchangeBillService {

	private static final String TABLE_NAME = "exchange_bill";

	public ExchangeBillService() {
		super(Long.class, ExchangeBill.class, TABLE_NAME);
	}

	@Resource
	private ExchangeBillDao exchangeBillDao;

	@Override
	protected ExchangeBillDao getDao() {
		return this.exchangeBillDao;
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

		prop = new PropertyWrapper<Long>(new BaseField("ownerId", "所有者", Long.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Integer>(new BaseField("status", "状态", Integer.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Integer>(new BaseField("bankId", "银行ID", Integer.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Integer>(new BaseField("score", "兑换积分", Integer.class), null);
		props.add(prop);

		prop = new PropertyWrapper<BigDecimal>(new BaseField("money", "兑换金", BigDecimal.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Date>(new BaseField("createdTime", "创建时间", Date.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Date>(new BaseField("confirmTime", "确认时间", Date.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Long>(new BaseField("confirmerId", "确认操作人", Long.class), null);
		props.add(prop);

		prop = new PropertyWrapper<String>(new BaseField("desc", "描述", String.class), null);
		props.add(prop);

	}

}
