package com.lj.admin.service;

import java.util.function.Consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author gzc
 * @since 2022-5-12 14:23
 **/
@Slf4j
@Service
public class TestService {

	@Bean
	public Consumer<String> sms() {
		return msg -> System.out.println(msg);
	}

}
