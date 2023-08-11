package com.zch.web;

import com.zch.common.runner.AppStartupListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * @author Zch
 * @date 2023/8/11
 **/
@SpringBootApplication(scanBasePackages = {"com.zch"})
@Slf4j
@EnableSwagger2WebMvc
@RestController
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.zch")
public class NikaWebApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(NikaWebApplication.class);
        application.run(args);
        log.info(">>> {}", NikaWebApplication.class.getSimpleName().toUpperCase() + "STARTING SUCCESS!!!");
    }

    @GetMapping("/")
    public String index() {
        return "WELCOME TO NIKA-CLOUD!!!";
    }

    @Bean
    public AppStartupListener appStartupListener() {
        return new AppStartupListener();
    }

}
