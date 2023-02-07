package com.example.myweb.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class OAuth2LoginSecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(e -> {
				e.requestMatchers("/login/oauth2").permitAll()
						.requestMatchers("/vendors/**").permitAll()
						.requestMatchers("/css/**").permitAll()
						.requestMatchers("/js/**").permitAll()
						.requestMatchers("/Roboto/**").permitAll()
						.requestMatchers("/images/**").permitAll()
						.requestMatchers("/fonts/**").permitAll()
						.anyRequest().authenticated();})
				.oauth2Login(oauth2 -> oauth2
						.redirectionEndpoint(redirection -> redirection
								.baseUri("/login/oauth2/code/*")).loginPage("/login/oauth2"));

		return http.build();
	}


}