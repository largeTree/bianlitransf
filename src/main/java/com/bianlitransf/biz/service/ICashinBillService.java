package com.bianlitransf.biz.service;

import java.math.BigDecimal;

import com.bianlitransf.biz.dao.CashinBillDao;
import com.bianlitransf.biz.entity.CashinBill;
import com.qiuxs.cuteframework.core.persistent.database.service.ifc.IDataPropertyService;

public interface ICashinBillService extends IDataPropertyService<Long, CashinBill, CashinBillDao> {

	void saveBill(String userName, String alipayNo, BigDecimal money);

}
