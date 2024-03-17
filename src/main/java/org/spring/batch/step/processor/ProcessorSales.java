package org.spring.batch.step.processor;

import org.spring.batch.config.SalesProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessorSales {
    @Bean
    public SalesProcessor processSales() {
        return new SalesProcessor();
    }
}
