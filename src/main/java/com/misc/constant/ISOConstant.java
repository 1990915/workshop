package com.misc.constant;

/**
 * Created by s_salehi on 7/16/2017.
 */
public class ISOConstant {
    public static final String CONTEXT = "CONTEXT";
    public static final String NAKISA_PERSON_INFO = "NAKISA_PERSON_INFO";
    public static final String ADDITIONAL_DATA_REQUEST = "ADDITIONAL_DATA_REQUEST";
    public static final String OTP = "OTP";
    public  static final String HARIM_REQUEST = "HARIM_REQUEST";
    public  static final String HARIM_RESPONSE = "HARIM_RESPONSE";
    public  static final String SERVICE_SELECTOR = "SERVICE_SELECTOR";
    public  static final String SERVICE_CONFIG = "SERVICE_CONFIG";
    public static final String ISOSOURCE = "SOURCE";
    /*public static final String REQUEST_MESSAGE_BROKER = "REQUEST_MESSAGE_BROKER";
    public static final String RESPONSE_MESSAGE_BROKER = "RESPONSE_MESSAGE_BROKER";*/
    public static final String REQUEST = "REQUEST";
    public static final String SWITCH_REQUEST = "SWITCH_REQUEST_DTO";
    public static final String CARDIRAN_REQUEST = "CARDIRAN_REQUEST";
    public static final String CARDIRAN_RESPONSE = "CARDIRAN_RESPONSE";
    public static final String ADDITIONAL_DATA = "ADDITIONAL_DATA";
    public static final String RESPONSE = "RESPONSE";
    public static final String DESTINATION = "DESTINATION";
    public static final String ACTION_CODE = "RESPONSE_CODE";
    public static final String REQUESTID="REQUEST_ID";
    public static final int REPEAT_REVERSALTIME = 60 * 1000;
    public static final String EXCEPTION_SRC_ID = "EXCEPTION-SRC-ID";
    public static final String INTERNAL_REFERENCE_ID = "INTERNAL-REFERENCE-ID";
    public static final String REFERENCE_ID = "REFERENCE-ID";
    public static final String ORIGINAL_INTERNAL_REFERENCE_ID = "ORIGINAL-INTERNAL-REFERENCE-ID";
    public static final String RESPONSE_CODE_DD = "RESPONSE_CODE_DD";
    public static final String HOST_CHANNEL_REQUEST = "host-channel-request";
    public static final String ISO_CHANNEL_REQUEST = "iso-channel-request";
    public static final String API_REST_REQUEST = "API_REST_REQUEST";
    public static final String REQUEST_HEADER = "REQUEST_HEADER";

