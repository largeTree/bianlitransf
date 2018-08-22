package com.bianlitransf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.qiuxs.cuteframework.web.AbstractServletInitializer;

/**
 * 
 * 功能描述: 程序入口类<br/>
 * 新增原因: TODO<br/>
 * 新增日期: 2018-08-18 20:40 <br/>
 * 
 * @author qiuxs
 * @version 1.0.0
 */
@MapperScan(basePackages = { "com.bianlitransf.**.dao" })
@SpringBootApplication
public class BianlitransfApplication extends AbstractServletInitializer {

	public static void main(String[] args) {
		run(BianlitransfApplication.class, args);
	}
}
