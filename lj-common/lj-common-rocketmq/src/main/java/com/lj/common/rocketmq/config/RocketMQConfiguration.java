package com.lj.common.rocketmq.config;

import com.lj.common.core.factory.YamlPropertySourceFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * RocketMQ配置
 *
 * @author gzc
 */
@Configuration
@PropertySource(factory = YamlPropertySourceFactory.class, value = "classpath:lj-rocketmq.yml")
public class RocketMQConfiguration {

}
