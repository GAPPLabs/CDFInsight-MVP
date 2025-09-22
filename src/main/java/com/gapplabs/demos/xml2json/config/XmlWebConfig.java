package com.gapplabs.demos.xml2json.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration

@EnableConfigurationProperties(XmlProperties.class)
public class XmlWebConfig implements WebMvcConfigurer {
    
    private XmlProperties props;
    
    public XmlWebConfig(XmlProperties props) {
        this.props = props;
    }
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }
//    https://cryptosys.net/firmasat/cfdv40-pagos20-min.xml.html
}
