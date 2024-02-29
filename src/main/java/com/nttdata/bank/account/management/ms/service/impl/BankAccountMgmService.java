package com.nttdata.bank.account.management.ms.service.impl;

import com.nttdata.bank.account.management.ms.entity.BankAccount;
import com.nttdata.bank.account.management.ms.repository.BankAccountRepository;
import com.nttdata.bank.account.management.ms.service.inter.BankAccountMgmInterface;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BankAccountMgmService implements BankAccountMgmInterface {

  @Autowired
  BankAccountRepository bankAccountRepository;

  @Override
  public Mono<BankAccount> create(BankAccount request) {

    return bankAccountRepository.save(request);
  }

  @Override
  public Flux<BankAccount> listAll() {
    return bankAccountRepository.findAll();
  }

  @Override
  public Mono<BankAccount> getById(String id) {
    return bankAccountRepository.findById(id);
  }

  @Override
  public Mono<BankAccount> update(String id, BankAccount request) {
    return bankAccountRepository.findById(id)
        .flatMap(baUpdate -> {
          baUpdate.setAccountType(request.getAccountType());
          baUpdate.setCustomerId(request.getCustomerId());
          baUpdate.setAmount(request.getAmount());
          return bankAccountRepository.save(baUpdate);
        });
  }

  @Override
  public Mono<Void> delete(String id) {
    return bankAccountRepository.deleteById(id);
  }

  public Mono<BankAccount> deposits(String accountId, BigDecimal amount) {
    return bankAccountRepository.findById(accountId)
        .flatMap(ba -> {
          ba.setAmount(ba.getAmount().add(amount));
          return bankAccountRepository.save(ba);
        });
  }

  public Mono<BankAccount> withdrawCash(String accountId, BigDecimal amount) {
    return bankAccountRepository.findById(accountId)
        .flatMap(cb -> {
          if (cb.getAmount().compareTo(amount) >= 0) {
            cb.setAmount(cb.getAmount().subtract(amount));
            return bankAccountRepository.save(cb);
          } else {
            return Mono.error(new RuntimeException("Insufficient balance"));
          }
        });
  }

  public Mono<Void> transfers(String originAccountId, String destinationAccountId, BigDecimal amount) {
    return bankAccountRepository.findById(originAccountId)
        .flatMap(co -> bankAccountRepository.findById(destinationAccountId)
            .flatMap(cd -> {
              if (co.getAmount().compareTo(amount) >= 0) {
                co.setAmount(co.getAmount().subtract(amount));
                cd.setAmount(cd.getAmount().add(amount));
                return bankAccountRepository.saveAll(List.of(co, cd)).then();
              } else {
                return Mono.error(new RuntimeException("Insufficient balance"));
              }
            })
        );
  }
}
