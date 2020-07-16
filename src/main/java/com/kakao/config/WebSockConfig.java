package com.kakao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSockConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
    	//메시지 발행(보내기)요청  : /pub
    	//메시지 구독(받기)요청  : /sub
    	System.out.println("configureMessageBroker");
    	
    	config.enableSimpleBroker("/sub", "/queue");
        config.setApplicationDestinationPrefixes("/pub");
    }
   
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
    	//stomp websocket의 연결 endpoint는 /ws-stomp로 설정 
    	//ws://localhost:8080/ws-stomp가 개발서버의 접속 주소
    	System.out.println("registerStompEndpoints");
   	
    	registry.addEndpoint("/ws-stomp").setAllowedOrigins("*")
                .withSockJS();
    }
}