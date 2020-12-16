package com.pig4cloud.cloud.mesh.discovery.server;

import com.pig4cloud.cloud.mesh.discovery.server.endpoint.InstanceEndpoint;
import com.pig4cloud.cloud.mesh.discovery.server.store.InMemoryServiceStore;
import com.pig4cloud.cloud.mesh.discovery.server.store.ServiceStore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lengleng
 * @date 2020/12/16
 * <p>
 * 服务注册服务端配置类
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnBean(MeshServerMarkerConfiguration.Marker.class)
public class MeshRegistryServerAutoConfiguration {

	/**
	 * 实例端点
	 */
	@Bean
	public InstanceEndpoint instanceEndpoint(ServiceStore serviceStore) {
		return new InstanceEndpoint(serviceStore);
	}

	/**
	 * 基于内存存储
	 */
	@Bean
	@ConditionalOnMissingBean(ServiceStore.class)
	public ServiceStore inMemoryServiceStore() {
		return new InMemoryServiceStore();
	}

}
