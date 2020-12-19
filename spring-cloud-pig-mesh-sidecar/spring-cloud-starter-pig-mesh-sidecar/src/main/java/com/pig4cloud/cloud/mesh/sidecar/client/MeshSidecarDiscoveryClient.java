package com.pig4cloud.cloud.mesh.sidecar.client;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.pig4cloud.cloud.mesh.sidecar.properties.MeshDiscoveryProperties;
import com.pig4cloud.cloud.mesh.sidecar.properties.MeshSidecarProperties;
import lombok.RequiredArgsConstructor;

/**
 * @author lengleng
 * @date 2020/12/19
 * <p>
 * mesh Sidecar
 */
@RequiredArgsConstructor
public class MeshSidecarDiscoveryClient implements SidecarDiscoveryClient {

	private final MeshDiscoveryProperties properties;

	/**
	 * register instance.
	 * @param sidecarProperties 注册信息
	 */
	@Override
	public void registerInstance(MeshSidecarProperties sidecarProperties) {
		HttpUtil.post(properties.getServerAddr() + "/instance/registry", JSONUtil.toJsonStr(sidecarProperties));
	}

	/**
	 * deregister instance.
	 * @param sidecarProperties 注销信息
	 */
	@Override
	public void deregisterInstance(MeshSidecarProperties sidecarProperties) {

	}

}