    public static final String FINANCIAL_REQUEST = "FINANCIAL_REQUEST";
    public static final String FINANCIAL_RESPONSE = "FINANCIAL_RESPONSE";
    public static final String NAKISA_REQUSET_NO = "NAKISA_REQUSET_NO";
    public static final String ORIGINAL_NAKISA_REQUSET_NO = "ORIGINAL_NAKISA_REQUSET_NO";
    public static final String NAKISA_REQUSET = "NAKISA_REQUSET";
    public static final String IBAN_INQUIRY_REQUSET = "IBAN_INQUIRY_REQUSET";
    public static final String SAYAH_INQUIRY_REQUSET = "SAYAH_INQUIRY_REQUSET";
    public static final String ISUN_REQUSET = "ISUN_REQUSET";
    public static final String ISUN_RESULT = "ISUN_RESULT";
    public static final String PAN_INFO = "PAN_INFO";
    public static final String ACCOUNT_INFO = "ACCOUNT_INFO";
    public static final String DST_PAN_INFO = "DST_PAN_INFO";
    public static final String NAKISA_ERROR = "NAKISA_ERROR";
    public static final String NAKISA_RESULT = "NAKISA_RESULT";
    public static final String HAMON_RESULT = "HAMON_RESULT";
    public static final String IBAN_RESULT = "IBAN_RESULT";
    public static final String SAYAH_RESULT = "SAYAH_RESULT";
    public static final String NAKISA_PROCESSING_PAN = "NAKISA_PROCESSING_PAN";
    public static final String NAKISA_PROCESSING_IBAN ="NAKISA_PROCESSING_IBAN";
    public static final String NAKISA_IBAN_INFO = "IBAN_INFO";
    public static final String FEE_CALC_TABLE_TYPE = "FEE_CALC_TABLE_TYPE";
    public static final String WORKING_DATE = "WORKING_DATE";
    public static final String NAKISA_CHANNEL_REQUEST_DETAIL_PERSIST = "NAKISA_CHANNEL_REQUEST_DETAIL_PERSIST";
    public static final String HOST_CHANNEL_REQUEST_PERSIST = "HOST_CHANNEL_REQUEST_PERSIST";
    public static final String ISO_CHANNEL_REQUEST_PERSIST = "ISO_CHANNEL_REQUEST_PERSIST";
    public static final String API_REST_CHANNEL_REQUEST_PERSIST = "API_REST_CHANNEL_REQUEST_PERSIST";
    public static final String PIN_VERIFY_PREPARED = "PIN_VERIFY_PREPARED";
    public static final String CHANGE_PIN1_PREPARED = "CHANGE_PIN1_PREPARED";
    public static final String CHANGE_PIN2_PREPARED = "CHANGE_PIN2_PREPARED";
    public static final String RESTRICTION_PREPARED = "RESTRICTION_PREPARED";
    public static final String FINANCIAL_MSG_PREPARED = "FINANCIAL_MSG_PREPARED";
    public static final String AUTHENTICATION_TYPE = "AUTHENTICATION_TYPE";
    public static final String SERVICE_DETAIL = "SERVICE_DETAIL";
    public static final String FINANCIAL_MSG_REQUEST = "FINANCIAL_MSG_REQUEST";
    public static final String ADDITIONAL_AMOUNTS_4BALANCE = "ADDITIONAL_AMOUNTS_4BALANCE";
    public static final String SOURCE_ACCOUNT_NUMBER = "SOURCE_ACCOUNT_NUMBER";
    public static final String HOST_RESPONSE = "HOST_RESPONSE";


    public static final Integer ISS_CHANNEL_ID =9;
    public static final Integer ISS_CHANNEL_TYPE =1;

    public static final Integer CARDIRAN_CHANNEL_ID =9;
    public static final Integer CARDIRAN_CHANNEL_TYPE =1;

    public static final Integer SHETAB_CHANNEL_ID =8;

    public static final Integer API_ACQUIRING_CHANNEL_ID = 2;
    public static final Integer ISS_CHANNEL_EXCEPTION_SRC_ID = 9;
    public static final Integer NAKISA_EXCEPTION_SRC_ID =10;
    public static final Integer NAKISA_CHANNEL_TYPE =2;
    public static final Integer HARIM_EXCEPTION_SRC_ID =7;
    public static final Integer HARIM_CHANNEL_TYPE =2;
    public static final Integer REMOTE_EXCEPTION_SRC_ID = 11;

    public static final String EXCEPTION_TAG = "Exception";
    public static final String REVERSAL_MSG_REQ = "REVERSAL_MSG_REQ";
    public static final String REVERSAL_MSG_RES = "REVERSAL_MSG_RES";
    public static final String SHETAB_FORWARDING_INSTITUTION_IDENTIFICATION_CODE="950001";

    public static final String REVERSAL_REQUIRED = "REVERSAL_REQUIRED";
    public static final String REVERSAL_REQUIRED_STATE = "REVERSAL_REQUIRED_STATE";
    public static final String SETTING_ENTITY = "SETTING_ENTITY";
    public static final String NAKISA_DEADLINE_TIME = "deadline";
    public static final String NAKISA_DEADLINE_TIME_FORMAT = "yyyyMMdd'T'HHmmssSSS'Z'";
    public static final String SWITCH_TX_SPACE = "SWITCH_TX";
    //      Field Index

