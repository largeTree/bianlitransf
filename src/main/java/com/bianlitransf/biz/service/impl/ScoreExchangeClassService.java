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
import com.bianlitransf.biz.dao.ScoreExchangeClassDao;
import com.bianlitransf.biz.entity.ScoreExchangeClass;
import com.bianlitransf.biz.service.IScoreExchangeClassService;
/**
 * 服务类
 *
 * @author fankaidi
 *
 */
@Service
public class ScoreExchangeClassService extends AbstractDataPropertyService<Long, ScoreExchangeClass, ScoreExchangeClassDao> implements IScoreExchangeClassService {

	private static final String TABLE_NAME = "score_exchange_class";

	public ScoreExchangeClassService() {
		super(Long.class, ScoreExchangeClass.class, TABLE_NAME);
	}

	@Resource
	private ScoreExchangeClassDao scoreExchangeClassDao;

	@Override
	protected ScoreExchangeClassDao getDao() {
		return this.scoreExchangeClassDao;
	}

	@Override
	protected void initServiceFilters(List<IServiceFilter<Long, ScoreExchangeClass>> serviceFilters) {
		serviceFilters.add(new IdGenerateFilter<>(TABLE_NAME));
	}

	@Override
	protected void initProps(List<PropertyWrapper<?>> props) {
		PropertyWrapper<?> prop = null;

		prop = new PropertyWrapper<Long>(new BaseField("id", "id", Long.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Long>(new BaseField("scoreExid", "积分兑换ID", Long.class), null);
		props.add(prop);

		prop = new PropertyWrapper<String>(new BaseField("name", "名称", String.class), null);
		props.add(prop);

		prop = new PropertyWrapper<String>(new BaseField("iconUrl", "图标地址", String.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Integer>(new BaseField("resType", "资源类型，链接或html内容", Integer.class), null);
		props.add(prop);

		prop = new PropertyWrapper<String>(new BaseField("target", "具体内容，链接或具体html内容", String.class), null);
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
