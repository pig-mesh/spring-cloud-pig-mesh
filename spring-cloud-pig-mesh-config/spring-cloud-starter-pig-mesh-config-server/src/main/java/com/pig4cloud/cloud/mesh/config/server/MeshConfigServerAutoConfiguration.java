package com.pig4cloud.cloud.mesh.config.server;

import com.pig4cloud.cloud.mesh.config.server.endpoint.MeshConfigEndpoint;
import com.pig4cloud.cloud.mesh.config.server.store.ConfigStore;
import com.pig4cloud.cloud.mesh.config.server.store.RedisConfigStore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author lengleng
 * @date 2020/12/18
 */
@Configuration(proxyBeanMethods = false)
public class MeshConfigServerAutoConfiguration {

	@Bean
	@ConditionalOnMissingBean
	public ConfigStore configStore(RedisTemplate redisTemplate) {
		return new RedisConfigStore(redisTemplate);
	}

	@Bean
	public MeshConfigEndpoint configEndpoint(ConfigStore configStore) {
		return new MeshConfigEndpoint(configStore);
	}

}
