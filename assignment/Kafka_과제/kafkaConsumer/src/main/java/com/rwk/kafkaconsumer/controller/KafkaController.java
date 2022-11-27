package com.rwk.kafkaconsumer.controller;


import com.rwk.kafkaconsumer.consumer.RwkKafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class KafkaController {
    private final Logger logger = LoggerFactory.getLogger(KafkaController.class);

    private final RwkKafkaConsumer rwkKafkaConsumer;

    public KafkaController(RwkKafkaConsumer rwkKafkaConsumer){
        this.rwkKafkaConsumer=rwkKafkaConsumer;
    }

    @PostMapping(value = "/read/message")
    public Map<String, Object> readMessage(){
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("result",rwkKafkaConsumer.onMessage());

        return resultMap;
    }
}
