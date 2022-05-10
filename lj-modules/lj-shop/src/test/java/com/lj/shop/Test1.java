package com.lj.shop;

import java.util.function.IntBinaryOperator;

import com.lj.shop.constants.MyFunction;
import com.lj.shop.constants.XXX;

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


	public static void main(String[] args) {
		Integer operation = operation(100, x -> x + x);
		System.out.println(operation);
	}

}
