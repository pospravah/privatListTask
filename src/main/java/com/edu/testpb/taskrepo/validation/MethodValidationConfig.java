package com.edu.testpb.taskrepo.validation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@Configuration
@ComponentScan({ "com.edu.testpb.taskrepo" })
public class MethodValidationConfig {

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        System.out.println("----- MethodValidationConfig -----" );
        return new MethodValidationPostProcessor();
    }

}