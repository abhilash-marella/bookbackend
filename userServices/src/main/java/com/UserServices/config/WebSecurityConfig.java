package com.UserServices.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.UserServices.filters.JwtRequestFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	@Autowired
	private UserDetailsService jwtUserDetailsService;
	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		

		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());

	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.cors();
		httpSecurity.csrf().disable()

				
				.authorizeRequests().antMatchers("/authenticate", "/home", "/booksearch", "/BookServices/search/**",

						"/BookServices/search/{bookId}","/register", "/swagger-resources/**", "/swagger-ui/**", "/v3/api-docs/**", "/webjars/**")
				.permitAll()
				.antMatchers("/home").access("hasRole('AUTHOR','READER')")
				.antMatchers("/updateUser").authenticated()
				.antMatchers("/BookServices/book/**").access("hasRole('AUTHOR')")
				.antMatchers("/BookServices/book/block/{id}").access("hasRole('AUTHOR')")
				.antMatchers("/BookServices/deleteBook/{bookId}").access("hasRole('AUTHOR')")
				
				.antMatchers("/BookServices/subscribe/{userId}/{bookId}").access("hasRole('READER')")
				.antMatchers("/BookServices/unsubscribe/{Id}").access("hasRole('READER')")
				.antMatchers("/BookServices/subscribedBooks/{userId}").access("hasRole('READER')")
				.antMatchers("/BookServices/subscribeHistory/{userId}").access("hasRole('READER')")
				.antMatchers("/BookServices/reading/{userId}/{SubscriptionId}").access("hasRole('READER')")
				.anyRequest().authenticated().and().exceptionHandling()
				.authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		return httpSecurity.build();
	}
}
