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
import com.bianlitransf.biz.dao.HomeSliderDao;
import com.bianlitransf.biz.entity.HomeSlider;
import com.bianlitransf.biz.service.IHomeSliderService;
/**
 * 首页滚动图服务类
 *
 * @author qiuxs
 *
 */
@Service
public class HomeSliderService extends AbstractDataPropertyService<Long, HomeSlider, HomeSliderDao> implements IHomeSliderService {

	private static final String TABLE_NAME = "home_slider";

	public HomeSliderService() {
		super(Long.class, HomeSlider.class, TABLE_NAME);
	}

	@Resource
	private HomeSliderDao homeSliderDao;

	@Override
	protected HomeSliderDao getDao() {
		return this.homeSliderDao;
	}

	@Override
	protected void initServiceFilters(List<IServiceFilter<Long, HomeSlider>> serviceFilters) {
		serviceFilters.add(new IdGenerateFilter<>(TABLE_NAME));
	}

	@Override
	protected void initProps(List<PropertyWrapper<?>> props) {
		PropertyWrapper<?> prop = null;

		prop = new PropertyWrapper<Long>(new BaseField("id", "id", Long.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Long>(new BaseField("docId", "图片ID", Long.class), null);
		props.add(prop);

		prop = new PropertyWrapper<String>(new BaseField("target", "具体内容", String.class), null);
		props.add(prop);
		
		prop = new PropertyWrapper<String>(new BaseField("rem", "备注", String.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Long>(new BaseField("createdBy", "创建人", Long.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Date>(new BaseField("createdTime", "创建时间", Date.class), null);
		props.add(prop);
		
		prop = new PropertyWrapper<Date>(new BaseField("title", "创建时间", Date.class), null);
		props.add(prop);

	}

}
