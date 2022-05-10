package com.lj.shop.anno;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * TODO
 *
 * @author gzc
 * @since 2022-5-7 4:20
 **/
public interface MySink {

	String DEMO01_INPUT = "demo01-input";

	@Input(DEMO01_INPUT)
	SubscribableChannel demo01Input();

}
