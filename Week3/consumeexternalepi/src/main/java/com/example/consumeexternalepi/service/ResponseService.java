package com.example.consumeexternalepi.service;

import com.example.consumeexternalepi.model.Response;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ResponseService {

    public Mono<Response> getResponse(){
        WebClient webClient;
        webClient = WebClient.builder().baseUrl("http://dummy.restapiexample.com/api/v1").build();
        return webClient.get().uri("/employee/1").retrieve()
                .bodyToMono(Response.class);
    }
}
