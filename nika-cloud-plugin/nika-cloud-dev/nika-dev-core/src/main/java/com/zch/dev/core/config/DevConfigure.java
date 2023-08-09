package com.zch.dev.core.config;

import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;
import com.zch.common.pojo.CommonResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import javax.annotation.Resource;

/**
 * @author Zch
 * @date 2023/8/9
 **/
@Configuration
public class DevConfigure {

    @Resource
    private OpenApiExtensionResolver openApiExtensionResolver;

    @Bean(value = "devDocApi")
    public Docket devDocApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("开发工具DEV")
                        .description("开发工具DEV")
                        .termsOfServiceUrl("http://localhost")
                        .contact(new Contact("Zch","https://github.com/poison02", "2069820192@qq.com"))
                        .version("1.0")
                        .build())
                .globalResponseMessage(RequestMethod.GET, CommonResult.responseList())
                .globalResponseMessage(RequestMethod.POST, CommonResult.responseList())
                .groupName("开发工具DEV")
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .apis(RequestHandlerSelectors.basePackage("com.zch.dev"))
                .paths(PathSelectors.any())
                .build().extensions(openApiExtensionResolver.buildExtensions("开发工具DEV"));
    }

}
