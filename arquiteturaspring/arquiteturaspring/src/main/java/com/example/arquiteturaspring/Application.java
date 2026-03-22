package com.example.arquiteturaspring;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class Application {

	static void main(String[] args) {

		// SpringApplication.run(Application.class, args); --> uma das maneiras
		SpringApplicationBuilder builder =
				new SpringApplicationBuilder(Application.class); // builder para configuração personalizada

		// builder.bannerMode(Banner.Mode.OFF); --> Metódo para desligar/alterar o banner padrão
		// var produtoRepository = applicationContext.getBean("produtoRepository"); --> Para resgatar o nome do produto/objeto por meio do Bean
		builder.profiles("produção", "homologacao"); // --> para integrar perfis no momento de debug

		builder.run(args);

		// Contexto da aplicação já iniciada
		ConfigurableApplicationContext applicationContext = builder.context();

		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		String aplicationNome = environment.getProperty("spring.application.name");
		System.out.println("Nome da aplicação: " + aplicationNome);

	}
}
