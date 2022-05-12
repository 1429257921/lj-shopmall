package com.lj.shop.controller;

import com.lj.shop.constants.MessageConstant;
import com.lj.shop.service.TestService;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@RestController
@RequestMapping("/test/")
public class TestController {

	private final StreamBridge streamBridge;

	private final TestService testService;

	@RequestMapping("send1")
	public String test1() {
		boolean send = streamBridge.send("sms-out-0", "{\"id\":\"abc123\"}");
		return send ? "发送成功" : "发送失败";
	}

	@RequestMapping("test2")
	public void test2() {
		testService.test().accept("加上了科技大佬的骄傲了科技大科技杀戮空间");
	}
}
