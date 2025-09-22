package com.gapplabs.demos.xml2json.messaging;

import com.gapplabs.demos.xml2json.config.XmlProperties;
import com.gapplabs.demos.xml2json.event.XmlEventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@EnableConfigurationProperties(XmlProperties.class)
@Component
public class XmlConsumer {
    private static final Logger log = LoggerFactory.getLogger(XmlConsumer.class);

    private XmlEventHandler xmlEventHandler;
    
    private XmlProperties xmlProperties;
    
    public XmlConsumer(XmlEventHandler xmlEventHandler, XmlProperties xmlProperties) {
        this.xmlEventHandler = xmlEventHandler;
        this.xmlProperties = xmlProperties;
    }
    
    @RabbitListener(queues = "${xml.amqp.queue}" )
    public void processToDo(String message) throws InterruptedException {
        log.info("Escuchando el mensaje");
        message = message.toUpperCase();
        Thread.sleep(5000);
        this.xmlEventHandler.handleToDoSave(this.xmlProperties.getBroker() + this.xmlProperties.getTopic(), message);
        log.info("Consumer> " + this.xmlProperties.getBroker() + this.xmlProperties.getTopic());
    }
}
