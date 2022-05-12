package com.bitmoi.execution.kafka;

import com.bitmoi.execution.domain.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);
    private static final String TOPIC_BID = "order-bid";
    private static final String TOPIC_ASK = "order-ask";

    @Autowired
    private KafkaTemplate<String, String> topicBid;

    @Autowired
    private KafkaTemplate<String, Object> topicAsk;

    public void saveBidMessage(Order order){
        logger.info(String.format("saveBidMessage created -> %s", order));
        this.topicAsk.send(TOPIC_BID,order);
    }


    public void sendAskMessage(String message) {
        logger.info(String.format("Producing Ask message -> %s", message));
        this.topicBid.send(TOPIC_ASK, message);
    }

//    @Autowired
//    public KafkaProducer(KafkaTemplate<String, Order> kafkaTemplate1) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
}
