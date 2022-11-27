package com.rwk.kafkaconsumer.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Properties;

@Component
public class RwkKafkaConsumer {
    private final Logger logger = LoggerFactory.getLogger(RwkKafkaConsumer.class);


    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServer;

    @Value("${spring.kafka.template.default-topic}")
    private String topicName;

    @Value("${spring.kafka.consumer.group-id}")
    private String groupId;

    @Value("${spring.kafka.consumer.auto-offset-reset}")
    private String autoOffsetResest;


 //   @KafkaListener(topics = "testTopic")
    public String onMessage() {
        logger.info("RwkKafkaConsumer :: onMessage :: topicName >>> : {}", topicName);
        StringBuffer msg = new StringBuffer();
        // 1. KafkaConsumer에 필요한 설정
        Properties configProp = new Properties();
        configProp.setProperty("bootstrap.servers", bootstrapServer);
        configProp.setProperty("group.id", groupId);
        configProp.setProperty("enable.auto.commit", "true");
        configProp.setProperty("auto.offset.reset", autoOffsetResest);
        configProp.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        configProp.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(configProp);
        consumer.subscribe(Arrays.asList(topicName));

        try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(1000);
                for (ConsumerRecord<String, String> record : records) {
                    logger.info("Topic : {}, Partition : {}, Offset : {}, Key : {}, Value : {}", record.topic(), record.partition(), record.offset(), record.key(), record.value());
                    msg.append(record.toString());
                }
            }
        } catch (Exception e) {
            logger.info("RwkKafkaConsumer ::  onMessage :: error >>> : {}", e.getMessage());
            e.printStackTrace();
        } finally {
            consumer.close();
        }

        return msg.toString();
    }
}
