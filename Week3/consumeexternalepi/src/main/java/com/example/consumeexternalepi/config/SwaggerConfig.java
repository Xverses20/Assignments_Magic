package com.example.consumeexternalepi.config;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


    @Configuration
    public class SwaggerConfig  {
        @Bean
        public GroupedOpenApi swaggercall(){
            String[] paths = new String[]{"/employee/**"};
            return GroupedOpenApi.builder().group("Sample").pathsToMatch(paths).build();
        }

