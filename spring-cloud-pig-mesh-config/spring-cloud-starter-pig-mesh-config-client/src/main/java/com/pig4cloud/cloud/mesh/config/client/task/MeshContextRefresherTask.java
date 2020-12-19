package com.pig4cloud.cloud.mesh.config.client.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.cloud.endpoint.event.RefreshEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author lengleng
 * @date 2020/12/18
 */
@Slf4j
public class MeshContextRefresherTask implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Scheduled(cron = "0/10 * * * * ? ")
	public void refresh() {
		log.debug("开始更新配置文件");
		// CRON 任务 订阅 配置中心事件
		applicationContext.publishEvent(new RefreshEvent(this, null, "Refresh mesh config"));
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

}
