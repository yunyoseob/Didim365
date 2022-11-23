package com.rwk.kafkaconsumer.controller;


import com.rwk.kafkaconsumer.consumer.RwkKafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
    private final Logger logger = LoggerFactory.getLogger(KafkaController.class);

    private final RwkKafkaConsumer rwkKafkaConsumer;

    public KafkaController(RwkKafkaConsumer rwkKafkaConsumer){
        this.rwkKafkaConsumer=rwkKafkaConsumer;
    }

    @GetMapping(value = "/read/message")
    public Boolean readMessage(@RequestParam String topicName){
        logger.info("KafkaController :: readMessage >>> {}",topicName);
        Boolean result=false;
        rwkKafkaConsumer.onMessage(topicName);

        return result;
    }



}
