package com.nttdata.bank.account.management.ms.entity.yanki;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentData {

  private String paymentId;
  private String cellPhoneNumber;
  private BigDecimal amount;
  private String date;

  public PaymentData(PaymentMadeEvent data){
    this.setPaymentId(data.getPaymentId());
    this.setCellPhoneNumber(data.getCellPhoneNumber());
    this.setAmount(data.getAmount());
    this.setDate(data.getDate());
  }

}
