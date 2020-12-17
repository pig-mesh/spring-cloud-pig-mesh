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

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.Collections;
import java.util.List;

/**
 * @author lengleng
 */
@Slf4j
@RequiredArgsConstructor
public class MeshRegistryDiscoveryClient implements DiscoveryClient {

	private static final String DESCRIPTION = "Spring Cloud Pig Mesh Discovery Client";

	private final MeshRegistryDiscovery discovery;

	@Override
	public String description() {
		return DESCRIPTION;
	}

	@Override
	public List<ServiceInstance> getInstances(String serviceId) {
		try {
			return discovery.getInstances(serviceId);
		}
		catch (Exception e) {
			throw new RuntimeException("Can not get hosts from mesh server. serviceId: " + serviceId, e);
		}
	}

	@Override
	public List<String> getServices() {
		try {
			return discovery.getServices();
		}
		catch (Exception e) {
			log.error("get service name from mesh server fail,", e);
			return Collections.emptyList();
		}
	}

}
