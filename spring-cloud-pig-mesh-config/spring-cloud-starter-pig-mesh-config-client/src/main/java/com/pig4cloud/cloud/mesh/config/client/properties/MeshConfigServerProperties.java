package com.pig4cloud.cloud.mesh.config.client.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author lengleng
 * @date 2020/12/17
 */
@Data
@ConfigurationProperties(MeshConfigServerProperties.SPRING_CLOUD_MESH_CONFIG)
public class MeshConfigServerProperties {

	public static final String SPRING_CLOUD_MESH_CONFIG = "spring.cloud.mesh.config";

	/**
	 * mesh discovery server address.
	 */
	private String serverAddr;

}
