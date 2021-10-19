package in.tatsam.priority.configuration;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SuppressWarnings("deprecation")
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket collectionServiceApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("in.tatsam.priority.controller")).paths(regex("/api.*"))
				.build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Priority-Service API")
				.description("Priority-Service API reference for developers").termsOfServiceUrl("gopal")
				.contact("komati.gopal@gmail.com").license("gopal").licenseUrl("url").version("1.0").build();
	}

}
