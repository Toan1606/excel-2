package com.eric.excel.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import static org.apache.naming.SelectorContext.prefix;

@Data
@Configuration
@ConfigurationProperties(prefix = "sort")
public class JpaConfiguration {
    private String fields;
}
