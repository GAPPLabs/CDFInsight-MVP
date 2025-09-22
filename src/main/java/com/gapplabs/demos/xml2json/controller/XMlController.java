package com.gapplabs.demos.xml2json.controller;

import com.gapplabs.demos.xml2json.config.XmlAmqpProperties;
import com.gapplabs.demos.xml2json.messaging.XmlProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.logging.LogFileWebEndpoint;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@EnableConfigurationProperties(XmlAmqpProperties.class)
@Controller
//@RequestMapping("/api")
public class XMlController {

    private XmlProducer xmlProducer;
    private XmlAmqpProperties xmlAmqpProperties;
    
    public XMlController(XmlProducer xmlProducer, XmlAmqpProperties xmlAmqpProperties) {
        this.xmlProducer = xmlProducer;
        this.xmlAmqpProperties = xmlAmqpProperties;
    }
    
    private Logger logger = LoggerFactory.getLogger(XMlController.class);
    
    @GetMapping("/health")
    public ResponseEntity<String> getAll() {
        return ResponseEntity.ok("HEALTH CHECK!");
    }
    
    @MessageMapping("/sendMessage") // Endpoint matching the JavaScript destination
    @SendTo("/todo/convertedXml") // Broadcast to subscribers of this topic
    public String sendMessage(String message, SimpMessageHeaderAccessor headerAccessor) {
        logger.info("Message received in sendMessage endpoint");
        this.xmlProducer.sendTo(this.xmlAmqpProperties.getQueue(), message);
        logger.info("Message sent in sendMessage endpoint");
        return message; // Broadcast the message
    }
}
