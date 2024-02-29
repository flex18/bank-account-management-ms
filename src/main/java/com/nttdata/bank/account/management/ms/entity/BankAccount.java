package com.nttdata.bank.account.management.ms.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document("bankAccount")
public class BankAccount implements Serializable {

  @Id
  private String accountId;
  private String accountType; // Ahorro, corriente, plazo fijo.
  private String customerId;
  private BigDecimal amount;
}
