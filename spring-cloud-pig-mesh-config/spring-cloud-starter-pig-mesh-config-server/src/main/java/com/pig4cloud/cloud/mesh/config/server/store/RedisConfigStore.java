package com.pig4cloud.cloud.mesh.config.server.store;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author lengleng
 * @date 2020/12/18
 */
@RequiredArgsConstructor
public class RedisConfigStore implements ConfigStore {

	private final RedisTemplate<String, Object> redisTemplate;

	/**
	 * 添加配置
	 * @param dataId dataId
	 * @param configMap 配置键值对
	 */
	@Override
	public void addConfig(String dataId, Map<String, Object> configMap) {
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashValueSerializer(new StringRedisSerializer());
		redisTemplate.opsForHash().putAll(dataId, configMap);
	}

	/**
	 * 获取配置键值对
	 * @param dataId dataId
	 * @return 配置键值对
	 */
	@Override
	public Map<String, Object> getConfig(String dataId) {
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashValueSerializer(new StringRedisSerializer());
		Set<Object> keys = redisTemplate.opsForHash().keys(dataId);
		Map<String, Object> result = new HashMap<>(16);

		for (Object key : keys) {
			Object o = redisTemplate.opsForHash().get(dataId, key);
			result.put((String) key, o);
		}
		return result;
	}

}
