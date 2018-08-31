package com.bianlitransf.biz.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qiuxs.cuteframework.core.basic.bean.UserLite;
import com.qiuxs.cuteframework.core.basic.utils.MapUtils;
import com.qiuxs.cuteframework.core.context.UserContext;
import com.qiuxs.cuteframework.core.persistent.database.dao.page.PageInfo;
import com.qiuxs.cuteframework.web.WebConstants;
import com.qiuxs.cuteframework.web.annotation.Api;
import com.qiuxs.cuteframework.web.controller.AbstractDataController;
import com.qiuxs.cuteframework.web.controller.api.Param;
import com.bianlitransf.biz.BizConstants;
import com.bianlitransf.biz.dao.ScoreExchangeDetailDao;
import com.bianlitransf.biz.entity.ScoreExchangeDetail;
import com.bianlitransf.biz.entity.User;
import com.bianlitransf.biz.service.IScoreExchangeDetailService;
import com.bianlitransf.biz.service.IUserService;

/**
 * 控制器
 *
 * @author fankaidi
 *
 */
@RestController
@RequestMapping(value = WebConstants.DEFAULT_API_PREFIX
		+ "/scoreexchangedetail", produces = WebConstants.DEFAULT_REQUEST_PRODUCES)
public class ScoreExchangeDetailController
		extends AbstractDataController<Long, ScoreExchangeDetail, ScoreExchangeDetailDao, IScoreExchangeDetailService> {

	@Resource
	private IScoreExchangeDetailService scoreexchangedetailService;

	@Resource
	private IUserService userService;

	@Api
	public List<ScoreExchangeDetail> findByClassId(@Param("clzId") Long clzId, PageInfo pageInfo) {
		List<ScoreExchangeDetail> scoreExgDets = this.scoreexchangedetailService
				.findByMap(MapUtils.genMap("classId", clzId), pageInfo);
		UserLite userLite = UserContext.getUserLite();
		User user = this.userService.getById(userLite.getUserId());
		if (user.getLevel() == BizConstants.LEVEL_USER) {
			for (ScoreExchangeDetail det : scoreExgDets) {
				det.setPrice(det.getPrice1());
				det.setPrice1(null);
				det.setPrice2(null);
			}
		} else {
			for (ScoreExchangeDetail det : scoreExgDets) {
				det.setPrice(det.getPrice2());
				det.setPrice1(null);
				det.setPrice2(null);
			}
		}
		return scoreExgDets;
	}

	@Override
	protected IScoreExchangeDetailService getService() {
		return this.scoreexchangedetailService;
	}

}
