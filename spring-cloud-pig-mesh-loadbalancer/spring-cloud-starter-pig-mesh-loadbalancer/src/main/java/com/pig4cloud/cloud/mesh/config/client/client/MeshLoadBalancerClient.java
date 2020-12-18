/*
 * Copyright 2012-2020 the original author or authors.
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

package com.pig4cloud.cloud.mesh.config.client.client;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.*;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import static org.springframework.cloud.client.loadbalancer.reactive.ReactiveLoadBalancer.REQUEST;

/**
 * The default {@link LoadBalancerClient} implementation.
 *
 * @author Olga Maciaszek-Sharma
 * @since 2.2.0
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
@RequiredArgsConstructor
public class MeshLoadBalancerClient implements LoadBalancerClient {

	private final DiscoveryClient discoveryClient;

	@Override
	public <T> T execute(String serviceId, LoadBalancerRequest<T> request) throws IOException {
		DefaultRequest<DefaultRequestContext> lbRequest = new DefaultRequest<>(new DefaultRequestContext(request));

		ServiceInstance serviceInstance = choose(serviceId, lbRequest);
		if (serviceInstance == null) {
			throw new IllegalStateException("No instances available for " + serviceId);
		}
		return execute(serviceId, serviceInstance, request);
	}

	@SneakyThrows
	@Override
	public <T> T execute(String serviceId, ServiceInstance serviceInstance, LoadBalancerRequest<T> request)
			throws IOException {
		return request.apply(serviceInstance);
	}

	@Override
	public URI reconstructURI(ServiceInstance instance, URI original) {
		return LoadBalancerUriTools.reconstructURI(instance, original);
	}

	@Override
	public ServiceInstance choose(String serviceId) {
		return choose(serviceId, REQUEST);
	}

	@Override
	public <T> ServiceInstance choose(String serviceId, Request<T> request) {
		List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
		return instances.get(0);
	}

}
