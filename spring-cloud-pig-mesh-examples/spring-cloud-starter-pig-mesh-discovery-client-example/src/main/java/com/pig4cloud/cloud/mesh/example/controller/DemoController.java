package com.pig4cloud.cloud.mesh.example.controller;

import cn.hutool.core.collection.CollUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lengleng
 * @date 2020/12/17
 */
@RestController
@RequiredArgsConstructor
public class DemoController {

	private final DiscoveryClient discoveryClient;

	@GetMapping
	public String getServices() {
		List<String> services = discoveryClient.getServices();
		return CollUtil.join(services, ",");
	}

	@GetMapping("/instaces/{service}")
	public List<ServiceInstance> getInstaces(@PathVariable String service) {
		return discoveryClient.getInstances(service);
	}

}
