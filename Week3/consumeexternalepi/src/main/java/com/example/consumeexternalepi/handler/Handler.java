package com.example.consumeexternalepi.handler;

import com.example.consumeexternalepi.service.ResponseService;
import com.example.consumeexternalepi.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Controller
public class Handler {

    @Autowired
    private ResponseService service;

    public Mono<ServerResponse> getRequest(ServerRequest request) {

        return ServerResponse.ok()
                .body(service.getResponse(), Response.class);
    }


}