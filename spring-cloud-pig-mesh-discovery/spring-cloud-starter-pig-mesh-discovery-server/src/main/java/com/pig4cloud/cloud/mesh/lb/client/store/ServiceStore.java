package com.pig4cloud.cloud.mesh.lb.client.store;

import com.pig4cloud.cloud.mesh.discovery.client.annotation.InstanceInfo;

import java.util.List;
import java.util.Set;

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

	/**
	 * 获取服务所有实例
	 * @param serviceId 服务ID
	 */
	List<InstanceInfo> instanceInfo(String serviceId);

	/**
	 * 已注册服务列表
	 */
	Set<String> services();

}
