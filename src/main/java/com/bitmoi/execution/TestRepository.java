package com.bitmoi.execution;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface TestRepository extends ReactiveCrudRepository<TestTable, Integer> {

}
