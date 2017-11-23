package mx.dannyyesoft.crm;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan({ "mx.dannyyesoft.crm", "mx.dannyyesoft.crm.service", "mx.dannyyesoft.crm.repository" })
public class CrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrmApplication.class, args);
	}

	@Bean
	public Docket newsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("kingdom").apiInfo(apiInfo()).select()
				.paths(regex("/kingdom.*")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Spring REST Sample with Swagger")
				.description("Spring REST Sample with Swagger")
				// .termsOfServiceUrl("http://www-03.ibm.com/software/sla/sladb.nsf/sla/bm?Open")
				.contact("www.dannyyesoft.mx").license("Todos los derechos reservados")
				// .licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE").version("1.0")
				.build();
	}

}
