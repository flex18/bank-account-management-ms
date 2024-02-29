package com.nttdata.bank.account.management.ms.repository;

import com.nttdata.bank.account.management.ms.entity.BankAccount;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BankAccountRepository extends ReactiveMongoRepository<BankAccount, String> {
}
