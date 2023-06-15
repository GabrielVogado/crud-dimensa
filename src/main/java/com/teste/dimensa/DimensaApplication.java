package com.teste.dimensa;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DimensaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DimensaApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Dimensa - Avaliação para Desenvolvedores")
						.version("1.0")
						.description("**Objetivo:** Criar uma API RESTful capaz de gerenciar contatos e hospeda-la em nuvem")
						.termsOfService("http://swagger.io/terms/")
						.license(new License().name("Apache 2.0").url("http://springdoc.org")));

	}

}
