package com.example.firstjava.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Random;

@Configuration
public class Config {

    @Bean
    @Scope(scopeName = "singleton")
        // по умолчанию
    Random getRandom() {
        return new Random();
    }
}
