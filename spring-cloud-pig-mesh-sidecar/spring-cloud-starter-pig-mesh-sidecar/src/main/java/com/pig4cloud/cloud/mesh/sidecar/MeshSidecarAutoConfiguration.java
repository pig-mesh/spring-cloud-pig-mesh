package com.pig4cloud.cloud.mesh.sidecar;

import com.pig4cloud.cloud.mesh.sidecar.client.MeshSidecarDiscoveryClient;
import com.pig4cloud.cloud.mesh.sidecar.client.SidecarDiscoveryClient;
import com.pig4cloud.cloud.mesh.sidecar.properties.MeshDiscoveryProperties;
import com.pig4cloud.cloud.mesh.sidecar.properties.MeshSidecarProperties;
import com.pig4cloud.cloud.mesh.sidecar.support.SidecarHealthRegister;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lengleng
 * @date 2020/12/19
 */
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties({ MeshSidecarProperties.class, MeshDiscoveryProperties.class })
public class MeshSidecarAutoConfiguration {

	@Bean
	public SidecarDiscoveryClient serviceRegistry(MeshDiscoveryProperties properties) {
		return new MeshSidecarDiscoveryClient(properties);
	}

	@Bean(initMethod = "register")
	public SidecarHealthRegister healthRegister(MeshSidecarProperties properties,
			SidecarDiscoveryClient discoveryClient) {
		return new SidecarHealthRegister(properties, discoveryClient);
	}

}
