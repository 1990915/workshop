package com.misc.choreography;

import java.math.BigDecimal;

public class TopupOrderCreatedEvent extends BaseEvent {
    private String accountId;
    private String phoneNumber;
    private BigDecimal amount;
}