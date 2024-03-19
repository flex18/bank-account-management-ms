package com.nttdata.bank.account.management.ms.repository;

import com.nttdata.bank.account.management.ms.entity.BankAccount;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BankAccountRepository extends ReactiveMongoRepository<BankAccount, String> {
  Mono<BankAccount> findByCellPhoneNumber(String cellPhoneNumber);
}
