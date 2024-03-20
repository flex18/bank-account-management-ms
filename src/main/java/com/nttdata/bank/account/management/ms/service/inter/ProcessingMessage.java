package com.nttdata.bank.account.management.ms.service.inter;

import com.nttdata.bank.account.management.ms.entity.yanki.PaymentMadeEvent;

public interface ProcessingMessage {
  Void processing(PaymentMadeEvent request);
}
