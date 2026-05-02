/*
package com.misc.choreography;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@RequiredArgsConstructor
public class PaymentEventListener {

    private final AccountService accountService;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @KafkaListener(topics = "topup-order-created")
    public void handleTopupOrder(TopupOrderCreatedEvent event) {

        boolean success = accountService.debit(
                event.getAccountId(),
                event.getAmount()
        );

        if (success) {
            AccountDebitedEvent debitedEvent = new AccountDebitedEvent();
            debitedEvent.setSagaId(event.getSagaId());
            debitedEvent.setAccountId(event.getAccountId());
            debitedEvent.setAmount(event.getAmount());
            debitedEvent.setCreatedAt(Instant.now());

            kafkaTemplate.send("account-debited", debitedEvent);
        }
    }
}*/
