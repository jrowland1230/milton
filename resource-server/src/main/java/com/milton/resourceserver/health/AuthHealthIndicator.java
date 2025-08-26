package com.milton.resourceserver.health;

import com.milton.resourceserver.gateway.AuthServerGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.ReactiveHealthIndicator;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component("auth")
@Slf4j
public class AuthHealthIndicator implements ReactiveHealthIndicator {

    private final AuthServerGateway authServerGateway;

    public AuthHealthIndicator(AuthServerGateway authServerGateway) {
        this.authServerGateway = authServerGateway;
    }

    public Mono<Health> health() {
        log.info("Running AuthHealthIndicator check");
        return authServerGateway.getHealth();
    }
}