package com.lj.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class LjShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(LjShopApplication.class, args);
	}

}
