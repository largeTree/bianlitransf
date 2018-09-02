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
import com.bianlitransf.biz.dao.CapitalAcctDao;
import com.bianlitransf.biz.entity.CapitalAcct;
import com.bianlitransf.biz.service.ICapitalAcctService;

/**
 * 服务类
 *
 * @author qiuxs
 *
 */
@Service
public class CapitalAcctService extends AbstractDataPropertyService<Long, CapitalAcct, CapitalAcctDao>
		implements ICapitalAcctService {

	private static final String TABLE_NAME = "capital_acct";

	public CapitalAcctService() {
		super(Long.class, CapitalAcct.class, TABLE_NAME);
	}

	@Resource
	private CapitalAcctDao capitalAcctDao;

	@Override
	protected CapitalAcctDao getDao() {
		return this.capitalAcctDao;
	}

	@Override
	public CapitalAcct getAcctMustByOwner(Long ownerId) {
		CapitalAcct acct = this.getDao().getByOwnerId(ownerId);
		// 不存在账户时，创建一个
		if (acct == null) {
			acct = new CapitalAcct();
			acct.setOwnerId(ownerId);
			this.save(acct);
		}
		return acct;
	}

	@Override
	protected void initServiceFilters(List<IServiceFilter<Long, CapitalAcct>> serviceFilters) {
		serviceFilters.add(new IdGenerateFilter<>(TABLE_NAME));
	}

	@Override
	protected void initProps(List<PropertyWrapper<?>> props) {
		PropertyWrapper<?> prop = null;

		prop = new PropertyWrapper<Long>(new BaseField("id", "资金账户", Long.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Long>(new BaseField("ownerId", "所有者", Long.class), null);
		props.add(prop);

		prop = new PropertyWrapper<BigDecimal>(new BaseField("balMoney", "账户余额", BigDecimal.class), null);
		props.add(prop);

		prop = new PropertyWrapper<BigDecimal>(new BaseField("blkMoney", "已被锁定余额", BigDecimal.class), null);
		props.add(prop);

		prop = new PropertyWrapper<BigDecimal>(new BaseField("cashinMoney", "已提现金额", BigDecimal.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Long>(new BaseField("createdBy", "创建人", Long.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Date>(new BaseField("createdTime", "创建时间", Date.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Long>(new BaseField("updatedBy", "更新人", Long.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Date>(new BaseField("updatedTime", "更新时间", Date.class), null);
		props.add(prop);

	}

}