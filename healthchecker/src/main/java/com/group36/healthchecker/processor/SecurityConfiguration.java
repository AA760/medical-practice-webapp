package com.group36.healthchecker.processor;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter 
{

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception 
    {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception 
    {
    	
    	http.cors().and().csrf().disable();
    	
       //Role authorisations for the API endpoints
    	http.authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/patient").hasAnyRole("ADMIN", "PATIENT")
                .antMatchers("/doctor").hasAnyRole("ADMIN", "DOCTOR")
                .antMatchers("/").permitAll()
                .antMatchers("/createUser").hasAnyRole("ADMIN")
                .antMatchers("/users").hasAnyRole("ADMIN")
                .antMatchers("/deleteUserName/{userName}").hasAnyRole("ADMIN")
                .antMatchers("/deleteId/{id}").hasAnyRole("ADMIN")
                .antMatchers("/changePassword").hasAnyRole("ADMIN")
                .and()
                .httpBasic()
                .and()
                .logout()
                .logoutUrl("/logout")
                .and()
                .formLogin();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() 
    {
        return NoOpPasswordEncoder.getInstance();
    }
    

    }