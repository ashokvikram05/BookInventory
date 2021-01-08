package com.msys.bookinventory.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;



@Configuration
@EnableWebMvcSecurity
public class BookInventorySecurityConfig extends WebSecurityConfigurerAdapter  {

     @Autowired
     protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
         auth.inMemoryAuthentication()
            .withUser("admin").password("admin").roles("USER", "ADMIN")
            .and()
            .withUser("user1").password("user1").roles("USER");
    }
     
     @SuppressWarnings("deprecation")
     @Bean
     public static NoOpPasswordEncoder passwordEncoder() {
     return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
     }

    @Override
    protected void configure(HttpSecurity http) throws Exception {        
    	http.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/book/*").hasAnyRole("USER", "ADMIN")
		.antMatchers("/author/*").hasAnyRole("USER", "ADMIN")
		.antMatchers("/book/add","/book/edit/*", "/book/delete/*").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and()
		.httpBasic()
		.and()
		.exceptionHandling().accessDeniedPage("/403");
        
    }
}