package com.rwk.kafkaconsumer.consumer;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;
import java.util.Properties;

@Component
public class RwkKafkaConsumer {
    private final Logger logger = LoggerFactory.getLogger(RwkKafkaConsumer.class);


    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServer;

    public String onMessage(String topicName) {
        StringBuffer msg = new StringBuffer();

        // 1. KafkaConsumer에 필요한 설정
        Properties configProp = new Properties();
        configProp.setProperty("bootstrap.servers", bootstrapServer);
        // configProp.setProperty("group.id")
        configProp.setProperty("enable.auto.commit", "false");
        configProp.setProperty("key.deserializer", "org.apache.kafka.common.serialization.IntegerDeserializer");
        configProp.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        try {
            // 2. 카프카 클러스터에서 메시지를 수신(Consume) 하는 객체 생성
            Consumer<Integer, String> consumer = new KafkaConsumer<Integer, String>(configProp);

            //  3. 구독(subscribe)하는 Topic 등록
            consumer.subscribe(Collections.singletonList(topicName));

            for (int count = 0; count < 300; count++) {
                // 4. 메시지를 수신하여 콘솔에 표시
                ConsumerRecords<Integer, String> records = consumer.poll(1);
                for (ConsumerRecord<Integer, String> record : records) {
                    String msgString = String.format("key : %d, value : %s", record.key(), record.value());
                    logger.info(msgString);
                    msg.append(msgString);

                    // 5. 처리가 완료된 메시지의 오프셋을 커밋
                    TopicPartition tp = new TopicPartition(record.topic(), record.partition());
                    OffsetAndMetadata oam = new OffsetAndMetadata(record.offset() + 1);
                    Map<TopicPartition, OffsetAndMetadata> commitInfo = Collections.singletonMap(tp, oam);
                    consumer.commitSync(commitInfo);
                }
            }
            consumer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return msg.toString();
    }
}
