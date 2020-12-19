package com.pig4cloud.cloud.mesh.config.sidecar.manage;

import java.util.Map;

/**
 * @author lengleng
 * @date 2020/12/18
 */
public interface ConfigLoad {

	/**
	 * 获取配置
	 * @param dataId
	 * @return
	 */
	Map<String, Object> getConfig(String dataId);

}
