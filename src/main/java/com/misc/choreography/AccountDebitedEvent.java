package com.misc.choreography;

import java.math.BigDecimal;

public class AccountDebitedEvent extends BaseEvent {
    private String accountId;
    private BigDecimal amount;
}
