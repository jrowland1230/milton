package com.milton.clientapplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.client.OAuth2ClientHttpRequestInterceptor;
import org.springframework.web.client.RestClient;

//@Configuration
//public class RestClientConfig {
//
//    @Bean
//    public RestClient restClient(OAuth2AuthorizedClientManager oAuth2AuthorizedClientManager) {
//        OAuth2ClientHttpRequestInterceptor oAuth2ClientHttpRequestInterceptor =
//                new OAuth2ClientHttpRequestInterceptor(oAuth2AuthorizedClientManager);
//
//        return RestClient.builder()
//                .requestInterceptor(oAuth2ClientHttpRequestInterceptor)
//                .build();
//    }
//}