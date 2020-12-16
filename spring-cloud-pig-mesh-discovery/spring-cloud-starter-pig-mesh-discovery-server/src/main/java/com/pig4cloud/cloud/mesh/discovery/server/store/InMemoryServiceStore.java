package com.pig4cloud.cloud.mesh.discovery.server.store;

import com.pig4cloud.cloud.mesh.discovery.client.annotation.InstanceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lengleng
 * @date 2020/12/16
 * <p>
 * 服务存储内存实现
 */
@Slf4j
@Service
public class InMemoryServiceStore implements ServiceStore {

	private static Map<String, List<InstanceInfo>> map = new ConcurrentHashMap<>();

	/**
	 * 注册服务
	 * @param instanceInfo 实例信息
	 */
	@Override
	public void registry(InstanceInfo instanceInfo) {
		log.info("服务注册 :{}", instanceInfo);
		String serviceName = instanceInfo.getServiceId();

		List<InstanceInfo> instanceList = map.get(instanceInfo.getServiceId());
		if (CollectionUtils.isEmpty(instanceList)) {
			instanceList = new ArrayList<>();
		}
		instanceList.add(instanceInfo);
		map.put(serviceName, instanceList);
	}

}
