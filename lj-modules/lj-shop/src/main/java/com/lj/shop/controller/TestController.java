package com.lj.shop.controller;

import com.lj.shop.constants.MessageConstant;
import com.lj.shop.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author gzc
 * @since 2022-5-9 14:26
 **/
@RestController
@RequestMapping("/test/")
public class TestController {

	@Autowired
	private StreamBridge streamBridge;

	@RequestMapping("send1")
	public String test1() {
		boolean send = streamBridge.send(MessageConstant.SMS_MESSAGE_OUTPUT, "测试一下吧");
		return send ? "true" : "false";
	}


	@Autowired
	private TestService testService;

	@RequestMapping("test2")
	public void test2() {
		testService.test().accept("加上了科技大佬的骄傲了科技大科技杀戮空间");
	}
}
