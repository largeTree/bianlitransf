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
import com.bianlitransf.biz.dao.ResourcesDao;
import com.bianlitransf.biz.entity.Resources;
import com.bianlitransf.biz.service.IResourcesService;
/**
 * 服务类
 *
 * @author qiuxs
 *
 */
@Service
public class ResourcesService extends AbstractDataPropertyService<Long, Resources, ResourcesDao> implements IResourcesService {

	private static final String TABLE_NAME = "resources";

	public ResourcesService() {
		super(Long.class, Resources.class, TABLE_NAME);
	}

	@Resource
	private ResourcesDao resourcesDao;

	@Override
	protected ResourcesDao getDao() {
		return this.resourcesDao;
	}

	@Override
	protected void initServiceFilters(List<IServiceFilter<Long, Resources>> serviceFilters) {
		serviceFilters.add(new IdGenerateFilter<>(TABLE_NAME));
	}

	@Override
	protected void initProps(List<PropertyWrapper<?>> props) {
		PropertyWrapper<?> prop = null;

		prop = new PropertyWrapper<Long>(new BaseField("id", "id", Long.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Integer>(new BaseField("typeCat", "资源大类", Integer.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Integer>(new BaseField("type", "资源类型", Integer.class), null);
		props.add(prop);

		prop = new PropertyWrapper<String>(new BaseField("iconUrl", "图标地址", String.class), null);
		props.add(prop);

		prop = new PropertyWrapper<String>(new BaseField("name", "资源名", String.class), null);
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
