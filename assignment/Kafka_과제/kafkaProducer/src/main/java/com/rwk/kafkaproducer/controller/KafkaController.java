package com.rwk.kafkaproducer.controller;

import com.rwk.kafkaproducer.util.KafkaUtil;
import com.rwk.kafkaproducer.util.RestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class KafkaController {
    private final Logger logger = LoggerFactory.getLogger(KafkaController.class);

    private final KafkaUtil kafkaUtil;
    private final RestUtil restUtil;

    public KafkaController(KafkaUtil kafkaUtil, RestUtil restUtil) {
        this.kafkaUtil = kafkaUtil;
        this.restUtil = restUtil;
    }

    @PostMapping(value = "/create/topic")
    public Boolean createTopic(@RequestParam Map<String, String> inputParamMap) {
        logger.info("KafkaController :: createTopic");
        logger.info("inputParamMap >>> : {}", inputParamMap.toString());
        logger.info("/kafka/create/topic inputParamMap {}", inputParamMap);
        Boolean result = false;
        String topicName = inputParamMap.get("topicName");
        Integer partitionNum = Integer.valueOf(inputParamMap.get("partitionNum"));
        // Short replicationNum = Short.valueOf(inputParamMap.get("replicationNum"));
        // String retentionMs = inputParamMap.get("retentionMs");
        Short replicationNum = 1;

        result = kafkaUtil.createTopic(topicName, partitionNum, replicationNum);
        try {
            result = true;
        } catch (Exception e) {
            logger.info("KafkaController :: createTopic error >>> : {}", e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @PostMapping(value = "/sendMessage")
    public Boolean sendMessage(@RequestParam Map<String, String> inputParamMap) {
        Boolean sendSuccess = false;
        logger.info("KafkaController :: sendMessage");
        String topic = inputParamMap.get("topicNameToMessage");
        String msg = inputParamMap.get("topicMessage");
        logger.info("topic  >>> : {}", topic);
        logger.info("msg >>> : {}", msg);

        kafkaUtil.messageSend(topic, msg);
        return sendSuccess;
    }

    @PostMapping(value = "/read/messageResult")
    public Map<String, Object> readMessageResult(@RequestParam Map<String, String> inputParamMap) {
        Map<String, Object> resultMap = new HashMap<>();
        logger.info("KafkaController :: readMessageResult >>> : {}", inputParamMap);

        try {
            resultMap = (Map<String, Object>) restUtil.post("http://192.168.219.104:8089/read/message", inputParamMap, Object.class);
            // http://192.168.219.104:8089/
        } catch (Exception e) {
            logger.info("error >>> : {}", e.getMessage());
            e.printStackTrace();
        }
        return resultMap;
    }
}
