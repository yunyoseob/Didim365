package com.rwk.kafkaproducer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class KafkaController {
    private final Logger logger = LoggerFactory.getLogger(KafkaController.class);

    @GetMapping(value = "/create/topic")
    public String createTopic(@RequestParam Map<String, String> inputParamMap) {
        String result = "fail";
        logger.info("/kafka/create/topic inputParamMap {}", inputParamMap);

        result = "success";
        return result;
    }
}
