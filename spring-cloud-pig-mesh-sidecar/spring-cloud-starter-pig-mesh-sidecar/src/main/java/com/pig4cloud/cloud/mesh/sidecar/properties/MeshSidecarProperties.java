package com.pig4cloud.cloud.mesh.sidecar.properties;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.UUID;

/**
 * @author lengleng
 * @date 2020/12/19
 */
@Data
@ConfigurationProperties(MeshSidecarProperties.SPRING_CLOUD_MESH_SIDECAR)
public class MeshSidecarProperties implements InitializingBean {

	public static final String SPRING_CLOUD_MESH_SIDECAR = "spring.cloud.mesh.sidecar";

	/**
	 * 实例ID
	 */
	private String instanceId;

	/**
	 * 目标服务名称
	 */
	private String serviceId;

	/**
	 * 目标服务IP
	 */
	private String host;

	/**
	 * 目标服务端口
	 */
	private Integer port;

	@Override
	public void afterPropertiesSet() throws Exception {
		this.instanceId = UUID.randomUUID().toString();
	}

}
