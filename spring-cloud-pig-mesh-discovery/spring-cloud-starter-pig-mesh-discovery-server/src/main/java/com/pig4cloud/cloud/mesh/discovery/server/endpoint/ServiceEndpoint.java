package com.pig4cloud.cloud.mesh.discovery.server.endpoint;

import com.pig4cloud.cloud.mesh.discovery.server.store.ServiceStore;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @author lengleng
 * @date 2020/12/16
 * <p>
 * 注册中心服务端点
 */
@RestController
@RequestMapping("/service")
@RequiredArgsConstructor
public class ServiceEndpoint {

	private final ServiceStore serviceStore;

	@GetMapping()
	public Set<String> services() {
		return serviceStore.services();
	}

}
