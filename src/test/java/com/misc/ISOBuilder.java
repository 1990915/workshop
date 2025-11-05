package com.misc;


import com.misc.constant.ISOConstant;
import com.misc.iso.DataSetIdentifierPackager;
import org.jpos.iso.ISOBinaryField;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOUtil;
import org.jpos.iso.packager.GenericPackager;
import org.jpos.util.LogEvent;
import org.jpos.util.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import java.io.IOException;

import static com.misc.constant.ISOConstant.EXCEPTION_TAG;

public class ISOBuilder extends ISOMsg {

    public static class builder {
        private String mti;
        private String pan;
        private String processing_code;
        private String transaction_amount;
        private String cardholder_billing_amount;
        private String transmission_date_time;
        private String conversion_rate_cardholder_billing;
        private String stan;
        private String local_transaction_date_time;
        private String data_expiration;
        private String settlement_date;
        private String data_capture;
        private String message_error_indicator;
        private String aquire_country_code;
        private String point_of_service_data_code;
        private String function_code;
        private String message_reason_code;
        private String merchant_category_code_business_type;
        private String point_of_service_capability;
        private String transaction_fee_amount;
        private String acquiring_institution_identification_code;
        private String forwarding_institution_identification_code;
        private String track2;
        private String retrieval_reference_number;
        private String response_code;
        private String card_acceptor_terminal_identification;
        private String card_acceptor_identification_code;
        private CardAcceptorInfo card_acceptor_name_location;
        private String additional_response_data;
        private String additional_data_iso;
        private String additional_data_private;
        private String securityData;
        private String ibanInfo;
        private String security_related_control_information;
        private String transaction_currency_code;
        private String original_data_elment;
        private String pin_data;
        private String additional_amounts;
        private String transaction_codeing;
        private String mac_key_index;
        private String network_management_information_code;
        private String original_data_element;
        private String message_security_code;
        private String receive_instituiton_identification_code;
        private String account_identification_1;
        private String account_identification_2;
        private String newPin;
        //private final SecurityRelatedControl securityRelatedControl;
        private String transaction_destination_IICode;
        private String transaction_originator_IICode;
        private String original_amount_transaction;
        private String additional_data_national;
        private String additional_data_response;

        public String getAdditional_data_national() {
            return additional_data_national;
        }

        public void setAdditional_data_national(String additional_data_national) {
            this.additional_data_national = additional_data_national;
        }

//        public builder(SecurityRelatedControl securityRelatedControl) {
//            this.securityRelatedControl = securityRelatedControl;
//        }

        public builder mti(String mti) {
            this.mti = mti;
            return this;
        }

        public builder original_amount_transaction(String original_amount_transaction) {
            this.original_amount_transaction = original_amount_transaction;
            return this;
        }

        public builder pan(String pan) {
            this.pan = pan;
            return this;
        }

        public builder processing_code(String processing_code) {
            this.processing_code = processing_code;
            return this;
        }

        public builder transaction_amount(String transaction_amount) {
            this.transaction_amount = transaction_amount;
            return this;
        }

        public builder cardholder_billing_amount(String cardholder_billing_amount) {
            this.cardholder_billing_amount = cardholder_billing_amount;
            return this;
        }

        public builder transmission_date_time(String transmission_date_time) {
            this.transmission_date_time = transmission_date_time;
            return this;
        }

        public builder conversion_rate_cardholder_billing(String conversion_rate_cardholder_billing) {
            this.conversion_rate_cardholder_billing = conversion_rate_cardholder_billing;
            return this;
        }

        public builder stan(String stan) {
            this.stan = stan;
            return this;
        }

        public builder local_transaction_date_time(String local_transaction_date_time) {
            this.local_transaction_date_time = local_transaction_date_time;
            return this;
        }

        public builder data_expiration(String data_expiration) {
            this.data_expiration = data_expiration;
            return this;
        }

        public builder settlement_date(String settlement_date) {
            this.settlement_date = settlement_date;
            return this;
        }

