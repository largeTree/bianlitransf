package com.bianlitransf.biz.service.impl;

import java.util.List;
import javax.annotation.Resource;
import java.util.Date;
import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.qiuxs.cuteframework.core.persistent.database.modal.PropertyWrapper;
import com.qiuxs.cuteframework.core.basic.utils.ExceptionUtils;
import com.qiuxs.cuteframework.core.basic.utils.StringUtils;
import com.qiuxs.cuteframework.core.context.UserContext;
import com.qiuxs.cuteframework.core.persistent.database.modal.BaseField;
import com.qiuxs.cuteframework.core.persistent.database.service.AbstractDataPropertyService;
import com.qiuxs.cuteframework.core.persistent.database.service.filter.IServiceFilter;
import com.qiuxs.cuteframework.core.persistent.database.service.filter.impl.IdGenerateFilter;
import com.bianlitransf.biz.dao.CashinBillDao;
import com.bianlitransf.biz.entity.CashinBill;
import com.bianlitransf.biz.entity.User;
import com.bianlitransf.biz.service.ICashinBillCombService;
import com.bianlitransf.biz.service.ICashinBillService;
import com.bianlitransf.biz.service.IUserService;

/**
 * 服务类
 *
 * @author qiuxs
 *
 */
@Service
public class CashinBillService extends AbstractDataPropertyService<Long, CashinBill, CashinBillDao>
		implements ICashinBillService {

	private static final String TABLE_NAME = "cashin_bill";

	public CashinBillService() {
		super(Long.class, CashinBill.class, TABLE_NAME);
	}

	@Resource
	private CashinBillDao cashinBillDao;

	@Resource
	private IUserService userService;

	@Resource
	private ICashinBillCombService cashinBillCombService;

	@Override
	protected CashinBillDao getDao() {
		return this.cashinBillDao;
	}

	@Override
	public void saveBill(String userName, String alipayNo, BigDecimal money) {
		boolean updateFlag = false;
		User user = this.userService.getById(UserContext.getUserId());
		if (StringUtils.isBlank(user.getAlipayNo())) {
			user.setAlipayNo(alipayNo);
			updateFlag = true;
		} else if (!user.getAlipayNo().equals(alipayNo)) {
			ExceptionUtils.throwLogicalException("params_error", "1");
		}
		if (StringUtils.isBlank(user.getName())) {
			user.setName(userName);
			updateFlag = true;
		} else if (!user.getName().equals(userName)) {
			ExceptionUtils.throwLogicalException("params_error", "2");
		}

		if (updateFlag) {
			this.userService.update(user);
		}

		// 保存提现单据并生成流水
		this.cashinBillCombService.cashin(user.getId(), money);
	}

	@Override
	protected void initServiceFilters(List<IServiceFilter<Long, CashinBill>> serviceFilters) {
		serviceFilters.add(new IdGenerateFilter<>(TABLE_NAME));
	}

	@Override
	protected void initProps(List<PropertyWrapper<?>> props) {
		PropertyWrapper<?> prop = null;

		prop = new PropertyWrapper<Long>(new BaseField("id", "id", Long.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Long>(new BaseField("ownerId", "所有者", Long.class), null);
		props.add(prop);

		prop = new PropertyWrapper<BigDecimal>(new BaseField("money", "金额", BigDecimal.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Integer>(new BaseField("status", "状态", Integer.class), null);
		props.add(prop);

		prop = new PropertyWrapper<String>(new BaseField("desc", "备注", String.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Date>(new BaseField("createdTime", "创建时间", Date.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Long>(new BaseField("confirmerId", "审核人", Long.class), null);
		props.add(prop);

		prop = new PropertyWrapper<Date>(new BaseField("confirmTime", "审核时间", Date.class), null);
		props.add(prop);

	}

}
