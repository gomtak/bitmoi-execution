package com.bitmoi.execution.repository;

import com.bitmoi.execution.TestRepository;
import com.bitmoi.execution.TestTable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;

import java.util.List;

@SpringBootTest
class TestRepositoryTest {

    @Autowired
    TestRepository testRepository;
    @Test
    void 테이블저장(){
        Mono<TestTable> test = testRepository.save(new TestTable(1,"Test"));
    }
    @Test
    void 테이블테스트(){
        Mono<List<TestTable>> testTableList = testRepository.findAll().collectList();
    }
}