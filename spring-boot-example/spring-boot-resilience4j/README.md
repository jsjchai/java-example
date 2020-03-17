# resilience4j

## 介绍

## Maven
springboot
```xml
 <dependency>
      <groupId>io.github.resilience4j</groupId>
      <artifactId>resilience4j-spring-boot2</artifactId>
 </dependency>
```

## 核心模块

### CircuitBreaker
> 熔断器

### Bulkhead
> 并发控制

### Retry
> 重试策略

### RateLimiter
> 速率限制

### TimeLimiter
> 内存

### Cache
> 缓存异常处理

## 监控
1. 添加jar包
```xml
 <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
 </dependency>
 <dependency>
            <groupId>io.micrometer</groupId>
            <artifactId>micrometer-registry-prometheus</artifactId>
 </dependency>
```
2. application.yml配置prometheus
```yaml
management:
  endpoints:
    web:
      exposure:
        include: health,info,prometheus
  metrics:
    tags:
      application: ${spring.application.name}
```
* 访问 http://127.0.0.1:9180/actuator/prometheus

3. 安装prometheus

[Run Docker image](https://grafana.com/docs/grafana/latest/installation/docker/)
```shell
docker run  -d -p 9090:9090 -v "d:/docker/prometheus/prometheus.yml:/etc/prometheus/prometheus.yml"  prom/prometheus
```
[prometheus.yml](https://github.com/jsjchai/java-example/blob/master/spring-boot-example/spring-boot-resilience4j/src/main/resources/prometheus.yml)

4. 安装grafana

[grafana_dashboard.json](https://resilience4j.readme.io/docs/grafana-1)



## demo

## 参考文档
https://resilience4j.readme.io/docs

