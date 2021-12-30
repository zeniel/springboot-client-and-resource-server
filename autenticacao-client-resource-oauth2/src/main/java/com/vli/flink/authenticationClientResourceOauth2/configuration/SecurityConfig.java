package com.vli.flink.authenticationClientResourceOauth2.configuration;

import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Order(30)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http
		.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/login/**").authenticated() // camiho indicado na configuracao de redirect
			.anyRequest().authenticated()
		.and()
			.oauth2Login();
		// @formatter:on
	}
}