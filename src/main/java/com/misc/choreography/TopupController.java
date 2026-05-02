/*
package com.misc.choreography;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class TopupController {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @PostMapping("/topup")
    public ResponseEntity<Void> createTopup(@RequestBody TopupRequest request) {

        String sagaId = UUID.randomUUID().toString();

        TopupOrderCreatedEvent event = new TopupOrderCreatedEvent();
        event.setSagaId(sagaId);
        event.setAccountId(request.getAccountId());
        event.setPhoneNumber(request.getPhoneNumber());
        event.setAmount(request.getAmount());
        event.setCreatedAt(Instant.now());

        kafkaTemplate.send("topup-order-created", event);

        return ResponseEntity.accepted().build();
    }
}
*/
