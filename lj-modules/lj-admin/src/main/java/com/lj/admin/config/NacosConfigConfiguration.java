package com.lj.admin.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * EnableAutoConfiguration启动springboot的自动自动配置，
 * 下面的方法是在初始化的时候，创建数据源实例，同样也启用了热加载
 *
 * @author gzc
 * @since 2022-4-20 16:51
 */
@EnableAutoConfiguration
@Configuration
public class NacosConfigConfiguration {

	private final Logger log = LoggerFactory.getLogger(NacosConfigConfiguration.class);

	@Bean(initMethod = "init")
	@ConditionalOnMissingBean
	@RefreshScope
	public DruidDataSource dataSource() {
		log.info("初始化数据源");
		return new DruidDataSourceWrapper();
	}


}
