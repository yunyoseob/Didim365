package com.rwk.kafkaconsumer.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Properties;

@Configuration
public class RwkKafkaConsumer {
    private final Logger logger = LoggerFactory.getLogger(RwkKafkaConsumer.class);


    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServer;

    public String onMessage(String topicName) {
        logger.info("RwkKafkaConsumer :: onMessage :: topicName >>> : {}", topicName);
        StringBuffer msg = new StringBuffer();
        // 1. KafkaConsumer에 필요한 설정
        Properties configProp = new Properties();
        configProp.setProperty("bootstrap.servers", bootstrapServer);
        configProp.setProperty("group.id", "testTopicGroup");
        configProp.setProperty("enable.auto.commit", "false");
        configProp.setProperty("auto.offset.reset", "earliest");
        configProp.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        configProp.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(configProp);
        consumer.subscribe(Arrays.asList(topicName));

        try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(1000);
                for (ConsumerRecord<String, String> record : records) {
                    System.out.printf("Topic : %s, Partition : %s, Offset : %d, Key : %s, Value : %s \n", record.topic(), record.partition(), record.offset(), record.key(), record.value());
                    msg.append(record);
                }
                System.out.println(msg);
                consumer.commitSync();
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
