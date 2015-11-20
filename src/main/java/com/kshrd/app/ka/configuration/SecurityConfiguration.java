package com.kshrd.app.ka.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		
		auth.inMemoryAuthentication()
			.withUser("SERCRET_API")
			.password("SERCRET_API")
			.roles("SERCRET_API");
		
		
		
		auth.inMemoryAuthentication()
			.withUser("admin")
			.password("admin")
			.roles("ADMIN");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/")
			.permitAll();
		http.authorizeRequests()
			.antMatchers("/admin/**")
			.hasRole("ADMIN");
		http.authorizeRequests()
			.antMatchers("/api/**")
			.hasAnyRole("ADMIN","SERCRET_API");
		http.formLogin();
		http.httpBasic();
		http.csrf().disable();

	}


}
