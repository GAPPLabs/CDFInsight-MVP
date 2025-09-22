package com.gapplabs.demos.xml2json.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "xml.ws")
public class XmlProperties {
    private String app = "/todo-api-ws";
    private String broker = "/todo";
    private String topic;
    private String endpoint = "/stomp";
}