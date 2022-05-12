package com.lj.shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.IntBinaryOperator;
import java.util.stream.Stream;

import cn.hutool.core.util.RandomUtil;
import com.lj.shop.constants.MessageConstant;
import com.lj.shop.constants.MyFunction;
import com.lj.shop.constants.XXX;
import org.junit.Test;
import org.springframework.beans.factory.ObjectFactory;

/**
 * TODO
 *
 * @author gzc
 * @since 2022-5-10 10:12
 **/
public class Test1 {

	public static Integer operation(Integer num, MyFunction mf) {
		return mf.getValue(num);
	}

	private final Map<String, ObjectFactory<?>> singletonFactories = new HashMap<>(16);


	@Test
	public void test1() throws InterruptedException {
		singletonFactories.put("aaa", () -> bean());
//		Thread.sleep(10000);
		System.out.println(singletonFactories.get("aaa"));
	}


	private Object bean() {
		System.out.println("执行获取bean方法");
		int randomInt = RandomUtil.randomInt(0, 2);
		if (randomInt == 1) {
			return String.class;
		}
		return MessageConstant.class;
	}


}
