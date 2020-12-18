package com.pig4cloud.cloud.mesh.config.client;

import com.pig4cloud.cloud.mesh.config.client.task.MeshContextRefresherTask;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author lengleng
 * @date 2020/12/18
 */
@EnableScheduling
@Configuration(proxyBeanMethods = false)
public class MeshConfigAutoConfiguration {

	@Bean
	public MeshContextRefresherTask refresherTask() {
		return new MeshContextRefresherTask();
	}

}
