package com.nttdata.bank.account.management.ms.service.inter;

import com.nttdata.bank.account.management.ms.entity.BankAccount;
import com.nttdata.bank.account.management.ms.entity.yanki.PaymentMadeEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProcessingMessage {
  Mono<BankAccount> processing(PaymentMadeEvent request);
}
