package com.example.watchparty.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic"); // outgoing
        config.setApplicationDestinationPrefixes("/app"); // incoming
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws") // this maps to ws://<host>:<port>/ws
                .setAllowedOriginPatterns("*"); // for native WebSocket

        // Optional: if you want to support SockJS as fallback (like in HTML test client)
        registry.addEndpoint("/ws")
                .setAllowedOriginPatterns("*")
                .withSockJS(); // maps to ws://<host>:<port>/ws/websocket via SockJS
    }
}