        public builder data_capture(String data_capture) {
            this.data_capture = data_capture;
            return this;
        }

        public builder message_error_indicator(String message_error_indicator) {
            this.message_error_indicator = message_error_indicator;
            return this;
        }

        public builder aquire_country_code(String aquire_country_code) {
            this.aquire_country_code = aquire_country_code;
            return this;
        }

        public builder point_of_service_data_code(String point_of_service_data_code) {
            this.point_of_service_data_code = point_of_service_data_code;
            return this;
        }

        public builder function_code(String function_code) {
            this.function_code = function_code;
            return this;
        }

        public builder message_reason_code(String message_reason_code) {
            this.message_reason_code = message_reason_code;
            return this;
        }


        public builder merchant_category_code_business_type(String merchant_category_code_business_type) {
            this.merchant_category_code_business_type = merchant_category_code_business_type;
            return this;
        }

        public builder point_of_service_capability(String point_of_service_capability) {
            this.point_of_service_capability = point_of_service_capability;
            return this;
        }

        public builder transaction_fee_amount(String transaction_fee_amount) {
            this.transaction_fee_amount = transaction_fee_amount;
            return this;
        }

        public builder acquiring_institution_identification_code(String acquiring_institution_identification_code) {
            this.acquiring_institution_identification_code = acquiring_institution_identification_code;
            return this;
        }

        public builder forwarding_institution_identification_code(String forwarding_institution_identification_code) {
            this.forwarding_institution_identification_code = forwarding_institution_identification_code;
            return this;
        }

        public builder track2(String track2) {
            this.track2 = track2;
            return this;
        }

        public builder retrieval_reference_number(String retrieval_reference_number) {
            this.retrieval_reference_number = retrieval_reference_number;
            return this;
        }

        public builder response_code(String response_code) {
            this.response_code = response_code;
            return this;
        }

        public builder card_acceptor_terminal_identification(String card_acceptor_terminal_identification) {
            this.card_acceptor_terminal_identification = card_acceptor_terminal_identification;
            return this;
        }

        public builder card_acceptor_identification_code(String card_acceptor_identification_code) {
            this.card_acceptor_identification_code = card_acceptor_identification_code;
            return this;
        }

        public builder card_acceptor_name_location(CardAcceptorInfo card_acceptor_name_location) {
            this.card_acceptor_name_location = card_acceptor_name_location;
            return this;
        }

        public builder additional_response_data(String additional_response_data) {
            this.additional_response_data = additional_response_data;
            return this;
        }

        public builder additional_data_iso(String additional_data_iso) {
            this.additional_data_iso = additional_data_iso;
            return this;
        }

        public builder additional_data_private(String additional_data_private) {
            this.additional_data_private = additional_data_private;
            return this;
        }


        /*public builder additional_data_national(String additionalDataForRequest) {
            AdditionalDataRequest additionalDataRequest2 = Utiles.getAdditionalDataRequestOfJSon(additionalDataForRequest);
            additionalDataRequest2.setReferenceNo(retrieval_reference_number);
            String data = Utiles.getJSonAdditionalDataRequest(additionalDataRequest2);
            this.additional_data_national = data;
            return this;
        }
        public builder charge_additional_data_national(String additionalDataForRequest) {
            AdditionalDataRequest additionalDataRequest = Utiles.getAdditionalDataRequestOfJSon(additionalDataForRequest);
            this.additional_data_national = Utiles.getJSonAdditionalDataRequest(additionalDataRequest);
            return this;
        }

        public builder additional_data_national_cardIran(String additionalDataForRequest, String internalRefID) {
            AdditionalDataRequest additionalDataRequest2 = Utiles.getAdditionalDataRequestOfJSon(additionalDataForRequest);
            additionalDataRequest2.setReferenceNo(internalRefID);
            this.additional_data_national = Utiles.getJSonAdditionalDataRequest(additionalDataRequest2);
            return this;
        }

        public builder additional_data_national(String additionalDataForRequest, String internalRefID) {
            AdditionalDataRequest additionalDataRequest2 = Utiles.getAdditionalDataRequestOfJSon(additionalDataForRequest);
            additionalDataRequest2.setReferenceNo(internalRefID);
            this.additional_data_national = Utiles.getJSonAdditionalDataRequest(additionalDataRequest2);
            return this;
        }*/

