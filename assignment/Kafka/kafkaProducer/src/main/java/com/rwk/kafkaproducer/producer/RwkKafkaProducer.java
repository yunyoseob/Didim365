package com.rwk.kafkaproducer.producer;

import com.rwk.kafkaproducer.util.KafkaUtil;
import org.apache.kafka.clients.producer.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class RwkKafkaProducer {

    private final Logger logger = LoggerFactory.getLogger(RwkKafkaProducer.class);
    private KafkaUtil kafkaUtil = null;

    // @Value("${spring.kafka.bootstrap-servers}")
    // private String bootstrapServer;

    public RwkKafkaProducer(KafkaUtil kafkaUtil) {
        this.kafkaUtil = kafkaUtil;
    }

    public Boolean messageSend(String topicName, String msg) {
        Boolean sendResult = false;
        // KafkaProduceer에 필요한 설정
        Properties configProp = new Properties();
        configProp.setProperty("bootstrap.servers", "192.168.112.130:9092");
        configProp.setProperty("key.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
        configProp.setProperty("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        // 카프카 클러스터에 메시지를 송신(produce)하는 객체 생성
        Producer<Integer, String> producer = new KafkaProducer<Integer, String>(configProp);

        int key;
        String value;

        for (int i = 1; i <= 100; i++) {
            key = i;
            value = msg;

            // 송신 메시지 작성
            ProducerRecord<Integer, String> record = new ProducerRecord<>(topicName, key, value);

            // 메시지를 송신하고 Ack를 받았을 때 실행할 작업(Callback) 등록
            producer.send(record, new Callback() {
                Boolean chkBool = false;

                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    if (recordMetadata != null) {
                        logger.info("send message success");
                        String infoString = String.format("Success partition: %d, offset: %d", recordMetadata.partition(), recordMetadata.offset());
                        logger.info(infoString);
                        chkBool = true;
                    } else {
                        String infoString = String.format("Failed : %s", e.getMessage());
                        logger.error(infoString);
                    }
                }
            });
        }
        // KafkaProducer를 닫고 종료
        producer.close();
        sendResult = true;
        return sendResult;
    }
}
