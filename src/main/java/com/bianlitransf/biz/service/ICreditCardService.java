package com.bianlitransf.biz.service;

import com.bianlitransf.biz.dao.CreditCardDao;
import com.bianlitransf.biz.entity.CreditCard;
import com.qiuxs.cuteframework.core.persistent.database.service.ifc.IDataPropertyService;

public interface ICreditCardService extends IDataPropertyService<Long, CreditCard, CreditCardDao> {

}
