package com.lj.admin;

import javax.annotation.PostConstruct;

import java.util.concurrent.ThreadPoolExecutor;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.cloud.nacos.NacosConfigProperties;
import com.alibaba.nacos.api.exception.NacosException;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.StringUtils;

/**
 * @author gzc
 */
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages = "com.lj.admin.dao.**")
public class LjAdminApplication {

	private static final Logger log = LoggerFactory.getLogger(LjAdminApplication.class);

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext applicationContext =
				SpringApplication.run(LjAdminApplication.class, args);
		// 打印参数
		printConfigInfo(applicationContext);
	}

	/**
	 * 日志打印参数
	 *
	 * @param applicationContext 应用上下文容器对象
	 * @return void
	 * @author gzc
	 * @since 2022-5-6 16:04
	 */
	private static void printConfigInfo(ConfigurableApplicationContext applicationContext) throws Exception {
		// 获取当前部署的环境
		String[] activeProfiles = applicationContext.getEnvironment().getActiveProfiles();
		log.info("部署环境->{}", StringUtils.arrayToCommaDelimitedString(activeProfiles));
		// 获取bean
		NacosConfigManager nacosConfigManager = applicationContext
				.getBean("nacosConfigManager", NacosConfigManager.class);
		NacosConfigProperties nacosConfigProperties = nacosConfigManager.getNacosConfigProperties();
		log.info("nacos注册地址->{}", nacosConfigProperties.getServerAddr());
		// 打印yml配置文件内容
//		System.out.println(nacosConfigManager.getConfigService().getConfig("lj-admin-local.yml", "DEFAULT_GROUP", 2000));

		System.out.println("(♥◠‿◠)ﾉﾞ  辣鸡商城管理端启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
				" _ _                 _           _       \n"
				+ "| (_)               | |         (_)      \n"
				+ "| |_ ______ __ _  __| |_ __ ___  _ _ __  \n"
				+ "| | |______/ _` |/ _` | '_ ` _ \\| | '_ \\ \n"
				+ "| | |     | (_| | (_| | | | | | | | | | |\n"
				+ "|_| |      \\__,_|\\__,_|_| |_| |_|_|_| |_|\n"
				+ " _/ |                                    \n"
				+ "|__/                                     \n");
	}

}
