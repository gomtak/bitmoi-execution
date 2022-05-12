package com.bitmoi.execution.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer{
    private final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "order-bid", groupId = "bitmoi")
    public void consumeBid(String message) {
        logger.info(String.format("Consumed Bid message -> %s", message));
    }

    @KafkaListener(topics = "order-ask", groupId = "bitmoi")
    public void consumeAsk(String message) {
        logger.info(String.format("Consumed Ask message -> %s", message));
    }


}