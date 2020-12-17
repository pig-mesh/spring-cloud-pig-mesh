package com.pig4cloud.cloud.mesh.discovery.client.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author lengleng
 * @date 2020/12/17
 */
@Data
@ConfigurationProperties(MeshDiscoveryProperties.SPRING_CLOUD_MESH_DISCOVERY)
public class MeshDiscoveryProperties {

	public static final String SPRING_CLOUD_MESH_DISCOVERY = "spring.cloud.mesh.discovery";

	/**
	 * mesh discovery server address.
	 */
	private String serverAddr;

}
