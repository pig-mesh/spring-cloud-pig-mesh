package com.pig4cloud.cloud.mesh.discovery.server.endpoint;

import com.pig4cloud.cloud.mesh.discovery.client.annotation.InstanceInfo;
import com.pig4cloud.cloud.mesh.discovery.server.store.ServiceStore;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lengleng
 * @date 2020/12/16
 * <p>
 * 注册中心实例端点
 */
@RestController
@RequestMapping("/instance")
@RequiredArgsConstructor
public class InstanceEndpoint {

	private final ServiceStore serviceStore;

	/**
	 * 实例注册端点
	 * @param instance 实例
	 * @return success
	 */
	@PostMapping("/registry")
	public String registry(@RequestBody InstanceInfo instance) {
		serviceStore.registry(instance);
		return "success";
	}

	@GetMapping("/list/{serviceId}")
	public List<InstanceInfo> instanceInfos(@PathVariable String serviceId) {
		return serviceStore.instanceInfo(serviceId);
	}

}
