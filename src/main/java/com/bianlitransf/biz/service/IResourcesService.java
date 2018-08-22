package com.bianlitransf.biz.service;

import com.bianlitransf.biz.dao.ResourcesDao;
import com.bianlitransf.biz.entity.Resources;
import com.qiuxs.cuteframework.core.persistent.database.service.ifc.IDataPropertyService;

public interface IResourcesService extends IDataPropertyService<Long, Resources, ResourcesDao> {

}
