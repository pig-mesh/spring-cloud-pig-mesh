package com.pig4cloud.cloud.mesh.example;

import com.pig4cloud.cloud.mesh.config.client.client.annotation.EnableMeshServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lengleng
 * @date 2020/12/16
 */
@EnableMeshServer
@SpringBootApplication
public class MeshRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeshRegistryApplication.class, args);
	}

}
