package com.zch.sys.core.config;

import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;
import com.zch.pojo.CommonResult;
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
 * 系统功能相关配置
 * @author Zch
 * @date 2023/8/6
 **/
@Configuration
public class SysConfigure {

    @Resource
    private OpenApiExtensionResolver openApiExtensionResolver;

    @Bean(value = "sysDocApi")
    public Docket sysDocApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("系统功能sys")
                        .description("系统功能sys")
                        .termsOfServiceUrl("127.0.0.1")
                        .contact(new Contact("Zch", "https://github.com/poison02", "2069820192@qq.com"))
                        .version("1.0")
                        .build())
                .globalResponseMessage(RequestMethod.GET, CommonResult.responseList())
                .globalResponseMessage(RequestMethod.POST, CommonResult.responseList())
                .groupName("系统功能sys")
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .apis(RequestHandlerSelectors.basePackage("com.zch.sys"))
                .paths(PathSelectors.any())
                .build().extensions(openApiExtensionResolver.buildExtensions("系统功能sys"));
    }

}
