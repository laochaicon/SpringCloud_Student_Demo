package qc.module.demo.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan({"qc.module.demo.service"})//不扫描service在controller中找不到对应的service
@ComponentScan({"qc.module.demo.api.controller"})//不扫描controller从gateway找不到对应的微服务
@ComponentScan({"qc.common.core"})
@MapperScan("qc.module.demo.repository")//不扫描repository在service中找不到对应的repository
@EnableSwagger2
public class DemoApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApiApplication.class, args);
    }

    /**
     * spring web模块中提供了一个RestTemplate对象可以完成远程调用
     * <p>
     * consumer--->resttemplare--->provider
     *
     * @return
     */
    @Bean
    @LoadBalanced // 开启负载均衡 Ribbon, 发送的请求都会被Ribbon拦截。必须使用应用名代替ip，否则报错
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
