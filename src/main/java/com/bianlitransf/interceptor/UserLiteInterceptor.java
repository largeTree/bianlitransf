package com.bianlitransf.interceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.qiuxs.cuteframework.core.basic.bean.UserLite;
import com.qiuxs.cuteframework.core.context.UserContext;
import com.qiuxs.cuteframework.web.interceptors.AbstractApiAuthInterceptor;

@Component
public class UserLiteInterceptor extends AbstractApiAuthInterceptor {

	@Override
	protected UserLite getUserLite(HttpServletRequest request, Map<String, String> params) {
		String sessionId = request.getParameter("sessionId");
		if (sessionId != null) {
			UserLite userLite = UserContext.getUserLite(sessionId, true);
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
