package com.app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration//to declare the class as java config class -
//equivalent to bean config xmlfile
@EnableWebSecurity//to enable spring sec config in this class
@EnableMethodSecurity//to enable method level security
public class SecurityConfiguration {
	/*
	 * configure spring bean(@Bean) to configure spring security filter chain
	 * 
	 */
	@Bean
	SecurityFilterChain configureSecFilterChain (HttpSecurity http) throws Exception
	{
		//disable CSRF protection : since un necessary with REST APIs
		http.csrf(csrf -> csrf.disable());
		//form login is enable by default, to disable it
		http.formLogin(form->form.disable())
		//enable Basic HTTP authentication
		.httpBasic(Customizer.withDefaults());
		//add url based authorization rules
		//un protected end points - swagger, view products
		http.authorizeHttpRequests(request -> 
		request.requestMatchers("/v*/api-docs/**","/swagger-ui/**",
				"/products/view").permitAll().anyRequest().authenticated());
		//Do authenticate every incoming  request
		
		//build spring sec filter chain
		return http.build();
		
	}

}
