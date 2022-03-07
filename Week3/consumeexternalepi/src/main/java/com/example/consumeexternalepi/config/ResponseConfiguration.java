package com.example.consumeexternalepi.config;


import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class ResponseConfiguration {
    @Bean
    public GroupedOpenApi groupedOpenApi(){
        String[] paths=new String[]{"v1/employees/**"};
        return GroupedOpenApi.builder().group("Response").pathsToMatch(paths).build();
    }


}
