package com.misc.iso.mapper;

import com.misc.constant.ISOConstant;
import com.misc.iso.dto.SwitchIsoMsgDto;
import org.jpos.iso.ISOMsg;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class IsoToObjectMapperImpl implements IsoToObjectMapper {
    @Override
    public SwitchIsoMsgDto map(ISOMsg isoMsg) {
        return new SwitchIsoMsgDto()
                .setMti(isoMsg.getString(ISOConstant.MTI))
                .setPan(isoMsg.getString(ISOConstant.PAN))
                .setProcessCode(isoMsg.getString(ISOConstant.PROCESSING_CODE))
                .setAmountCardHolderFee(isoMsg.getString(ISOConstant.CARDHOLDER_BILLING_FEE_AMOUNT))
                .setAmountTransaction(new BigDecimal(isoMsg.getString(ISOConstant.TRANSACTION_AMOUNT)))
                .setAmountCardHolderBilling(isoMsg.getString(ISOConstant.CARDHOLDER_BILLING_AMOUNT))
                .setTransmissionDate(isoMsg.getString(ISOConstant.TRANSMISSION_DATE_TIME))
                .setConversionRateCardHolderBilling(isoMsg.getString(ISOConstant.CONVERSION_RATE_CARDHOLDER_BILLING))
                .setStan(isoMsg.getString(ISOConstant.STAN))
                .setLocalDateTime(isoMsg.getString(ISOConstant.LOCAL_TRANSACTION_DATE_TIME))
                .setSettlementDate(isoMsg.getString(ISOConstant.SETTLEMENT_DATE))
                .setCaptureDate(isoMsg.getString(ISOConstant.DATE_CAPTURE))
                .setMessageErrorIndicator(isoMsg.getString(ISOConstant.MESSAGE_ERROR_INDICATOR))
                .setAcquireCountryCode(isoMsg.getString(ISOConstant.ACQUIRE_COUNTRY_CODE))
                .setFunctionCode(isoMsg.getString(ISOConstant.FUNCTION_CODE))
                .setAcquiringInstitutionIdentificationCode(isoMsg.getString(ISOConstant.ACQUIRING_INSTITUTION_IDENTIFICATION_CODE))
                .setRetrievalReferenceNumber(isoMsg.getString(ISOConstant.RETRIEVAL_REFERENCE_NUMBER))
                .setAuthorizationIdentificationResponse(isoMsg.getString(ISOConstant.AUTHORIZATION_IDENTIFICATION_RESPONSE))
                .setActionCode(isoMsg.getString(ISOConstant.ACTION_CODE_39))
                .setCardAcceptorTerminalId(isoMsg.getString(ISOConstant.CARD_ACCEPTOR_TERMINAL_IDENTIFICATION))
                .setCardAcceptorTerminalCode(isoMsg.getString(ISOConstant.CARD_ACCEPTOR_IDENTIFICATION_CODE))
                .setAdditionalData(isoMsg.getString(ISOConstant.ADDITIONAL_DATA_PRIVATE))
                .setTransactionCoding(isoMsg.getString(ISOConstant.TRANSACTION_CODEING))
                .setAccountIdentification1(isoMsg.getString(ISOConstant.ACCOUNT_IDENTIFICATION_1))
                .setAccountIdentification2(isoMsg.getString(ISOConstant.ACCOUNT_IDENTIFICATION_2));
    }
}