    public static final int MTI = 0;
    public static final int PAN = 2;
    public static final int PROCESSING_CODE = 3;
    public static final int TRANSACTION_AMOUNT = 4;
    public static final int CARDHOLDER_BILLING_AMOUNT = 6;
    public static final int TRANSMISSION_DATE_TIME = 7;
    public static final int CARDHOLDER_BILLING_FEE_AMOUNT = 8;
    public static final int CONVERSION_RATE_CARDHOLDER_BILLING = 10;
    public static final int STAN = 11;
    public static final int LOCAL_TRANSACTION_DATE_TIME = 12;
    public static final int DATA_EXPIRATION = 14;
    public static final int SETTLEMENT_DATE = 15;
    public static final int DATE_CAPTURE = 17;
    public static final int MESSAGE_ERROR_INDICATOR = 18;
    public static final int ACQUIRE_COUNTRY_CODE = 19;
    public static final int POINT_OF_SERVICE_DATA_CODE = 22;
    public static final int FUNCTION_CODE = 24;
    public static final int MESSAGE_RESASON_CODE = 25;
    public static final int MERCHANT_CATEGORY_CODE_BUSINESS_TYPE = 26;
    public static final int POINT_OF_SERVICE_CAPABILITY = 27;
    public static final int TRANSACTION_FEE_AMOUNT = 28;
    public static final int AMOUNT_ORIGINAL = 30;
    public static final int ACQUIRING_INSTITUTION_IDENTIFICATION_CODE = 32;
    public static final int FORWARDING_INSTITUTION_IDENTIFICATION_CODE = 33;
    public static final int TRACK2 = 35;
    public static final int RETRIEVAL_REFERENCE_NUMBER = 37;
    public static final int AUTHORIZATION_IDENTIFICATION_RESPONSE = 38;
    public static final int APPROVALCODE = 38;
    public static final int RESPONSE_CODE = 39;
    public static final int ACTION_CODE_39 = 39;

    public static final int CARD_ACCEPTOR_TERMINAL_IDENTIFICATION = 41;
    public static final int CARD_ACCEPTOR_IDENTIFICATION_CODE = 42;
    public static final int CARD_ACCEPTOR_NAME_LOCATION = 43;
    public static final int ADDITIONAL_RESPONSE_DATA = 44;
    public static final int ADDITIONAL_DATA_ISO = 46;
    public static final int ADDITIONAL_DATA_NATIONAL = 47;
    public static final String ADDITIONAL_DATA_NATIONAL_EX = "ADDITIONAL_DATA_NATIONAL_EX";
    public static final int ADDITIONAL_DATA_PRIVATE = 48;
    public static final int TRANSACTION_CURRENCY_CODE = 49;
    public static final int ISSUER_CURRENCY_CODE = 51;
    public static final int PIN_DATA = 52;
    public static final int SECURTIY_RELATED_CONTROL_INFORMATION = 53;
    public static final int ADDITIONAL_AMOUNTS = 54;
    public static final int ICC_DATA = 55;
    public static final int ORIGINAL_DATA_ELEMENT = 56;
    public static final int SECURITY_DATA = 60;
    public static final int IBAN_INFO = 61;
    public static final int TRANSACTION_CODEING = 62;
    public static final int MAC_KEY_INDEX = 64;
    public static final int NETWORK_MANAGEMENT_INFORMATION_CODE = 70;
    public static final int RECONCILIATION_DATA_PRIMARY = 74;
    public static final int RECONCILIATION_DATA_SECONDARY = 75;
    public static final int TRANSACTION_DESTINATION_INSITUATION_IDENTIFICATION_CODE = 93;
    public static final int TRANSACTION_ORIGINATOR_INSITUATION_IDENTIFICATION_CODE = 94;

    public static final int MESSAGE_SECURITY_CODE = 96;
    public static final int AMOUNT_NET_RECONCILIATION = 97;
    public static final int RECEIVE_INSTITUITON_IDENTIFICATION_CODE = 100;
    public static final int ACCOUNT_IDENTIFICATION_1 = 102;
    public static final int ACCOUNT_IDENTIFICATION_2 = 103;
    public static final int RECONCILIATION_FEE_AMOUNT_CREDIT = 109;
    public static final int RECONCILIATION_FEE_AMOUNT_DEBIT = 110;
    public static final int ACCOUNT_NUMBER = 111;
    public static final int RESERVED_FOR_NATIONAL_USE_116 = 116;
    public static final int ADDITIONAL_DATA_SHETAB = 120;
    public static final int PRIVATE_DATA = 121;
    public static final int NEW_PIN = 123;
    public static final int STATEMENT_DATA = 124;
    public static final int ADDITIONAL_DATA_RESPONSE = 125;
    public static final int ADDITIONAL_DATA_RESPONSE_126 = 126;
    public static final String ADDITIONAL_DATA_RESPONSE_EX = "ADDITIONAL_DATA_RESPONSE_EX";
    public static final int MESSAGE_AUTHENTICATION_CODE = 128;
    public static final int CHANNEL_NAME =1000;
    public static final int SOCKET_INFO=10001;
    public static final int REQUEST_ID=10002;
    public static final int NASIM_STAN=10003;


//        Shared Value