        public builder transaction_currency_code(String transaction_currency_code) {
            this.transaction_currency_code = transaction_currency_code;
            return this;
        }

        public builder pin_data(String pin_data) {
            this.pin_data = pin_data;
            return this;
        }

        public builder additional_amounts(String additional_amounts) {
            this.additional_amounts = additional_amounts;
            return this;
        }

        public builder transaction_codeing(String transaction_codeing) {
            this.transaction_codeing = transaction_codeing;
            return this;
        }

        public builder mac_key_index(String mac_key_index) {
            this.mac_key_index = mac_key_index;
            return this;
        }

        public builder network_management_information_code(String network_management_information_code) {
            this.network_management_information_code = network_management_information_code;
            return this;
        }

        public builder original_data_element(String original_data_element) {
            this.original_data_element = original_data_element;
            return this;
        }

        public builder message_security_code(String message_security_code) {
            this.message_security_code = message_security_code;
            return this;
        }

        public builder receive_instituiton_identification_code(String receive_instituiton_identification_code) {
            this.receive_instituiton_identification_code = receive_instituiton_identification_code;
            return this;
        }

        public builder account_identification_1(String account_identification_1) {
            this.account_identification_1 = account_identification_1;
            return this;
        }

        public builder account_identification_2(String account_identification_2) {
            this.account_identification_2 = account_identification_2;
            return this;
        }

        public builder securityData(String securityData) {
            this.securityData = securityData;
            return this;
        }

        public builder ibanInfo(String ibanInfo) {
            this.ibanInfo = ibanInfo;
            return this;
        }

        public builder securityRelatedControlInfo(String security_related_control_information) {
            this.security_related_control_information = security_related_control_information;
            return this;
        }

        public builder originalDataElements(String original_data_element) {
            this.original_data_element = original_data_element;
            return this;
        }

        public builder newPin(String newPin) {
            this.newPin = newPin;
            return this;
        }

        public builder transaction_destination_IICode(String transaction_destination_IICode) {
            this.transaction_destination_IICode = transaction_destination_IICode;
            return this;
        }

        public builder transaction_originator_IICode(String transaction_originator_IICode) {
            this.transaction_originator_IICode = transaction_originator_IICode;
            return this;
        }

        public builder additional_data_response(String additionalDataForResponse) {
            this.additional_data_response = additionalDataForResponse;
            return this;
        }


