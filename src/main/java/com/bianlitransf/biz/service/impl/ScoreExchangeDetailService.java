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
import com.bianlitransf.biz.dao.ScoreExchangeDetailDao;
import com.bianlitransf.biz.entity.ScoreExchangeDetail;
import com.bianlitransf.biz.service.IScoreExchangeDetailService;
/**
 * 服务类
 *
 * @author fankaidi
 *
 */
@Service
public class ScoreExchangeDetailService extends AbstractDataPropertyService<Long, ScoreExchangeDetail, ScoreExchangeDetailDao> implements IScoreExchangeDetailService {

	private static final String TABLE_NAME = "score_exchange_detail";

	public ScoreExchangeDetailService() {
		super(Long.class, ScoreExchangeDetail.class, TABLE_NAME);
	}

	@Resource
	private ScoreExchangeDetailDao scoreExchangeDetailDao;

	@Override
	protected ScoreExchangeDetailDao getDao() {
		return this.scoreExchangeDetailDao;
	}

	@Override
	protected void initServiceFilters(List<IServiceFilter<Long, ScoreExchangeDetail>> serviceFilters) {
		serviceFilters.add(new IdGenerateFilter<>(TABLE_NAME));
	}

	@Override
	protected void initProps(List<PropertyWrapper<?>> props) {
		PropertyWrapper<?> prop = null;

		prop = new PropertyWrapper<Long>(new BaseField("id", "id", Long.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Long>(new BaseField("classId", "积分兑换类目ID", Long.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Integer>(new BaseField("score", "所需积分数量", Integer.class), null);
		props.add(prop);

		prop = new PropertyWrapper<String>(new BaseField("name", "兑换券名称", String.class), null);
		props.add(prop);

		prop = new PropertyWrapper<BigDecimal>(new BaseField("price1", "普通会员价格", BigDecimal.class), null);
		props.add(prop);

		prop = new PropertyWrapper<BigDecimal>(new BaseField("price2", "贵宾会员价格", BigDecimal.class), null);
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
