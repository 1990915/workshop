package com.misc.iso.dto;

import java.math.BigDecimal;

public class SwitchIsoMsgDto {

    //private String date;
    private String mti;
    private String pan;//2
    private String processCode;//3
    private String transmissionDate;//7

    private String amountCardHolderFee;//8
    private String conversionRateCardHolderBilling;//
    private String localDateTime;
    private String settlementDate;
    private String captureDate;
    private String messageErrorIndicator;
    private String acquireCountryCode;
    private String functionCode;
    private String acquiringInstitutionIdentificationCode;
    private String retrievalReferenceNumber;
    private String authorizationIdentificationResponse;

    private String actionCode;

    private String device;

    private String cardExpDate;
    private String password;
    private String secondPassword;
    private BigDecimal amountTransaction;
    private String amountCardHolderBilling;
    private String transactionCoding;
    private String accountIdentification1;
    private String accountIdentification2;

    private String cvv;
    private String cvv2;
    private String track2Data;
    private String additionalData;
    private String toAccountNumber;
    private String toPan;
    private String cardAcceptorTerminalId;
    private String cardAcceptorTerminalCode;
    private String cardAcceptorTerminalName;
    private String acquirerRequestStan;
    private String reversalResponseCode;
    private String fromAccountNumber;
    private String identifier;
    private String paymentIdentifier;
    private String paymentAccountNumber;
    private String stan;


    /*public String getDate() {
        return date;
    }

    public SwitchIsoMsgDto setDate(String date) {
        this.date = date;
        return this;
    }*/

    public String getMti() {
        return mti;
    }

    public SwitchIsoMsgDto setMti(String mti) {
        this.mti = mti;
        return this;
    }

    public String getProcessCode() {
        return processCode;
    }

    public SwitchIsoMsgDto setProcessCode(String processCode) {
        this.processCode = processCode;
        return this;
    }

    /*public String getCardHolderFee() {
        return cardHolderFee;
    }

    public SwitchIsoMsgDto setCardHolderFee(String cardHolderFee) {
        this.cardHolderFee = cardHolderFee;
        return this;
    }*/

    public String getConversionRateCardHolderBilling() {
        return conversionRateCardHolderBilling;
    }

    public SwitchIsoMsgDto setConversionRateCardHolderBilling(String conversionRateCardHolderBilling) {
        this.conversionRateCardHolderBilling = conversionRateCardHolderBilling;
        return this;
    }

    public String getDevice() {
        return device;
    }

    public SwitchIsoMsgDto setDevice(String device) {
        this.device = device;
        return this;
    }

    public String getPan() {
        return pan;
    }

    public SwitchIsoMsgDto setPan(String pan) {
        this.pan = pan;
        return this;
    }

    public String getCardExpDate() {
        return cardExpDate;
    }

    public SwitchIsoMsgDto setCardExpDate(String cardExpDate) {
        this.cardExpDate = cardExpDate;
        return this;
    }


    public String getMessageErrorIndicator() {
        return messageErrorIndicator;
    }

