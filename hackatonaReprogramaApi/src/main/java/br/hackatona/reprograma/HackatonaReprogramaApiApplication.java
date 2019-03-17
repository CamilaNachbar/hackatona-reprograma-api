package br.hackatona.reprograma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
		"br.hackatona.reprograma.**, br.hackatona.reprograma.serviceImpl.* " })
@EnableAutoConfiguration
@SpringBootApplication
public class HackatonaReprogramaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HackatonaReprogramaApiApplication.class, args);
	}

}
