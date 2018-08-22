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
import com.bianlitransf.biz.dao.ResourcesDetailsDao;
import com.bianlitransf.biz.entity.ResourcesDetails;
import com.bianlitransf.biz.service.IResourcesDetailsService;
/**
 * 服务类
 *
 * @author qiuxs
 *
 */
@Service
public class ResourcesDetailsService extends AbstractDataPropertyService<Long, ResourcesDetails, ResourcesDetailsDao> implements IResourcesDetailsService {

	private static final String TABLE_NAME = "resources_details";

	public ResourcesDetailsService() {
		super(Long.class, ResourcesDetails.class, TABLE_NAME);
	}

	@Resource
	private ResourcesDetailsDao resourcesDetailsDao;

	@Override
	protected ResourcesDetailsDao getDao() {
		return this.resourcesDetailsDao;
	}

	@Override
	protected void initServiceFilters(List<IServiceFilter<Long, ResourcesDetails>> serviceFilters) {
		serviceFilters.add(new IdGenerateFilter<>(TABLE_NAME));
	}

	@Override
	protected void initProps(List<PropertyWrapper<?>> props) {
		PropertyWrapper<?> prop = null;

		prop = new PropertyWrapper<Long>(new BaseField("id", "id", Long.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Long>(new BaseField("resId", "资源ID", Long.class), null);
		props.add(prop);

		prop = new PropertyWrapper<String>(new BaseField("relUrl", "相对路径", String.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Integer>(new BaseField("resType", "资源类型", Integer.class), null);
		props.add(prop);

		prop = new PropertyWrapper<String>(new BaseField("target", "资源目标", String.class), null);
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
