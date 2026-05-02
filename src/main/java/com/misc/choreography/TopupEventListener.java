/*
package com.misc.choreography;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TopupEventListener {

    private final TopupProvider topupProvider;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @KafkaListener(topics = "account-debited")
    public void handleAccountDebited(AccountDebitedEvent event) {

        boolean success = topupProvider.charge(event.getSagaId());

        if (!success) {

            TopupFailedEvent failedEvent = new TopupFailedEvent();
            failedEvent.setSagaId(event.getSagaId());
            failedEvent.setReason("Operator error");
            failedEvent.setCreatedAt(Instant.now());

            kafkaTemplate.send("topup-failed", failedEvent);
        }
    }
}*/
