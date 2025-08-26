package com.milton.clientapplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.security.oauth2.client.web.server.WebSessionServerOAuth2AuthorizedClientRepository;

//@Configuration
//public class WebClientConfig {
//    @Bean
//    public WebClient webClient(ReactiveClientRegistrationRepository clientRegistrations) {
//        ServerOAuth2AuthorizedClientExchangeFilterFunction oauth2 =
//                new ServerOAuth2AuthorizedClientExchangeFilterFunction(
//                        clientRegistrations, new WebSessionServerOAuth2AuthorizedClientRepository()
//                );
//        oauth2.setDefaultOAuth2AuthorizedClient(true); // Optional: auto attach token
//
//        return WebClient.builder()
//                .filter(oauth2)
//                .build();
//    }
//}
