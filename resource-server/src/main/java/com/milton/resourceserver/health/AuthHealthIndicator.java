package com.milton.resourceserver.health;

import com.milton.resourceserver.gateway.AuthServerGateway;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.ReactiveHealthIndicator;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class AuthHealthIndicator implements ReactiveHealthIndicator {

    private final AuthServerGateway authServerGateway;

    public AuthHealthIndicator(AuthServerGateway authServerGateway) {
        this.authServerGateway = authServerGateway;
    }

    public Mono<Health> health() {
        return authServerGateway.getHealth();
    }

//    @Override
//    public Mono<Health> health() {
//        // Simulate a reactive health check (e.g., pinging a service or checking a DB connection)
//        return Mono.fromSupplier(() -> {
//            boolean isHealthy = checkSomeReactiveService(); // Replace with real logic
//            if (isHealthy) {
//                return Health.up().withDetail("service", "Available").build();
//            } else {
//                return Health.down().withDetail("service", "Unavailable").build();
//            }
//        });
//    }
//
//    @Override
//    public Mono<Health> health() {
//        return checkDownstreamServiceHealth().onErrorResume(
//                ex -> Mono.just(new Health.Builder().down(ex).build())
//        );
//    }
//
//    private Mono<Health> checkDownstreamServiceHealth() {
//        // we could use WebClient to check health reactively
//        return Mono.just(new Health.Builder().up().build());
//    }
}