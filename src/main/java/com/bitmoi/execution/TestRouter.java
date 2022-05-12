package com.bitmoi.execution;

import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Component
public class TestRouter {

    @Bean
    public RouterFunction<ServerResponse> index(TestHandler testHandler){
        return RouterFunctions
                .route(GET("/tests").and(accept(MediaType.APPLICATION_JSON)), testHandler::getTables);

    }
}
