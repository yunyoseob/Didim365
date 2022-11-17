package com.rwk.kafkaproducer.controller;

import com.rwk.kafkaproducer.producer.KafkaProducer;
import com.rwk.kafkaproducer.util.KafkaUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class KafkaController {
    private final Logger logger = LoggerFactory.getLogger(KafkaController.class);

    private final KafkaUtil kafkaUtil;
    private final KafkaProducer kafkaProducer;

    public KafkaController(KafkaUtil kafkaUtil, KafkaProducer kafkaProducer){
        this.kafkaUtil=kafkaUtil;
        this.kafkaProducer=kafkaProducer;
    }

    @GetMapping(value = "/create/topic")
    public Boolean createTopic(@RequestParam Map<String, String> inputParamMap) {
        logger.info("KafkaController :: createTopic");
        logger.info("inputParamMap >>> : {}",inputParamMap.toString());
        logger.info("/kafka/create/topic inputParamMap {}", inputParamMap);
        Boolean result = false;
        String topicName=inputParamMap.get("topicName");
        Integer partitionNum=Integer.valueOf(inputParamMap.get("partitionNum"));
        Short replicationNum=Short.valueOf(inputParamMap.get("replicationNum"));
        String retentionMs=inputParamMap.get("retentionMs");
        result=kafkaUtil.createTopic(topicName, partitionNum, replicationNum, retentionMs);

        if(!result){
            logger.info("토픽 생성 실패");
        }

        return result;
    }

    @GetMapping(value="/searchAll/topic")
    public Map<String, Object> getTopicList(){
        logger.info("KafkaController :: getTopicList");
        Map<String, Object> resultMap=new HashMap<>();

        return resultMap;
    }

    @PostMapping(value="/sendMessage")
    public Boolean sendMessage(String msg){
        logger.info("KafkaController :: sendMessage");
        logger.info("message >>> : {}",msg);
        Boolean sendSuccess=false;

        return sendSuccess;
    }
}