    public static final String APPROVED_SUCCESSFULLY_ACTION_CODE = "0000";
    public static final String ERROR_MAC_NOT_FOUND = "SECURITY_VIOLATION";
    public static final String ERROR_MAC_NOT_VALID = "SECURITY_VIOLATION";
    public static final String INVALID_TRANSACTION = "INVALID_TRANSACTION";
    public static final String REVERSAL_PC_PREFIX = "24";
    public static final String FINANCIAL_PC_PREFIX = "22";
    public static final String STATEMENT_PREFIX = "34";
    public static final String VERIFICATION_PC_PREFIX = "33";
    public static final String NETWORK_MANAGEMENT_PC_PREFIX = "28";
    public static final String RECONCILIATION_PC_PRIFIX = "90";
    public static final String INVALID_CARD_SERIALnUMBER = "14";

    public static final String CHARACTER_ENCODING = "Cp1256";


    public static final String ACCOUNT_TYPE = "10";
    public static final String ACTUAL_AMOUNT_FLAG = "01";
    public static final String AVAILABLE_AMOUNT_FLAG = "02";
    public static final String CURRENCY_CODE = "364";
    public static final String CREDIT_PREFIX = "C";
    public static final String DEBIT_PREFIX = "D";
    public static final String DEFAULT_EXCHANGE_RATE = "1";
    public static final String INITIAL_PIN_ENCRYPTION_KEY = "1C1C1C1C1C1C1C1C";
    public static final String INITIAL_ENCRYPTION_KEY = "1C1C1C1C1C1C1C1C";
    public static final String INITIAL_MASTER_KEY = "1C1C1C1C1C1C1C1C";
    public static final String ENCRYPTION_ALG = "DES";
    public static final String CHECKING_MTI_PREFIX = "01";
    public static final String FINANCIAL_MTI_PREFIX = "22";
    public static final String REVERSAL_MTI_PREFIX = "24";
    public static final String CUTOFF_MTI_PREFIX = "28";
    public static final String SETTLEMENT_MTI_PREFIX = "25";
    public static final String KEY_EXCHANGE_MTI_PREFIX = "08";
    public static final String TRANSFER_FROM_PC_PREFIX = "4K";
    public static final String TRANSFER_TO_PC_PREFIX = "4L";
    public static final String TRANSFER_INTERNAL_PC_PREFIX = "40";
    public static final String TRANSFER_VERIFICATION_PC_PREFIX = "33";
    public static final String CUSTOMER_INFO_PC_PREFIX = "33";
    public static final String INQUIRE_DYNAMIC_PIN_PC_PREFIX = "33";
    public static final String CASH_PC_PREFIX = "01";
    public static final String DEPOSIT_CASH_PC_PREFIX = "21";
    public static final String DEPOSIT_CASH_RES_PC_PREFIX = "32";

    public static final String BUY = "00";
    public static final String PAYMENT = "50";
    public static final String BALANCE_INQUIRY_PC_PREFIX = "31";
    public static final String FULL_STATEMENT_PC_PREFIX = "39";
    public static final String MINI_STATEMENT_PC_PREFIX = "37";
    public static final String CHARGE_PC_PREFIX = "17";
    public static final String CHANGE_PIN_PC_PREFIX = "91";
    public static final String ACTIVATE_PIN2_PC_PREFIX = "92";
    public static final String GET_CARD_ACCOUNTS_PC_PREFIX = "93";
    public static final String DEACTIVATE_PIN2_PC_PREFIX = "92";
    public static final String HOST_DOWN = "84";
    public static final String TIME_OUT_ACTION_CODE = "91";
    public static final String NONE_FINANCIAL_PC_PREFIX = "91";
    public static final String REQUEST_BUILDER = "REQUEST_BUILDER";


    public static final String MasterKeyPart2_CARDIRAN = "MasterKeyPart2_CARDIRAN";


}
