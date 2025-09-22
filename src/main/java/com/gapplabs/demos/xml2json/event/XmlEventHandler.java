package com.gapplabs.demos.xml2json.event;

import com.gapplabs.demos.xml2json.config.XmlProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@EnableConfigurationProperties({XmlProperties.class})
@Component
public class XmlEventHandler {
    private Logger log = LoggerFactory.getLogger(XmlEventHandler.class);
    private SimpMessagingTemplate messagingTemplate;
    private XmlProperties xmlProperties;
    
    
    public XmlEventHandler(SimpMessagingTemplate simpMessagingTemplate, XmlProperties xmlProperties) {
        this.messagingTemplate = simpMessagingTemplate;
        this.xmlProperties = xmlProperties;
    
    }
    
    
    public void handleToDoSave(String destination, String parsedXMlContent) {

        this.messagingTemplate.convertAndSend(destination, parsedXMlContent);
        log.info(">> Sending Message to WS: ws:/" + destination + "cadena");
    }
}
