package com.pig4cloud.cloud.mesh.discovery.server.store;

import com.pig4cloud.cloud.mesh.discovery.client.annotation.InstanceInfo;

/**
 * @author lengleng
 * @date 2020/12/16
 * <p>
 * 服务存储接口
 */
public interface ServiceStore {

	/**
	 * 注册服务
	 * @param instanceInfo 实例信息
	 */
	void registry(InstanceInfo instanceInfo);

}
