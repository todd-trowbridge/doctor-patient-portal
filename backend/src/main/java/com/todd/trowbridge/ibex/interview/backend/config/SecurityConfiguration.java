package com.todd.trowbridge.ibex.interview.backend.config;
import com.todd.trowbridge.ibex.interview.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.cert.Extension;


@Configuration // Spring Security Configuration
@EnableWebSecurity // Used to enable web security and select urls for protection
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // create admin in memory
//        auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder().encode("1234")).authorities("ADMIN", "DOCTOR", "PATIENT");
        //Database Auth
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Autowired
    private UserService userService;


    @Bean
    // create password encoder using BCrypt
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // permit any request that comes to this application
//        http.authorizeRequests().anyRequest().permitAll();
        http.authorizeRequests((request)->request.antMatchers("/admin").permitAll().anyRequest().authenticated()).httpBasic();

        http.formLogin();

        // enable basic authentication
        http.httpBasic();

        http.csrf().disable();
    }
}
