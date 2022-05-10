package com.lj.shop.service;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author gzc
 * @since 2022-5-9 17:34
 **/

@Service
public class TestService {

	@Bean
	public Consumer<String> test() {
		return item -> System.out.println("打印参数:" + item);
	}

}
