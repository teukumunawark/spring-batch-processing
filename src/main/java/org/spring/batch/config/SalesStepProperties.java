package org.spring.batch.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

@ConfigurationProperties("spring.batch")
public record SalesStepProperties(
        @DefaultValue(",")
        String delimiter
) {
}
