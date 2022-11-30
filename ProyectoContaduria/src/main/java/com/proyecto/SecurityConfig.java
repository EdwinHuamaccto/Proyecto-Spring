package com.proyecto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		/*
		 * http.csrf(csrf->csrf.disable()) .authorizeHttpRequests((auth)->{
		 * auth.antMatchers("/LibroDiario/lista","/resources/**").permitAll();
		 * auth.anyRequest().authenticated();}) .formLogin(form->
		 * form.loginPage("/login") .permitAll().defaultSuccessUrl("/menu"));
		 */
		http.authorizeRequests()
		.antMatchers("/LibroDiario/lista","/resources/**").permitAll()
		.antMatchers("/mantemiento/buscarEmpresa").permitAll()
		.antMatchers("/mantemiento/eliminarEmpresa").permitAll()
		.antMatchers("/mantemiento/empresa").permitAll()
		.antMatchers("/mantemiento/buscarDetalle").permitAll()
		.antMatchers("/mantemiento/eliminarDetalle").permitAll()
		.antMatchers("/mantemiento/detalle").permitAll()
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/login").permitAll()
		.and().logout().permitAll();
		
		return http.build();
	}
}
