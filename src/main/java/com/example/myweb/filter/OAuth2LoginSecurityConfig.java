package com.example.myweb.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class OAuth2LoginSecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(e ->
				e.requestMatchers("/login/oauth2","/vendors/**","/css/**",
								"/js/**","/Roboto/**","/images/**","/fonts/**").permitAll()
						.anyRequest().authenticated())
				/**/
				/*.formLogin(form -> form
						.loginPage("/login")
						.permitAll())*/
				.oauth2Login(oauth2 -> oauth2
						.redirectionEndpoint(redirection -> redirection
								.baseUri("/login/oauth2/code/*")).loginPage("/login/oauth2"));

		return http.build();
	}


	/*@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails user = User.withDefaultPasswordEncoder()
				.username("user")
				.password("password")
				.roles("USER")
				.build();
		return new InMemoryUserDetailsManager(user);
	}*/


}