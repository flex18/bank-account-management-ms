package com.nttdata.bank.account.management.ms.controller;

import com.nttdata.bank.account.management.ms.entity.BankAccount;
import com.nttdata.bank.account.management.ms.service.impl.BankAccountMgmService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/bank-account")
public class BankAccountMgmController {

  @Autowired
  BankAccountMgmService bankAccountMgmService;

  @GetMapping
  public Flux<BankAccount> getListBankAccounts() {
    return bankAccountMgmService.listAll();
  }

  @GetMapping("/{id}")
  public Mono<BankAccount> getBankAccountById(@PathVariable String id) {
    return bankAccountMgmService.getById(id);
  }

  @PostMapping
  public Mono<BankAccount> createBankAccount(@RequestBody BankAccount request) {
    return bankAccountMgmService.create(request);
  }

  @PutMapping("/{id}")
  public Mono<BankAccount> updateBankAccount(@PathVariable String id, @RequestBody BankAccount request) {
    return bankAccountMgmService.update(id, request);
  }

  @DeleteMapping("/{id}")
  public Mono<Void> deleteBankAccount(@PathVariable String id) {
    return bankAccountMgmService.delete(id);
  }


  @PostMapping("/{accountId}/deposits")
  public Mono<BankAccount> deposits(@PathVariable String accountId, @RequestParam BigDecimal amount) {
    return bankAccountMgmService.deposits(accountId, amount);
  }

  @PostMapping("/{accountId}/withdrawCash")
  public Mono<BankAccount> withdrawCash(@PathVariable String accountId, @RequestParam BigDecimal amount) {
    return bankAccountMgmService.withdrawCash(accountId, amount);
  }

  @PostMapping("/transfers")
  public Mono<Void> transfers(@RequestParam String originAccountId, @RequestParam String destinationAccountId, @RequestParam BigDecimal amount) {
    return bankAccountMgmService.transfers(originAccountId, destinationAccountId, amount);
  }
}
