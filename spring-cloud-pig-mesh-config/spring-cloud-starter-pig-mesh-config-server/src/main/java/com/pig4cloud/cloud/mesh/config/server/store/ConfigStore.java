package com.pig4cloud.cloud.mesh.config.server.store;

import java.util.Map;

/**
 * @author lengleng
 * @date 2020/12/18
 * <p>
 * 配置文件存储
 */
public interface ConfigStore {

	/**
	 * 添加配置
	 * @param dataId dataId
	 * @param configMap 配置键值对
	 */
	void addConfig(String dataId, Map<String, Object> configMap);

	/**
	 * 获取配置键值对
	 * @param dataId dataId
	 * @return 配置键值对
	 */
	Map<String, Object> getConfig(String dataId);

}
