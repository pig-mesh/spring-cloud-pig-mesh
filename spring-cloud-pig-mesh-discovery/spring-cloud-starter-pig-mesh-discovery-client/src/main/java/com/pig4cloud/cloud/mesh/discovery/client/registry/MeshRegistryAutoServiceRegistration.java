/*
 * Copyright 2013-2020 the original author or authors.
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

package com.pig4cloud.cloud.mesh.discovery.client.registry;

import org.springframework.cloud.client.serviceregistry.AbstractAutoServiceRegistration;
import org.springframework.cloud.client.serviceregistry.AutoServiceRegistrationProperties;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.cloud.client.serviceregistry.ServiceRegistry;

/**
 * @author lengleng
 */
public class MeshRegistryAutoServiceRegistration extends AbstractAutoServiceRegistration<Registration> {

	private AutoServiceRegistrationProperties properties;

	private MeshRegistryRegistration registration;

	public MeshRegistryAutoServiceRegistration(ServiceRegistry<Registration> serviceRegistry,
			AutoServiceRegistrationProperties properties, MeshRegistryRegistration registration) {
		super(serviceRegistry, properties);
		this.properties = properties;
		this.registration = registration;
	}

	/**
	 * @deprecated
	 */
	@Override
	protected Object getConfiguration() {
		return null;
	}

	@Override
	protected boolean isEnabled() {
		return properties.isEnabled();
	}

	@Override
	protected Registration getRegistration() {
		registration.setServiceId(getAppName());
		registration.setPort(getPort().get());
		return registration;
	}

	@Override
	protected MeshRegistryRegistration getManagementRegistration() {
		return null;
	}

}
