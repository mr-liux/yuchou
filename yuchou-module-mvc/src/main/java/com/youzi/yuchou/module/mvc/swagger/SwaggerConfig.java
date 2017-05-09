package com.youzi.yuchou.module.mvc.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
 
/**
 * SwaggerConfig
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
 
 
	private ApiInfo initApiInfo() {
		ApiInfo apiInfo = new ApiInfo("御筹商城官方API", // 大标题
				initContextInfo(), // 简单的描述
				"1.0.0", // 版本
				"服务条款", "后台开发团队", // 作者
				"御筹（上海）科技有限公司", // 链接显示文字
				""// 网站链接
		);
		return apiInfo;
	}
 
	private String initContextInfo() {
		StringBuffer sb = new StringBuffer();
		sb.append("REST API 设计在细节上有很多自己独特的需要注意的技巧，并且对开发人员在构架设计能力上比传统 API 有着更高的要求。").append("<br/>")
				.append("以下是本项目的API文档");
		return sb.toString();
	}
 

	
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(initApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.youzi.yuchou.admin"))
                .paths(PathSelectors.any())
                .build();
    }
 

}