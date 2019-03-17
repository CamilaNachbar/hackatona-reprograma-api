package br.hackatona.reprograma;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.hackatona.reprograma.model.User;

@Configuration
@Profile("cloud")
@EnableJpaRepositories(basePackages = {"br.hackatona.reprograma.model.*"})
public class DataSourceConfiguration {

	@Bean
	public Cloud cloud() {
		return new CloudFactory().getCloud();
	}

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return cloud().getSingletonServiceConnector(DataSource.class, null);
	}
}