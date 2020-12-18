package com.pig4cloud.cloud.mesh.config.client;

import com.pig4cloud.cloud.mesh.config.client.manage.ConfigLoad;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.CompositePropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;

import java.util.Map;

/**
 * @author lengleng
 * @date 2020/12/18
 */
@Slf4j
@Order(0)
@RequiredArgsConstructor
public class MeshPropertySourceLocator implements PropertySourceLocator, ApplicationContextAware {

	private static final String MESH_PROPERTY_SOURCE_NAME = "MESH";

	private ApplicationContext applicationContext;

	private final ConfigLoad configLoad;

	@Override
	public PropertySource<?> locate(Environment environment) {

		CompositePropertySource composite = new CompositePropertySource(MESH_PROPERTY_SOURCE_NAME);

		String dataId = environment.getProperty("spring.application.name");
		Map<String, Object> config = configLoad.getConfig(dataId);
		MeshPropertySource meshPropertySource = new MeshPropertySource(dataId, config);
		composite.addFirstPropertySource(meshPropertySource);
		return composite;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

}
