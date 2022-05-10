package com.lj.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author gzc
 * @since 2022-5-6 14:54
 **/
@RestController
@RequestMapping("test")
@RefreshScope
public class TestController {

	@Value("${test.t1}")
	private String param;



	@RequestMapping("test1")
	public String test1() {
		return param;
	}

}
