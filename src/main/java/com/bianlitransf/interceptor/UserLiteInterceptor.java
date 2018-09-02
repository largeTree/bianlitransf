package com.bianlitransf.interceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.bianlitransf.biz.service.ISessionRecService;
import com.qiuxs.cuteframework.core.basic.bean.UserLite;
import com.qiuxs.cuteframework.core.context.UserContext;
import com.qiuxs.cuteframework.web.interceptors.AbstractApiAuthInterceptor;

@Component
public class UserLiteInterceptor extends AbstractApiAuthInterceptor {

	private static Logger log = LogManager.getLogger(UserLiteInterceptor.class);
	
	@Resource
	private ISessionRecService sessionRecService;
	
	@Override
	protected UserLite getUserLite(HttpServletRequest request, Map<String, String> params) {
		String sessionId = request.getParameter("sessionId");
		if (log.isDebugEnabled()) {
			log.debug("sessionId = " + sessionId);
		}
		if (sessionId != null) {
			UserLite userLite = UserContext.getUserLite(sessionId, true);
			if (userLite == null) {
				userLite = sessionRecService.loadSession(sessionId);
				if (userLite != null) {
					UserContext.addUserLite(userLite);
				}
			}
			return userLite;
		}
		return null;
	}

	@Override
	public Optional<List<String>> getPathPatterns() {
		Optional<List<String>> patterns = super.getPathPatterns();
		if (!patterns.isPresent()) {
			patterns = Optional.of(new ArrayList<>());
		}
		patterns.get().add("/auth/updatePass");
		return patterns;
	}
}
