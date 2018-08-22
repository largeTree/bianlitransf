package com.bianlitransf.biz.service.impl;

import java.util.List;
import javax.annotation.Resource;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.qiuxs.cuteframework.core.persistent.database.modal.PropertyWrapper;
import com.qiuxs.cuteframework.core.persistent.database.modal.BaseField;
import com.qiuxs.cuteframework.core.persistent.database.service.AbstractDataPropertyService;
import com.qiuxs.cuteframework.core.persistent.database.service.filter.IServiceFilter;
import com.qiuxs.cuteframework.core.persistent.database.service.filter.impl.IdGenerateFilter;
import com.bianlitransf.biz.dao.ScoreExchangeDao;
import com.bianlitransf.biz.entity.ScoreExchange;
import com.bianlitransf.biz.service.IScoreExchangeService;
/**
 * 服务类
 *
 * @author fankaidi
 *
 */
@Service
public class ScoreExchangeService extends AbstractDataPropertyService<Long, ScoreExchange, ScoreExchangeDao> implements IScoreExchangeService {

	private static final String TABLE_NAME = "score_exchange";

	public ScoreExchangeService() {
		super(Long.class, ScoreExchange.class, TABLE_NAME);
	}

	@Resource
	private ScoreExchangeDao scoreExchangeDao;

	@Override
	protected ScoreExchangeDao getDao() {
		return this.scoreExchangeDao;
	}

	@Override
	protected void initServiceFilters(List<IServiceFilter<Long, ScoreExchange>> serviceFilters) {
		serviceFilters.add(new IdGenerateFilter<>(TABLE_NAME));
	}

	@Override
	protected void initProps(List<PropertyWrapper<?>> props) {
		PropertyWrapper<?> prop = null;

		prop = new PropertyWrapper<Long>(new BaseField("id", "id", Long.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Integer>(new BaseField("type", "积分兑换类型", Integer.class), null);
		props.add(prop);

		prop = new PropertyWrapper<String>(new BaseField("iconUrl", "图标地址", String.class), null);
		props.add(prop);

		prop = new PropertyWrapper<String>(new BaseField("name", "名称", String.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Integer>(new BaseField("disorder", "排序", Integer.class), null);
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
