package com.gapplabs.demos.xml2json.messaging;

import com.gapplabs.demos.xml2json.config.XmlProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

//@EnableConfigurationProperties(XmlProperties.class)
@Component
public class XmlProducer {
    private static final Logger log = LoggerFactory.getLogger(XmlProducer.class);
    
    private RabbitTemplate template;
    
    public XmlProducer(RabbitTemplate template) {
        this.template = template;
    }
    
    public void sendTo(String queue, String xmlContent){
        this.template.convertAndSend(queue, xmlContent);
        log.info("Producer> Message Sent");
    }
}