        public ISOMsg build() throws ISOException, IOException {
            Resource resource = new ClassPathResource("iso2003AsciiPackager.xml");
            ISOMsg msg = new ISOMsg();
            msg.setPackager(new GenericPackager(resource.getInputStream()));
            msg.set(0, mti);
            msg.set(2, pan);
            msg.set(3, processing_code);
            msg.set(4, transaction_amount);
            msg.set(6, cardholder_billing_amount);
            msg.set(7, transmission_date_time);
            msg.set(10, conversion_rate_cardholder_billing);
            msg.set(11, stan);
            msg.set(12, local_transaction_date_time);
            msg.set(14, data_expiration);
            msg.set(15, settlement_date);
            msg.set(17, data_capture);
            msg.set(18, message_error_indicator);
            msg.set(19, aquire_country_code);
            if (point_of_service_data_code != null) {
                msg.set(22, ISOUtil.hex2byte(point_of_service_data_code));
            }
            msg.set(24, function_code);
            msg.set(25, message_reason_code);
            msg.set(26, merchant_category_code_business_type);
            if (point_of_service_capability != null) {
                msg.set(27, point_of_service_capability);
            }
            msg.set(28, transaction_fee_amount);
            msg.set(30, original_amount_transaction);
            msg.set(32, acquiring_institution_identification_code);
            msg.set(33, forwarding_institution_identification_code);
            msg.set(35, track2);
            msg.set(37, retrieval_reference_number);
            msg.set(39, response_code);
            msg.set(41, card_acceptor_terminal_identification);
            msg.set(42, card_acceptor_identification_code);
            /*if (card_acceptor_name_location != null) {
                msg.set(getCardAcceptorName(card_acceptor_name_location));
            }*/
            msg.set(44, additional_response_data);
            msg.set(46, additional_data_iso);
            msg.set(47, additional_data_national);
            msg.set(48, additional_data_private);
            msg.set(49, transaction_currency_code);
            /*if (!(mti.startsWith("24"))) {
                if (pin_data != null) {
                    msg.set(52, ISOUtil.hex2byte(securityRelatedControl.encryptPin(pin_data,
                            panOrTopan())));
                }
            }
            if (security_related_control_information != null) {
                msg.set(53, ISOUtil.hex2byte(security_related_control_information));
            }*/
            msg.set(54, additional_amounts);
            msg.set(56, original_data_element);
            msg.set(60, securityData);
            msg.set(61, ibanInfo);
            msg.set(62, transaction_codeing);
            msg.set(70, network_management_information_code);
            msg.set(93, transaction_destination_IICode);
            msg.set(94, transaction_originator_IICode);
//            msg.set(96, message_security_code);
            msg.set(96, message_security_code != null ? ISOUtil.hex2byte(message_security_code) : null);
            msg.set(100, receive_instituiton_identification_code);
            msg.set(102, account_identification_1);
            msg.set(103, account_identification_2);
            msg.set(125, additional_data_response);
            /*if (newPin != null) {
                msg.set(123, securityRelatedControl.encryptPin(newPin, pan));
            }
            if (msg.getMaxField() <= 63) {
                msg.set(64, securityRelatedControl.generateMac(msg));
            } else {
                msg.set(128, securityRelatedControl.generateMac(msg));

            }*/
            return msg;
        }

        /*private String panOrTopan() {
            if (processing_code.startsWith(ISOConstant.TRANSFER_TO_PC_PREFIX)) {
                return additional_data_private.substring(10, 26);
            } else
                return pan;
        }*/


        public ISOMsg getCardAcceptorName(CardAcceptorInfo card_acceptor_name_location) {
            ISOMsg msg = new ISOMsg(ISOConstant.CARD_ACCEPTOR_NAME_LOCATION);
            try {
                msg.setPackager(new DataSetIdentifierPackager());
                msg.set(2, card_acceptor_name_location.getName());
                msg.set(4, card_acceptor_name_location.getCity());
                msg.set(5, card_acceptor_name_location.getStateTypeCode());
                msg.set(6, card_acceptor_name_location.getPostalCode());
                msg.set(7, card_acceptor_name_location.getCountryTypeCode());
                msg.set(8, card_acceptor_name_location.getPhoneNumber());
                msg.set(11, card_acceptor_name_location.getUrlAddress());
                msg.set(12, card_acceptor_name_location.getEmailAddress());
                msg.set(13, card_acceptor_name_location.getCityCode());
                msg.setDirection(ISOMsg.OUTGOING);
//              msg.setFieldNumber(ISOConstant.CARD_ACCEPTOR_NAME_LOCATION);
                msg.set(0, ISOUtil.hex2byte("71" + String.format("%4s", Integer.toHexString(msgSize(msg))).replace(" ", "0")));
                msg.recalcBitMap();
            } catch (ISOException e) {
                Logger.log(new LogEvent(EXCEPTION_TAG, e));
            }
            return msg;
        }

        private int msgSize(ISOMsg msg) {
            int size = 0;
            for (int i = 2; i <= 13; i++) {
                if (msg.hasField(i)) {
                    if (msg.getComponent(2) instanceof ISOBinaryField) {
                        size += msg.getBytes(i).length;
                    } else {
                        size += msg.getString(i).length();
                    }
                }
            }
            if (msg.hasField(11))
                size += 3;
            if (msg.hasField(12))
                size += 2;
            return size + 8;
        }
    }
}
