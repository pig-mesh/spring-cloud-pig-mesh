package com.pig4cloud.cloud.mesh.config.sidecar.manage;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.pig4cloud.cloud.mesh.config.sidecar.properties.MeshConfigServerProperties;
import lombok.RequiredArgsConstructor;

import java.util.Map;

/**
 * @author lengleng
 * @date 2020/12/18
 */
@RequiredArgsConstructor
public class HttpConfigLoad implements ConfigLoad {

	private final MeshConfigServerProperties properties;

	/**
	 * 获取配置
	 * @param dataId
	 * @return
	 */
	@Override
	public Map<String, Object> getConfig(String dataId) {
		String body = HttpUtil.get(properties.getServerAddr() + "/config/get/" + dataId);
		return JSONUtil.toBean(body, Map.class);
	}

}
