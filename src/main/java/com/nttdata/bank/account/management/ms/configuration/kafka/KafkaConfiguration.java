package com.nttdata.bank.account.management.ms.configuration.kafka;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

/**
 * Configuration class to connect to kafka. Consumer.
 */

@EnableKafka
@Configuration
public class KafkaConfiguration {

  @Autowired
  KafkaProperties kafkaProperties;

  @Bean
  public ConsumerFactory<String, String> consumerPayment() {
    Map<String, Object> props = new HashMap<>();
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getUrlKafkaServer());
    props.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaProperties.getGroupIdConfigKafka());
    props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, kafkaProperties.getOffsetReset());
    return new DefaultKafkaConsumerFactory<>(props,
        new StringDeserializer(), new StringDeserializer());
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
    ConcurrentKafkaListenerContainerFactory<String, String> factoryListener =
        new ConcurrentKafkaListenerContainerFactory<>();
    factoryListener.setConsumerFactory(consumerPayment());
    return factoryListener;
  }

}
