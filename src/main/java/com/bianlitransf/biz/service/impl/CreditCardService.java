package com.bianlitransf.biz.service.impl;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qiuxs.cuteframework.core.persistent.database.modal.PropertyWrapper;
import com.qiuxs.cuteframework.core.persistent.database.modal.BaseField;
import com.qiuxs.cuteframework.core.persistent.database.service.AbstractDataPropertyService;
import com.qiuxs.cuteframework.core.persistent.database.service.filter.IServiceFilter;
import com.qiuxs.cuteframework.core.persistent.database.service.filter.impl.IdGenerateFilter;
import com.bianlitransf.biz.dao.CreditCardDao;
import com.bianlitransf.biz.entity.CreditCard;
import com.bianlitransf.biz.service.ICreditCardService;
/**
 * 服务类
 *
 * @author qiuxs
 *
 */
@Service
public class CreditCardService extends AbstractDataPropertyService<Long, CreditCard, CreditCardDao> implements ICreditCardService {

	private static final String TABLE_NAME = "credit_card";

	public CreditCardService() {
		super(Long.class, CreditCard.class, TABLE_NAME);
	}

	@Resource
	private CreditCardDao creditCardDao;

	@Override
	protected CreditCardDao getDao() {
		return this.creditCardDao;
	}

	@Override
	protected void initServiceFilters(List<IServiceFilter<Long, CreditCard>> serviceFilters) {
		serviceFilters.add(new IdGenerateFilter<>(TABLE_NAME));
	}

	@Override
	protected void initProps(List<PropertyWrapper<?>> props) {
		PropertyWrapper<?> prop = null;

		prop = new PropertyWrapper<Long>(new BaseField("id", "id", Long.class), null);
		props.add(prop);

		prop = new PropertyWrapper<String>(new BaseField("iconUrl", "图标", String.class), null);
		props.add(prop);

		prop = new PropertyWrapper<String>(new BaseField("name", "银行名", String.class), null);
		props.add(prop);

		prop = new PropertyWrapper<String>(new BaseField("targetUrl", "目标地址", String.class), null);
		props.add(prop);

	}

}
