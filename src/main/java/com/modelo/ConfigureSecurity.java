package com.modelo;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class ConfigureSecurity extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("maria")
		.password("maria")
		.roles("USER")
		.and()	
		.withUser("joao")
		.password("joao")
		.roles("ADMIN")
		.and().withUser("pedro")
		.password("pedro")		
		
		.roles("ADMIN");
			
	}
	
	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder PasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()		
		.antMatchers("/resources/**", "/webjars/**").permitAll()
		.antMatchers("/").hasAnyRole("ADMIN", "USER")		
		.antMatchers("/salvar").hasRole("ADMIN")
		.antMatchers("/ef/id").hasRole("ADMIN")
		.antMatchers("/delete/id").hasRole("ADMIN")
		.antMatchers("/cadastro").hasAnyRole("ADMIN", "USER")
		.anyRequest().authenticated()
		.and()
		.formLogin();
		//.antMatchers("/**").hasAnyRole("USER", "ADMIN");
		//.antMatchers("/cadastro**").hasAnyRole("USER", "ADMIN")
	}

}