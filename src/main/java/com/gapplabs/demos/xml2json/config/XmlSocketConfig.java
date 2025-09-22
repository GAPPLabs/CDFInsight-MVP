package com.gapplabs.demos.xml2json.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


@Configuration
@EnableWebSocketMessageBroker
public class XmlSocketConfig implements WebSocketMessageBrokerConfigurer {
    
    private XmlProperties props;
    
    public XmlSocketConfig(XmlProperties props) {
        this.props = props;
    }
    
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // The setAllowedOrigins method no longer accepts wildcards as arguments due to security risks
        registry.addEndpoint(this.props.getEndpoint()).setAllowedOriginPatterns("*").withSockJS();
    }
    
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker(this.props.getBroker());
        
        config.setApplicationDestinationPrefixes(this.props.getApp());
    }
//    https://cryptosys.net/firmasat/cfdv40-pagos20-min.xml.html
}