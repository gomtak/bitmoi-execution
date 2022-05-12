package com.bitmoi.execution.service;

import com.bitmoi.execution.domain.Order;
import reactor.core.publisher.Mono;

public interface OrderService {

    //받은 오더 주문 체결하기.
    Mono<Integer> executeOrder(Order order);

}
