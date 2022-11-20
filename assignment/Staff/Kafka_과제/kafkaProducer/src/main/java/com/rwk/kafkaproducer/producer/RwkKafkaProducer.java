package com.rwk.kafkaproducer.producer;

import com.rwk.kafkaproducer.util.KafkaUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RwkKafkaProducer {
    private KafkaUtil kafkaUtil = null;

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServer;

    public RwkKafkaProducer(KafkaUtil kafkaUtil) {
        this.kafkaUtil = kafkaUtil;
    }

    private final Logger logger = LoggerFactory.getLogger(RwkKafkaProducer.class);

    public void messageSend(String topic, String msg) {
        logger.info("KafkaProducer :: messageSend >>> : topic : {},  msg : {}", topic, msg);
        try {
            kafkaUtil.getKafkaTemplate().send(topic, msg);
            kafkaUtil.getKafkaTemplate().flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
