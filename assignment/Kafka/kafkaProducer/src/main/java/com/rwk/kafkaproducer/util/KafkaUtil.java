package com.rwk.kafkaproducer.util;


import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.config.TopicConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Component
public class KafkaUtil {
    private static final Logger logger = LoggerFactory.getLogger(KafkaUtil.class);

    KafkaTemplate<String, String> kafkaTemplate = null;
    AdminClient adminClient = null;

    private AdminClient getAdminClient() {
        if (adminClient == null) {
            Properties properties = new Properties();
            // properties.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
            properties.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.112.130:9092");
            adminClient = AdminClient.create(properties);
        }

        if (kafkaTemplate == null) {
            HashMap<String, Object> configProps = new HashMap<String, Object>();
            configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.112.130:9092");
            configProps.put(ProducerConfig.MAX_BLOCK_MS_CONFIG, 30000);
            configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
            configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

            ProducerFactory<String, String> factory = new DefaultKafkaProducerFactory<>(configProps);

            kafkaTemplate = new KafkaTemplate<>(factory);
        }

        return adminClient;
    }

    public KafkaTemplate getKafkaTemplate() {
        if (kafkaTemplate == null) {
            HashMap<String, Object> configProps = new HashMap<>();
            logger.info("KafkaUtil :: getKafkaTemplate() :: bootstrapServer >>> : {}", "192.168.112.130:9092");
            configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.112.130:9092");
            configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
            configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
            ProducerFactory<String, String> factory = new DefaultKafkaProducerFactory<>(configProps);
            kafkaTemplate = new KafkaTemplate<>(factory);
        }
        return kafkaTemplate;
    }

    public Boolean createTopicConfig(String topicName, Integer partitionNum, Short replicationNum, String retentionMs) {
        Map<String, String> newTopicConfig = new HashMap<>();
        newTopicConfig.put(TopicConfig.RETENTION_MS_CONFIG, retentionMs);
        try {
            final NewTopic newTopic = new NewTopic(topicName, partitionNum, replicationNum).configs(newTopicConfig);
            final CreateTopicsResult createTopicsResult = getAdminClient().createTopics(Collections.singleton(newTopic));
            createTopicsResult.all().get();
            return true;
        } catch (Exception e) {
            logger.info("KafkaUtil :: createTopicConfig error >>> : {}", e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public Boolean createTopic(String topicName, Integer partitionNum, Short replicationNum) {
        logger.info("KafkaUtil :: createTopic");
        logger.info("topicName : {}, partitionNnum : {}, replicationNum : {}", topicName, partitionNum, replicationNum);
        try {
            final NewTopic newTopic = new NewTopic(topicName, partitionNum, replicationNum);
            final CreateTopicsResult createTopicsResult = getAdminClient().createTopics(Collections.singleton(newTopic));
            createTopicsResult.all().get();
            logger.info("=> createTopic Result = " + createTopicsResult.values());
            return true;
        } catch (Exception e) {
            logger.info("KafkaUtil :: createTopic error >>> : {}", e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public void messageSend(String topic, String msg) {
        logger.info("KafkaUtil :: messageSend :: topic : {}, msg : {}", topic, msg);
        try {
            // this.getKafkaTemplate().send(topic, msg);
            // this.kafkaTemplate.flush();
            Properties props = new Properties();
            props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.112.130:9092");
            props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
            props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class.getName());

            KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
            ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, msg);

            producer.send(record);
            producer.flush();
            producer.close();
        } catch (Exception e) {
            logger.info("KafkaUtil :: messageSend :: error >>> : {}", e.getMessage());
            e.printStackTrace();
        }
    }
}
