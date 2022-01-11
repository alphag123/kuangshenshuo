package com.kuang.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2 //开启swagger2
public class SwaggerConfig {


    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }

    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }

    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }

    //配置了swagger的docket的bean实例
    //enable是否启动swagger 如果为false,则swagger不能在浏览器中
    @Bean
    public Docket docket(Environment environment){


        //设置了要显示的swagger环境
        Profiles profiles = Profiles.of("dev","test");

        //通过environment.acceptsProfiles判断是否处在自己设定的环境当中
        boolean flag = environment.acceptsProfiles(profiles);



        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(false)
                .select()
                //RequestHandlerSelectors 配置需要扫描接口的方式
                /*
                any()扫描全部 none()不扫描
                withclassAnnotation()扫描类上的注解，参数是一个注解的反射对象
                withMethodAnnotation()扫描方法上的注解
                 */
                //.apis(RequestHandlerSelectors.withMethodAnnotation(GetMapping.class))
                .apis(RequestHandlerSelectors.basePackage("com.kuang.swagger.controller"))
                //paths():过滤什么路径
                .paths(PathSelectors.ant("/kuang/**"))
                .build();
    }

    //配置swagger信息 = apiinfo
    private ApiInfo apiInfo(){
        return new ApiInfo("狂神的swaggerAPI文档",
                "即使再小的帆也能远航",
                "1.0",
                "https://blog.kuangstudy.com/",
                ApiInfo.DEFAULT_CONTACT,
                "Apache 2.0",
                "http://www.apache.org/licences/LICENSE-2.0",
                new ArrayList<>());
    }

}
