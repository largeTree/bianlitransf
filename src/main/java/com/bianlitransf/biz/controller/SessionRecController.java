package com.bianlitransf.biz.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qiuxs.cuteframework.web.WebConstants;
import com.qiuxs.cuteframework.web.controller.AbstractDataController;

import com.bianlitransf.biz.dao.SessionRecDao;
import com.bianlitransf.biz.entity.SessionRec;
import com.bianlitransf.biz.service.ISessionRecService;

/**
 * 控制器
 *
 * @author qiuxs
 *
 */
@RestController
@RequestMapping(value = WebConstants.DEFAULT_API_PREFIX + "/sessionrec", produces = WebConstants.DEFAULT_REQUEST_PRODUCES)
public class SessionRecController extends AbstractDataController<Long, SessionRec, SessionRecDao, ISessionRecService> {

	@Resource
	private ISessionRecService sessionrecService;

	@Override
	protected ISessionRecService getService() {
		return this.sessionrecService;
	}

}
