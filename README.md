从零造轮子， 实现一套 基于 Spring Cloud Commons 标准的 微服务解决方案


## 目录接口

```yaml
├── spring-cloud-pig-mesh-config
│   ├── spring-cloud-starter-pig-mesh-config-client
│   └── spring-cloud-starter-pig-mesh-config-server
├── spring-cloud-pig-mesh-dependencies
├── spring-cloud-pig-mesh-discovery
│   ├── spring-cloud-pig-mesh-discovery-common
│   ├── spring-cloud-starter-pig-mesh-discovery-client
│   └── spring-cloud-starter-pig-mesh-discovery-server
├── spring-cloud-pig-mesh-examples
│   ├── spring-cloud-starter-pig-mesh-config-client-example
│   ├── spring-cloud-starter-pig-mesh-config-server-example
│   ├── spring-cloud-starter-pig-mesh-discovery-client-example
│   ├── spring-cloud-starter-pig-mesh-discovery-server-example
│   └── spring-cloud-starter-pig-mesh-discovery-sidecar-example
├── spring-cloud-pig-mesh-loadbalancer
│   └── spring-cloud-starter-pig-mesh-loadbalancer
└── spring-cloud-pig-mesh-sidecar
    └── spring-cloud-starter-pig-mesh-sidecar
```

## 使用依赖

```xml
<!-- 快照版本需要配置 pig mesh nexus-->
<repositories>
    <repository>
        <id>pig-mesh-snapshots</id>
        <name>Mesh Snapshots</name>
        <url>https://nexus.pigx.vip/repository/maven-snapshots</url>
        <snapshots>
            <enabled>true</enabled>
        </snapshots>
    </repository>
</repositories>


<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>com.pig4cloud.cloud</groupId>
            <artifactId>spring-cloud-pig-mesh-dependencies</artifactId>
	        <version>0.0.1-SNAPSHOT</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```