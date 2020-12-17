
package com.pig4cloud.cloud.mesh.discovery.client.registry;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.pig4cloud.cloud.mesh.discovery.client.properties.MeshDiscoveryProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.cloud.client.serviceregistry.ServiceRegistry;

/**
 * @author lengleng
 */
@Slf4j
@RequiredArgsConstructor
public class MeshServiceRegistry implements ServiceRegistry<Registration> {

	private final MeshDiscoveryProperties properties;

	@Override
	public void register(Registration registration) {
		HttpUtil.post(properties.getServerAddr() + "/instance/registry", JSONUtil.toJsonStr(registration));
	}

	@Override
	public void deregister(Registration registration) {

	}

	@Override
	public void close() {

	}

	@Override
	public void setStatus(Registration registration, String status) {

	}

	@Override
	public Object getStatus(Registration registration) {
		return "UP";
	}

}
