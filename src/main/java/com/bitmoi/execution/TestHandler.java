package com.bitmoi.execution;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
@RequiredArgsConstructor
public class TestHandler {
    @Autowired
    TestRepository testRepository;

    public Mono<ServerResponse> getTables(ServerRequest request){
        Flux<TestTable> testTableFlux = testRepository.findAll();
        return ok().contentType(MediaType.APPLICATION_JSON)
                .body(testTableFlux,TestTable.class)
                .log("test");
    }


}
