/*
 * Copyright (c) 2022 NTT corp. All Rights Reserved.
 */

package com.nttdata.bank.account.management.ms.configuration.kafka;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * kafka configuration properties.
 *
 */

@Configuration
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ConfigurationProperties(prefix = "kafka")
public class KafkaProperties {

  private String urlKafkaServer;
  private String topicYanki;
  private String groupIdConfigKafka;
  private String offsetReset;
}
