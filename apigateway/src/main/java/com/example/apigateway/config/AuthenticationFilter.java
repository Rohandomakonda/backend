package com.example.apigateway.config;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {
    private final WebClient.Builder webClientBuilder;
    private final JwtUtil jwtUtil;

    public AuthenticationFilter(WebClient.Builder webClientBuilder, JwtUtil jwtUtil) {
        super(Config.class);
        System.out.println("hi");
        this.webClientBuilder = webClientBuilder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                throw new RuntimeException("Missing authorization header");
            }

            String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);

            return webClientBuilder.build()
                    .post()
                    .uri("lb://auth-service/api/auth/validate")
                    .header(HttpHeaders.AUTHORIZATION, authHeader)
                    .retrieve()
                    .bodyToMono(Boolean.class)
                    .flatMap(isValid -> {
                        if (isValid) {
                            System.out.println("validated");
                            // Extract userId and add it to headers
                            String userId = jwtUtil.extractUserId(authHeader);
                            ServerHttpRequest modifiedRequest = exchange.getRequest()
                                    .mutate()
                                    .build();

                            return chain.filter(exchange.mutate().request(modifiedRequest).build());
                        } else {
                            throw new RuntimeException("Invalid token");
                        }
                    });
        };
    }

    public static class Config {
    }
}
