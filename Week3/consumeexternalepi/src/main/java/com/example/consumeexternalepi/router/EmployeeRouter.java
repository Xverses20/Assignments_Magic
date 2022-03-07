package com.example.consumeexternalepi.router;

import com.example.consumeexternalepi.handler.Handler;
import com.example.consumeexternalepi.service.ResponseService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import static org.springdoc.webflux.core.fn.SpringdocRouteBuilder.route;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@EnableWebFlux
@Configuration
public class EmployeeRouter implements WebFluxConfigurer {

    @Bean
    public RouterFunction<ServerResponse> employeeRoutes(Handler handler) {


        return route().GET("/employee/get",
                accept(MediaType.APPLICATION_JSON),
                handler::getRequest,
                ops -> ops.beanClass(ResponseService.class).beanMethod("getResponse")
        ).build();
        //  .route(RequestPredicates.GET("/hello").and(accept(MediaType.APPLICATION_JSON)), studentHandler::getRequest);
    }

}
