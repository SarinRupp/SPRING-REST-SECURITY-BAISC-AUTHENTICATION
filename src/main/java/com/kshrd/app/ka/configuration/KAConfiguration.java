package com.kshrd.app.ka.configuration;

import java.util.Base64;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.HttpHeaders;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.kshrd.app.ka"})
@Import(SecurityConfiguration.class)
public class KAConfiguration {

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/bookwebserivce");
		dataSource.setUsername("postgres");
		dataSource.setPassword("123");
		return dataSource;
	}
	
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Bean
	public HttpHeaders getAuthenticationHeader() {
		String credentials = "SERCRET_API" + ":" + "SERCRET_API";
		//String credentials = "SELECT FROM DB";
		String base64CredentialData = Base64.getUrlEncoder().encodeToString(credentials.getBytes());
		System.out.println(base64CredentialData);
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Basic " + new String(base64CredentialData));
		return headers;
	}
	
}
