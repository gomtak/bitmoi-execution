package com.bitmoi.execution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class TestHandler {
    @Autowired
    TestRepository testRepository;

    public Mono<ServerResponse> getTables(ServerRequest request){
        return testRepository.findAll().collectList()
                .flatMap(testTables -> ServerResponse
                        .ok().body(testTables,TestTable.class))
                        .onErrorResume(error -> ServerResponse.badRequest().build());

    }
}
