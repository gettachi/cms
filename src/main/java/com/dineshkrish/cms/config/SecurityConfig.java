package com.dineshkrish.cms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig  extends WebSecurityConfigurerAdapter {
    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        PasswordEncoder enconder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        User.UserBuilder userBuilder = User.builder().passwordEncoder(enconder::encode);
        UserDetails userDetails1 = userBuilder
                .username("myuser")
                .password("12345")
                .roles("USER")
                .build();
        UserDetails userDetails2 = userBuilder
                .username("myuser1")
                .password("12345")
                .roles("USER","ADMIN")
                .build();
        return new InMemoryUserDetailsManager(userDetails1,userDetails2);
    }
}
