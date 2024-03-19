package com.nttdata.bank.account.management.ms.service.inter;

import com.fasterxml.jackson.core.JsonProcessingException;
import reactor.core.publisher.Mono;

public interface ConsumerInterface {

  void listenEvents(String message) throws JsonProcessingException;
}
