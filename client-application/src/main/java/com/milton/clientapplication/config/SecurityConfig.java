package com.milton.clientapplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /*
    1. Disable Form Login: By not configuring form-based login (formLogin()), you prevent the application from redirecting unauthenticated requests to a login page.
    2. Permit All Requests: The authorizeHttpRequests().anyRequest().permitAll() configuration allows all requests without authentication, suitable for a client application acting on its own behalf.
    3. Disable CSRF Protection: Disabling CSRF protection is appropriate for non-browser clients, as they are not vulnerable to CSRF attacks.
    */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(authorize ->
                authorize.anyRequest().permitAll()).csrf(AbstractHttpConfigurer::disable);

        return httpSecurity.build();
    }
}
