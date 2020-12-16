package com.pig4cloud.cloud.mesh.discovery.client;

import com.pig4cloud.cloud.mesh.discovery.client.registry.MeshRegistryAutoServiceRegistration;
import com.pig4cloud.cloud.mesh.discovery.client.registry.MeshRegistryRegistration;
import com.pig4cloud.cloud.mesh.discovery.client.registry.MeshServiceRegistry;
import org.springframework.cloud.client.serviceregistry.AutoServiceRegistrationProperties;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

/**
 * @author lengleng
 * @date 2020/12/16
 * <p>
 * mesh 客户端
 */
@Configuration(proxyBeanMethods = false)
public class MeshRegistryClientAutoConfiguration {

	@Bean
	public MeshRegistryRegistration registration(InetUtils inetUtils) {
		InetUtils.HostInfo hostInfo = inetUtils.findFirstNonLoopbackHostInfo();
		MeshRegistryRegistration registration = new MeshRegistryRegistration();
		registration.setHost(hostInfo.getHostname());
		registration.setInstanceId(UUID.randomUUID().toString());
		return registration;
	}

	@Bean
	public MeshServiceRegistry registry() {
		return new MeshServiceRegistry();
	}

	@Bean
	public MeshRegistryAutoServiceRegistration meshRegistryAutoServiceRegistration(MeshServiceRegistry registry,
			AutoServiceRegistrationProperties properties, MeshRegistryRegistration registration) {
		return new MeshRegistryAutoServiceRegistration(registry, properties, registration);
	}

}