    public SwitchIsoMsgDto setMessageErrorIndicator(String messageErrorIndicator) {
        this.messageErrorIndicator = messageErrorIndicator;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SwitchIsoMsgDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getSecondPassword() {
        return secondPassword;
    }

    public SwitchIsoMsgDto setSecondPassword(String secondPassword) {
        this.secondPassword = secondPassword;
        return this;
    }

    public String getTransmissionDate() {
        return transmissionDate;
    }

    public SwitchIsoMsgDto setTransmissionDate(String transmissionDate) {
        this.transmissionDate = transmissionDate;
        return this;
    }

    public BigDecimal getAmountTransaction() {
        return amountTransaction;
    }

    public SwitchIsoMsgDto setAmountTransaction(BigDecimal amountTransaction) {
        this.amountTransaction = amountTransaction;
        return this;
    }

    public String getAmountCardHolderBilling() {
        return amountCardHolderBilling;
    }

    public SwitchIsoMsgDto setAmountCardHolderBilling(String amountCardHolderBilling) {
        this.amountCardHolderBilling = amountCardHolderBilling;
        return this;
    }

    public String getCvv() {
        return cvv;
    }

    public SwitchIsoMsgDto setCvv(String cvv) {
        this.cvv = cvv;
        return this;
    }

    public String getCvv2() {
        return cvv2;
    }

    public SwitchIsoMsgDto setCvv2(String cvv2) {
        this.cvv2 = cvv2;
        return this;
    }

    public String getTrack2Data() {
        return track2Data;
    }

    public SwitchIsoMsgDto setTrack2Data(String track2Data) {
        this.track2Data = track2Data;
        return this;
    }

    public String getAdditionalData() {
        return additionalData;
    }

    public SwitchIsoMsgDto setAdditionalData(String additionalData) {
        this.additionalData = additionalData;
        return this;
    }

    public String getToAccountNumber() {
        return toAccountNumber;
    }

    public SwitchIsoMsgDto setToAccountNumber(String toAccountNumber) {
        this.toAccountNumber = toAccountNumber;
        return this;
    }

    public String getToPan() {
        return toPan;
    }

    public SwitchIsoMsgDto setToPan(String toPan) {
        this.toPan = toPan;
        return this;
    }

    public String getCardAcceptorTerminalId() {
        return cardAcceptorTerminalId;
    }

    public SwitchIsoMsgDto setCardAcceptorTerminalId(String cardAcceptorTerminalId) {
        this.cardAcceptorTerminalId = cardAcceptorTerminalId;
        return this;
    }

    public String getCardAcceptorTerminalCode() {
        return cardAcceptorTerminalCode;
    }

    public SwitchIsoMsgDto setCardAcceptorTerminalCode(String cardAcceptorTerminalCode) {
        this.cardAcceptorTerminalCode = cardAcceptorTerminalCode;
        return this;
    }

    public String getCardAcceptorTerminalName() {
        return cardAcceptorTerminalName;
    }

    public SwitchIsoMsgDto setCardAcceptorTerminalName(String cardAcceptorTerminalName) {
        this.cardAcceptorTerminalName = cardAcceptorTerminalName;
        return this;
    }

    public String getAcquirerRequestStan() {
        return acquirerRequestStan;
    }

    public SwitchIsoMsgDto setAcquirerRequestStan(String acquirerRequestStan) {
        this.acquirerRequestStan = acquirerRequestStan;
        return this;
    }

    public String getReversalResponseCode() {
        return reversalResponseCode;
    }

    public SwitchIsoMsgDto setReversalResponseCode(String reversalResponseCode) {
        this.reversalResponseCode = reversalResponseCode;
        return this;
    }

    public String getFromAccountNumber() {
        return fromAccountNumber;
    }

    public SwitchIsoMsgDto setFromAccountNumber(String fromAccountNumber) {
        this.fromAccountNumber = fromAccountNumber;
        return this;
    }

    public String getIdentifier() {
        return identifier;
    }

    public SwitchIsoMsgDto setIdentifier(String identifier) {
        this.identifier = identifier;
        return this;
    }

    public String getPaymentIdentifier() {
        return paymentIdentifier;
    }

    public SwitchIsoMsgDto setPaymentIdentifier(String paymentIdentifier) {
        this.paymentIdentifier = paymentIdentifier;
        return this;
    }

    public String getPaymentAccountNumber() {
        return paymentAccountNumber;
    }

    public SwitchIsoMsgDto setPaymentAccountNumber(String paymentAccountNumber) {
        this.paymentAccountNumber = paymentAccountNumber;
        return this;
    }

    public String getStan() {
        return stan;
    }

    public SwitchIsoMsgDto setStan(String stan) {
        this.stan = stan;
        return this;
    }

    public String getLocalDateTime() {
        return localDateTime;
    }

    public SwitchIsoMsgDto setLocalDateTime(String localDateTime) {
        this.localDateTime = localDateTime;
        return this;
    }

    public String getSettlementDate() {
        return settlementDate;
    }

    public SwitchIsoMsgDto setSettlementDate(String settlementDate) {
        this.settlementDate = settlementDate;
        return this;
    }

    public String getCaptureDate() {
        return captureDate;
    }

    public SwitchIsoMsgDto setCaptureDate(String captureDate) {
        this.captureDate = captureDate;
        return this;
    }

    public String getAcquireCountryCode() {
        return acquireCountryCode;
    }

    public SwitchIsoMsgDto setAcquireCountryCode(String acquireCountryCode) {
        this.acquireCountryCode = acquireCountryCode;
        return this;
    }

    public String getFunctionCode() {
        return functionCode;
    }

    public SwitchIsoMsgDto setFunctionCode(String functionCode) {
        this.functionCode = functionCode;
        return this;
    }

    public String getAcquiringInstitutionIdentificationCode() {
        return acquiringInstitutionIdentificationCode;
    }

    public SwitchIsoMsgDto setAcquiringInstitutionIdentificationCode(String acquiringInstitutionIdentificationCode) {
        this.acquiringInstitutionIdentificationCode = acquiringInstitutionIdentificationCode;
        return this;
    }

    public String getRetrievalReferenceNumber() {
        return retrievalReferenceNumber;
    }

    public SwitchIsoMsgDto setRetrievalReferenceNumber(String retrievalReferenceNumber) {
        this.retrievalReferenceNumber = retrievalReferenceNumber;
        return this;
    }

    public String getAuthorizationIdentificationResponse() {
        return authorizationIdentificationResponse;
    }

    public SwitchIsoMsgDto setAuthorizationIdentificationResponse(String authorizationIdentificationResponse) {
        this.authorizationIdentificationResponse = authorizationIdentificationResponse;
        return this;
    }

    public String getActionCode() {
        return actionCode;
    }

    public SwitchIsoMsgDto setActionCode(String actionCode) {
        this.actionCode = actionCode;
        return this;
    }

    public String getTransactionCoding() {
        return transactionCoding;
    }

    public SwitchIsoMsgDto setTransactionCoding(String transactionCoding) {
        this.transactionCoding = transactionCoding;
        return this;
    }

    public String getAccountIdentification1() {
        return accountIdentification1;
    }

    public SwitchIsoMsgDto setAccountIdentification1(String accountIdentification1) {
        this.accountIdentification1 = accountIdentification1;
        return this;
    }

    public String getAccountIdentification2() {
        return accountIdentification2;
    }

    public SwitchIsoMsgDto setAccountIdentification2(String accountIdentification2) {
        this.accountIdentification2 = accountIdentification2;
        return this;
    }

    public String getAmountCardHolderFee() {
        return amountCardHolderFee;
    }

    public SwitchIsoMsgDto setAmountCardHolderFee(String amountCardHolderFee) {
        this.amountCardHolderFee = amountCardHolderFee;
        return this;
    }
}