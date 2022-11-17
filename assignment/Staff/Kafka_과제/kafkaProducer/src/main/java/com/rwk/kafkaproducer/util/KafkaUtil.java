package com.rwk.kafkaproducer.util;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.config.TopicConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Component
public class KafkaUtil {
    private static final Logger logger = LoggerFactory.getLogger(KafkaUtil.class);

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServer;

    KafkaTemplate<String, String> kafkaTemplate = null;
    AdminClient adminClient = null;

    private AdminClient getAdminClient() {
        if (adminClient == null) {
            Properties properties = new Properties();
            properties.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
            adminClient = AdminClient.create(properties);
        }
        return adminClient;
    }

    public KafkaTemplate getKafkaTemplate() {
        if (kafkaTemplate == null) {
            HashMap<String, Object> configProps = new HashMap<>();

            configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
            configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
            configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

            ProducerFactory<String, String> factory = new DefaultKafkaProducerFactory<>(configProps);

            kafkaTemplate = new KafkaTemplate<>(factory);
        }
        return kafkaTemplate;
    }

    public Boolean createTopic(String topicName, Integer partitionNum, Short replicationNum, String retentionMs) {
        logger.info("KafkaUtil :: createTopic");
        logger.info("topicName : {}, partitionNnum : {}, replicationNum : {}, retentionMs : {}", topicName, partitionNum, replicationNum, retentionMs);
        Boolean createTopic = false;

        Map<String, String> nweTopicConfig = new HashMap<>();
        nweTopicConfig.put(TopicConfig.RETENTION_MS_CONFIG, retentionMs);
        try {
            final NewTopic newTopic = new NewTopic(topicName, partitionNum, replicationNum).configs(nweTopicConfig);
            final CreateTopicsResult createTopicsResult = getAdminClient().createTopics(Collections.singleton(newTopic));
            createTopicsResult.all().get();
            createTopic = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return createTopic;
    }

}
