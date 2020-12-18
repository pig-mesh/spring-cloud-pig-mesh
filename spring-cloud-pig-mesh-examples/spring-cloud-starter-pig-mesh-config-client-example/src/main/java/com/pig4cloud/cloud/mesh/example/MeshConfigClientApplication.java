package com.pig4cloud.cloud.mesh.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lengleng
 * @date 2020/12/16
 */
@EnableDiscoveryClient
@SpringBootApplication
public class MeshConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeshConfigClientApplication.class, args);
	}

}
