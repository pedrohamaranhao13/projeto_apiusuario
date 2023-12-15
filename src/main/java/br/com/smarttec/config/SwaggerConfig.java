package br.com.smarttec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI custonOpenApi() {
		return new OpenAPI()
				.components(new Components())
				.info(new Info()
						.title("API para controle de usuários")
						.description("Projeto desenvolvido com Spring Boot e Spring Data JPA")
						.version("v1")
						.contact(new Contact()
								.name("Smarttec")
								.email("pedro.maranhao@yahoo.com.br")));
						
	}
	
}
