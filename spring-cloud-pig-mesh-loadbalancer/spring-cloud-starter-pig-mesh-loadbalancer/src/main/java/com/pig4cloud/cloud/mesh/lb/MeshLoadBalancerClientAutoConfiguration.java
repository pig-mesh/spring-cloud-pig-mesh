package com.pig4cloud.cloud.mesh.lb;

import com.pig4cloud.cloud.mesh.lb.client.MeshLoadBalancerClient;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lengleng
 * @date 2020/12/18
 */
@Configuration(proxyBeanMethods = false)
public class MeshLoadBalancerClientAutoConfiguration {

	@Bean
	public LoadBalancerClient loadBalancerClient(DiscoveryClient discoveryClient){
		return new MeshLoadBalancerClient(discoveryClient);
	}
}
