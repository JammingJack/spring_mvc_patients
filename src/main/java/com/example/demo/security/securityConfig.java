
package com.example.demo.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class securityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private UserDetailsService myUserDetailsService;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder  passwordEncoder = passwordEncoder();
		
		//IN MEMORY AUTH
		  auth.inMemoryAuthentication().withUser("User1").password(passwordEncoder.
		  encode("1234")).roles("USER");
		  auth.inMemoryAuthentication().withUser("User2").password(passwordEncoder.
		  encode("1234")).roles("USER");
		  auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.
		  encode("1234")).roles("USER","ADMIN");
		// JDBC AUTH
		/*
		 * auth.jdbcAuthentication() .dataSource(dataSource)
		 * .usersByUsernameQuery("select username as principal, password as credentials, active from users where username = ?"
		 * )
		 * .authoritiesByUsernameQuery("select username as principale, role as role from users_roles where username = ?"
		 * ) .passwordEncoder(passwordEncoder) .rolePrefix("ROLE_");
		*/

		//USER DETAIL SERVICE AUTH

		//auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin();
		http.authorizeRequests().antMatchers("/save**/**","/delete**/**","/form**/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers("/index**/**").hasRole("USER");
		//http.authorizeRequests().anyRequest().authenticated();
		http.exceptionHandling().accessDeniedPage("/notAuthorized");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
