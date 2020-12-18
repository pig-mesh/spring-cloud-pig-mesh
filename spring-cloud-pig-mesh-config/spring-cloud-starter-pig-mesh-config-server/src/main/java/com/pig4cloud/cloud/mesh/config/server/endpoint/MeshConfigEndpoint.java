package com.pig4cloud.cloud.mesh.config.server.endpoint;

import com.pig4cloud.cloud.mesh.config.server.store.ConfigStore;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author lengleng
 * @date 2020/12/18
 */
@RestController
@RequestMapping("/config")
@RequiredArgsConstructor
public class MeshConfigEndpoint {

	private final ConfigStore configStore;

	@GetMapping("/get/{dataId}")
	public Map<String, Object> getConfig(@PathVariable String dataId) {
		return configStore.getConfig(dataId);
	}

}
