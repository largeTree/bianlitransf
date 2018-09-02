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
import com.bianlitransf.biz.dao.CapitalFlowDao;
import com.bianlitransf.biz.entity.CapitalFlow;
import com.bianlitransf.biz.service.ICapitalFlowService;

/**
 * 服务类
 *
 * @author fankaidi
 *
 */
@Service
public class CapitalFlowService extends AbstractDataPropertyService<Long, CapitalFlow, CapitalFlowDao>
		implements ICapitalFlowService {

	private static final String TABLE_NAME = "capital_flow";

	public CapitalFlowService() {
		super(Long.class, CapitalFlow.class, TABLE_NAME);
	}

	@Resource
	private CapitalFlowDao capitalFlowDao;

	@Override
	protected CapitalFlowDao getDao() {
		return this.capitalFlowDao;
	}

	@Override
	protected void initServiceFilters(List<IServiceFilter<Long, CapitalFlow>> serviceFilters) {
		serviceFilters.add(new IdGenerateFilter<>(TABLE_NAME));
	}

	@Override
	protected void initProps(List<PropertyWrapper<?>> props) {
		PropertyWrapper<?> prop = null;

		prop = new PropertyWrapper<Long>(new BaseField("id", "id", Long.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Long>(new BaseField("srcBill", "来源单据", Long.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Long>(new BaseField("ownerId", "所有者", Long.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Integer>(new BaseField("status", "状态", Integer.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Integer>(new BaseField("bizType", "业务类型", Integer.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Integer>(new BaseField("inOutType", "收支类型", Integer.class), null);
		props.add(prop);

		prop = new PropertyWrapper<BigDecimal>(new BaseField("money", "金额", BigDecimal.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Date>(new BaseField("createdBy", "创建人", Long.class), null);
		props.add(prop);
		
		prop = new PropertyWrapper<Date>(new BaseField("createdTime", "创建时间", Date.class), null);
		props.add(prop);

		prop = new PropertyWrapper<String>(new BaseField("desc", "描述", String.class), null);
		props.add(prop);

		prop = new PropertyWrapper<String>(new BaseField("acctId", "账户ID", Long.class), null);
		props.add(prop);
		
		prop = new PropertyWrapper<String>(new BaseField("subAcct", "子账户", Integer.class), null);
		props.add(prop);
		
		prop = new PropertyWrapper<String>(new BaseField("balMoney", "余额", BigDecimal.class), null);
		props.add(prop);
		
		prop = new PropertyWrapper<String>(new BaseField("blkMoney", "已锁定余额", BigDecimal.class), null);
		props.add(prop);
		
		prop = new PropertyWrapper<String>(new BaseField("cashinMoney", "已提现金额", BigDecimal.class), null);
		props.add(prop);
		
		prop = new PropertyWrapper<String>(new BaseField("type", "类型", Integer.class), null);
		props.add(prop);

	}

}
