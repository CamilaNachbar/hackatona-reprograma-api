package br.hackatona.reprograma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = {
		"br.hackatona.reprograma.**, br.hackatona.reprograma.repository.*, br.hackatona.reprograma.serviceImpl.* " })
@EnableAutoConfiguration
@EntityScan("br.hackatona.reprograma.model")
@EnableJpaRepositories("br.hackatona.reprograma.repository")
@SpringBootApplication
public class HackatonaReprogramaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HackatonaReprogramaApiApplication.class, args);
	}

}
