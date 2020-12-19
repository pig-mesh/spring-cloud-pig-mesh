/*
 * Copyright 2013-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pig4cloud.cloud.mesh.discovery.client.discovery;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.pig4cloud.cloud.mesh.discovery.client.annotation.InstanceInfo;
import com.pig4cloud.cloud.mesh.discovery.client.properties.MeshDiscoveryProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author lengleng
 */
@Slf4j
@RequiredArgsConstructor
public class MeshRegistryDiscovery {

	private final MeshDiscoveryProperties properties;

	/**
	 * 根据服务ID 获取实例列表
	 * @param serviceId 服务ID
	 */
	public List<ServiceInstance> getInstances(String serviceId) {
		String result = HttpUtil.get(properties.getServerAddr() + "/instance/list/" + serviceId);
		log.debug("mesh registry return {}", result);
		return JSONUtil.parseArray(result).toList(InstanceInfo.class).stream().map(info -> new ServiceInstance() {
			/**
			 * @return The unique instance ID as registered.
			 */
			@Override
			public String getInstanceId() {
				return info.getInstanceId();
			}

			@Override
			public String getServiceId() {
				return info.getServiceId();
			}

			@Override
			public String getHost() {
				return info.getHost();
			}

			@Override
			public int getPort() {
				return info.getPort();
			}

			@Override
			public boolean isSecure() {
				return false;
			}

			@Override
			public URI getUri() {
				return null;
			}

			@Override
			public Map<String, String> getMetadata() {
				return null;
			}
		}).collect(Collectors.toList());
	}

	/**
	 * 获取服务ID 列表
	 * @return
	 */
	public List<String> getServices() {
		String result = HttpUtil.get(properties.getServerAddr() + "/service");
		log.debug("mesh registry return {}", result);
		return JSONUtil.parseArray(result).toList(String.class);
	}

}
