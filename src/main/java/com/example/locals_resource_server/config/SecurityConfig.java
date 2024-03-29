package com.example.locals_resource_server.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class SecurityConfig {

    @Value("${jwksUri}")
    private String jwksUri;

    @Value("${tripAdvisor.base.url}")
    private String apiURL;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.oauth2ResourceServer(
                r -> r.jwt().jwkSetUri(jwksUri)
                        .jwtAuthenticationConverter(new CustomJwtAuthorityTokenConverter())
        );

        http.authorizeHttpRequests().anyRequest()
                .authenticated().and()
                .oauth2ResourceServer()
                .jwt();
       http.csrf().disable().cors(cors -> cors.disable());

        return http.build();
    }

    @Bean
    public WebClient webClient() {
        return WebClient
                .builder()
                .baseUrl(apiURL)
                .build();
    }
}
