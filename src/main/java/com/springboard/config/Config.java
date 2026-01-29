package com.springboard.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public ModelMapper getMapper() {return new ModelMapper();}

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
