package com.rwk.kafkaconsumer;

import com.rwk.kafkaconsumer.controller.KafkaController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaConsumerApplication implements ApplicationRunner {
    private final Logger logger = LoggerFactory.getLogger(KafkaConsumerApplication.class);

    private final KafkaController kafkaController;

    public KafkaConsumerApplication(KafkaController kafkaController) {
        this.kafkaController = kafkaController;
    }

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(KafkaConsumerApplication.class);
        springApplication.run(args);
    }

    @Override
    public void run(ApplicationArguments args) {
        String topicName = "kafkaTopic";
        logger.info("KafkaConsumerApplication :: run :: testTopic >>> {}", topicName);
        kafkaController.readMessage(topicName);
    }

    //  public static void main(String[] args) {
    //        SpringApplication.run(KafkaConsumerApplication.class, args);
    //    }
}
