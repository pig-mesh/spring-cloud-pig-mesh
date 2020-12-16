package com.pig4cloud.cloud.mesh.discovery.client.annotation;

import lombok.Data;

/**
 * @author lengleng
 * @date 2020/12/16
 * <p>
 * 实例信息
 */
@Data
public class InstanceInfo {

	private String instanceId;

	private String serviceId;

	private String host;

	private Integer port;

}
