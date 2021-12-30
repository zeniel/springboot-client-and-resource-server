package com.vli.flink.authenticationClientResourceOauth2.configuration;

import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity(debug = true)
@Order(10)
public class SecurityConfigAPI extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
    	http
				.cors()
			.and()
				.requestMatchers().antMatchers("/api/**")
			.and()
				.authorizeRequests().anyRequest().authenticated()
			.and()
				.oauth2ResourceServer().jwt();
		// @formatter:on		
    }
}