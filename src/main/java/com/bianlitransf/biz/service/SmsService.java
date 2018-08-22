package com.bianlitransf.biz.service;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bianlitransf.utils.SMSClient;
import com.qiuxs.cuteframework.core.basic.bean.Pair;
import com.qiuxs.cuteframework.core.basic.utils.ExceptionUtils;
import com.qiuxs.cuteframework.core.basic.utils.MobileUtils;
import com.qiuxs.cuteframework.core.context.EnvironmentContext;

@Service
public class SmsService {

	private static Map<String, Pair<String, Long>> captch = new ConcurrentHashMap<>();
	private static boolean inited = false;

	@Resource
	private EnvironmentContext envContext;

	public void sendCaptch(String phone) {
		MobileUtils.checkMobile(phone);
		String randomCode = randomCode();
		try {
			if (!envContext.isTest()) {
				SMSClient.sendSMSMessage(phone, randomCode, 60 * 2);
				Pair<String, Long> pair = new Pair<>();
				pair.setV1(randomCode);
				pair.setV2(System.currentTimeMillis());
				captch.put(phone, pair);
			}
		} catch (Exception e) {
			ExceptionUtils.throwLogicalException(e.getLocalizedMessage());
		}
	}

	private static String randomCode() {
		return String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
	}

	public boolean checkCaptch(String phone, String varifyCode) {
		Pair<String, Long> pair = captch.get(phone);
		boolean res = (this.envContext.isTest() && "0000".equals(varifyCode))
				|| (pair != null && pair.getV1().equals(varifyCode));
		if (res) {
			captch.remove(phone);
		} else {
			ExceptionUtils.throwLogicalException("verify_code_error");
		}
		return res;
	}

	@PostConstruct
	private void startClearThread() {
		if (inited) {
			return;
		}
		Thread t = new Thread(() -> {
			while (true) {
				long time = System.currentTimeMillis() - 1000 * 60 * 2;
				try {
					TimeUnit.MINUTES.sleep(1);
					if (captch.size() > 0) {
						for (Iterator<Map.Entry<String, Pair<String, Long>>> iter = captch.entrySet().iterator(); iter
								.hasNext();) {
							Map.Entry<String, Pair<String, Long>> entry = iter.next();
							Pair<String, Long> pair = entry.getValue();
							if (pair.getV2() < time) {
								iter.remove();
							}
						}
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {

				}
			}
		}, "captch_clear_thread");
		t.setDaemon(true);
		t.start();
	};
}
