package com.hana.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@EnableWebSocketMessageBroker
@Configuration
public class StomWebSocketConfig implements WebSocketMessageBrokerConfigurer{

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry.addEndpoint("/ws").setAllowedOrigins("http://127.0.0.1").withSockJS();
        registry.addEndpoint("/ws").setAllowedOrigins("http://172.16.21.91").withSockJS();
//        registry.addEndpoint("/ws").setAllowedOriginPatterns("*").withSockJS();
        registry.addEndpoint("/wss").setAllowedOrigins("http://172.16.21.91").withSockJS();

        //        registry.addEndpoint("/ws").setAllowedOrigins("http://172.16.20.222").withSockJS();
//        registry.addEndpoint("/ws").setAllowedOrigins("http://172.16.21.49").withSockJS();
//        registry.addEndpoint("/ws").setAllowedOrigins("*").withSockJS();


//        registry.addEndpoint("/chbot").setAllowedOrigins("http://127.0.0.1").withSockJS();
//        registry.addEndpoint("/wss").setAllowedOrigins("http://127.0.0.1").withSockJS();
    }

    /* 어플리케이션 내부에서 사용할 path를 지정할 수 있음 */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/send","/send2");
    }
}