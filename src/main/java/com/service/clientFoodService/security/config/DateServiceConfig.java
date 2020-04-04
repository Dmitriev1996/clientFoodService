package com.service.clientFoodService.security.config;

import com.service.clientFoodService.security.DateService;
import com.service.clientFoodService.security.JodaDateService;
import org.joda.time.DateTimeZone;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Admin on 05.05.2019.
 */
@Configuration
public class DateServiceConfig {

    @Bean
    DateService dateService() {
       return new JodaDateService(defaultTimeZone());
    }

    @Bean
    DateTimeZone defaultTimeZone() {
        return DateTimeZone.UTC;
    }
}
