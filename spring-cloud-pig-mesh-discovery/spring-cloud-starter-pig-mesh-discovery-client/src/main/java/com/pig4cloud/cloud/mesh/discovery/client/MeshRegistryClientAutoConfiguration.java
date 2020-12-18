package com.pig4cloud.cloud.mesh.discovery.client;

import com.pig4cloud.cloud.mesh.discovery.client.discovery.MeshRegistryDiscovery;
import com.pig4cloud.cloud.mesh.discovery.client.discovery.MeshRegistryDiscoveryClient;
import com.pig4cloud.cloud.mesh.discovery.client.properties.MeshDiscoveryProperties;
import com.pig4cloud.cloud.mesh.discovery.client.registry.MeshRegistryAutoServiceRegistration;
import com.pig4cloud.cloud.mesh.discovery.client.registry.MeshRegistryRegistration;
import com.pig4cloud.cloud.mesh.discovery.client.registry.MeshServiceRegistry;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.AutoServiceRegistrationProperties;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.util.UUID;

/**
 * @author lengleng
 * @date 2020/12/16
 * <p>
 * mesh 客户端
 */
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(MeshDiscoveryProperties.class)
public class MeshRegistryClientAutoConfiguration {

	@Bean
	public MeshRegistryRegistration registration(InetUtils inetUtils) {
		MeshRegistryRegistration registration = new MeshRegistryRegistration();
		InetAddress address = inetUtils.findFirstNonLoopbackAddress();
		registration.setHost(address.getHostAddress());
		registration.setInstanceId(UUID.randomUUID().toString());
		return registration;
	}

	@Bean
	public MeshServiceRegistry registry(MeshDiscoveryProperties properties) {
		return new MeshServiceRegistry(properties);
	}

	@Bean
	public MeshRegistryAutoServiceRegistration meshRegistryAutoServiceRegistration(MeshServiceRegistry registry,
			AutoServiceRegistrationProperties properties, MeshRegistryRegistration registration) {
		return new MeshRegistryAutoServiceRegistration(registry, properties, registration);
	}

	@Bean
	public MeshRegistryDiscovery meshRegistryDiscovery(MeshDiscoveryProperties properties) {
		return new MeshRegistryDiscovery(properties);
	}

	@Bean
	public DiscoveryClient discoveryClient(MeshRegistryDiscovery discovery) {
		return new MeshRegistryDiscoveryClient(discovery);
	}

}
