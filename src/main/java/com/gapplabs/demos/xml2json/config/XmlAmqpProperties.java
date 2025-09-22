package com.gapplabs.demos.xml2json.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "xml.amqp")
public class XmlAmqpProperties {
    
    private String queue;
}
