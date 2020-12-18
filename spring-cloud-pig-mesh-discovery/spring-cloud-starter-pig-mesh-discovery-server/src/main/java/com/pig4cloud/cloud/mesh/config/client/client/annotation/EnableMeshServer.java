package com.pig4cloud.cloud.mesh.config.client.client.annotation;

import com.pig4cloud.cloud.mesh.config.client.client.MeshServerMarkerConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author lengleng
 * @date 2020/12/16
 * <p>
 * Annotation to activate Mesh Server related configuration.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(MeshServerMarkerConfiguration.class)
public @interface EnableMeshServer {

}
