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

package com.pig4cloud.cloud.mesh.sidecar.support;

import com.pig4cloud.cloud.mesh.sidecar.client.SidecarDiscoveryClient;
import com.pig4cloud.cloud.mesh.sidecar.properties.MeshSidecarProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author lengleng
 * <p>
 * 异构服务注册
 */
@Slf4j
@RequiredArgsConstructor
public class SidecarHealthRegister {

	private final MeshSidecarProperties sidecarProperties;

	private final SidecarDiscoveryClient discoveryClient;

	public void register() {
		discoveryClient.registerInstance(sidecarProperties);
		log.debug("异构服务 {} 注册完成", discoveryClient);
	}

}
