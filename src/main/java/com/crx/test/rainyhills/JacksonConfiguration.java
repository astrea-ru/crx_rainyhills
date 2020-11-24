package com.crx.test.rainyhills;

import com.fasterxml.jackson.databind.DeserializationFeature;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfiguration {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer addCustomBigDecimalDeserialization() {
        return builder -> {
            builder.featuresToEnable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            builder.featuresToDisable(DeserializationFeature.ACCEPT_FLOAT_AS_INT);
        };
    }
}