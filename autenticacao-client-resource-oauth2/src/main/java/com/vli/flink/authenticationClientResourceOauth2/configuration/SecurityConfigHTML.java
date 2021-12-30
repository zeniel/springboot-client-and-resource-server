package com.vli.flink.authenticationClientResourceOauth2.configuration;

import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity(debug = true)
@Order(20)
/**
 * referencia: https://stackoverflow.com/questions/58805033/using-spring-boot-2-oauth-client-and-resourceserver-in-the-same-context/58871511#58871511
 */
public class SecurityConfigHTML extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http
			.cors()
		.and()
			/*
			 *  README nao se pode colocar a URL de login junto de uma construcao com requestMatchers() 
			 *  o spring pira com isso, melhor deixar em um arquivo separado
			 */
			.requestMatchers().antMatchers("/frontend/**")
		.and()
			.authorizeRequests().anyRequest().authenticated()
		.and()
			.oauth2Login();
		// @formatter:on
	}
}
