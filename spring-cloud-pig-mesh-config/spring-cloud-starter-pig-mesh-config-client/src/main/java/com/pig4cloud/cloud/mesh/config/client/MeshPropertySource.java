package com.pig4cloud.cloud.mesh.config.client;

import org.springframework.core.env.MapPropertySource;

import java.util.Map;

/**
 * @author lengleng
 * @date 2020/12/18
 */
public class MeshPropertySource extends MapPropertySource {

	public MeshPropertySource(String name, Map<String, Object> source) {
		super(name, source);
	}

}
