package com.nttdata.bank.account.management.ms.service.inter;

import com.nttdata.bank.account.management.ms.entity.BankAccount;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BankAccountMgmInterface {

  Mono<BankAccount> create(BankAccount request);
  Flux<BankAccount> listAll();
  Mono<BankAccount> getById(String id);
  Mono<BankAccount> update(String id, BankAccount request);
  Mono<Void> delete(String id);


}
