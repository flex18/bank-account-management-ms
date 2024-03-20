package com.nttdata.bank.account.management.ms.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nttdata.bank.account.management.ms.entity.yanki.PaymentMadeEvent;
import com.nttdata.bank.account.management.ms.service.inter.ConsumerInterface;
import com.nttdata.bank.account.management.ms.service.inter.ProcessingMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class ConsumerService implements ConsumerInterface {

  @Autowired
  ProcessingMessage processingMessage;

  ObjectMapper json = new ObjectMapper();

  @Override
  @KafkaListener(id = "${kafka.groupIdConfigKafka}", topics = "${kafka.topicYanki}",
      autoStartup = "true")
  public Void listenEvents(String message) throws JsonProcessingException {
    log.info("*** The message received from kafka is: " + message);
      PaymentMadeEvent paymentMade = json.readValue(message, PaymentMadeEvent.class);
       return processingMessage.processing(paymentMade);
  }
}
