package com.rwk.kafkaproducer.controller;

import com.rwk.kafkaproducer.producer.RwkKafkaProducer;
import com.rwk.kafkaproducer.util.KafkaUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class KafkaController {
    private final Logger logger = LoggerFactory.getLogger(KafkaController.class);

    private final KafkaUtil kafkaUtil;
    private final RwkKafkaProducer kafkaProducer;

    public KafkaController(KafkaUtil kafkaUtil, RwkKafkaProducer kafkaProducer){
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

    //@GetMapping(value="/searchAll/topic")
    //public Map<String, Object> getTopicList(){
    //    logger.info("KafkaController :: getTopicList");
    //    Map<String, Object> resultMap=new HashMap<>();
    //    return resultMap;
    //}

    @GetMapping(value="/sendMessage")
    public Boolean sendMessage(@RequestParam Map<String, String> inputParamMap){
        Boolean sendSuccess=false;
        logger.info("KafkaController :: sendMessage");
        String topic=inputParamMap.get("topicNameToMessage");
        String msg=inputParamMap.get("topicMessage");
        logger.info("topic  >>> : {}",topic);
        logger.info("msg >>> : {}", msg);

        sendSuccess=kafkaProducer.messageSend(topic, msg);
        return sendSuccess;
    }
}
