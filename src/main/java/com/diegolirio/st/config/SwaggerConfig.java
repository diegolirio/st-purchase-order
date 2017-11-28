package com.diegolirio.st.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
 
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.diegolirio.st.apis.v1"))
				//.paths(PathSelectors.regex("/apis/v1.*")).build()
				.paths(PathSelectors.any()).build()
				.apiInfo(metaData());

	}

	private ApiInfo metaData() {
		ApiInfo apiInfo = new ApiInfo("Purchase", 
								      "Purchase - REST API", 
								      "1.0", 
								      "Terms of service", 
								      new Contact("Diego Lirio", "https://github.com/diegolirio/st-purchase-order", "diegolirio.dl@gmail.com"),
								      "Apache License Version 2.0", 
								      "https://www.apache.org/licenses/LICENSE-2.0");
		return apiInfo; 
	}
		
}