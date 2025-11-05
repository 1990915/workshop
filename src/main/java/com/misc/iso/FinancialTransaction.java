package com.misc.iso;

import com.misc.constant.ISOConstant;
import org.jpos.iso.ISOMsg;

public class FinancialTransaction {

    protected String requestInput = ISOConstant.REQUEST;
    protected String responseInput = ISOConstant.RESPONSE;

    public String getRequestInput() {
        return requestInput;
    }

    public void setRequestInput(String requestInput) {
        this.requestInput = requestInput;
    }

    public String getResponseInput() {
        return responseInput;
    }

    public void setResponseInput(String responseInput) {
        this.responseInput = responseInput;
    }

   /* protected HashMap<String, Exception> exceptions = (HashMap<String, Exception>) ApplicationContextProvider.getContext().getBean("exceptions");
    protected HashMap<String, String> reversalReasonCodeMap = (HashMap<String, String>) ApplicationContextProvider.getContext().getBean("reversalReasonCodeMap");
    protected HashSet<String> approvedCode = (HashSet<String>) ApplicationContextProvider.getContext().getBean("successResp");
    protected HashSet<String> requiredReversal = (HashSet<String>) ApplicationContextProvider.getContext().getBean("requiredReversal");
    protected FinancialMsgDao financialMsgDao = ApplicationContextProvider.getContext().getBean(FinancialMsgDao.class);*/

    /*protected ISOMsg prepareResponse(Context context, String responseCode) throws ISOException {
        ISOMsg requestMsg = context.get(requestInput);
        return prepareResponse(requestMsg, null, responseCode);
    }
    protected ISOMsg prepareResponse(ISOMsg requestMsg, String responseCode) throws ISOException {
        return prepareResponse(requestMsg, null, responseCode);
    }

    public static String buildSW8Header(ISOMsg isoMsg) {
        return generateSW8Header(isoMsg);
    }*/

    public static String generateSW8Header(ISOMsg isoMsg) {
        String shetab8ReqHeader = new String(isoMsg.getHeader());
        return "005700008".
                concat(shetab8ReqHeader.substring(9, 13)).
                concat(shetab8ReqHeader.substring(24, 35)).
                concat(shetab8ReqHeader.substring(13, 24)).
                concat(shetab8ReqHeader.substring(35, 51)).
                concat(shetab8ReqHeader.substring(51, 57))
                .concat("0000");
    }

    /*protected ISOMsg prepareResponse(ISOMsg requestMsg, String accountNumber, String responseCode) throws ISOException {
        SecurityRelatedControl securityRelatedControl = new SecurityRelatedControl(ISOMsgUtil.getSecurityInfo(requestMsg));
        ISOMsg respMsg = (ISOMsg) requestMsg.clone();
        respMsg.setDirection(ISOMsg.OUTGOING);
        respMsg.unset(ISOConstant.DATA_EXPIRATION);
        respMsg.unset(ISOConstant.AQUIRE_COUNTRY_CODE);
        respMsg.unset(ISOConstant.POINT_OF_SERVICE_DATA_CODE);
        if (!requestMsg.getString(ISOConstant.MTI).startsWith(ISOConstant.NETWORK_MANAGEMENT_PC_PREFIX)) {
            respMsg.unset(ISOConstant.FUNCTION_CODE);
        }
        respMsg.unset(ISOConstant.MESSAGE_RESASON_CODE);
        respMsg.unset(ISOConstant.ADDITIONAL_DATA_SHETAB);
        respMsg.unset(ISOConstant.MERCHANT_CATEGORY_CODE_BUSINESS_TYPE);
        respMsg.unset(ISOConstant.POINT_OF_SERVICE_CAPABILITY);
        respMsg.unset(ISOConstant.AMOUNT_ORIGINAL);
        respMsg.unset(ISOConstant.FORWARDING_INSTITUTION_IDENTIFICATION_CODE);
        respMsg.unset(ISOConstant.TRACK2);
        respMsg.unset(ISOConstant.DATA_CAPTURE);
        respMsg.unset(ISOConstant.CARD_ACCEPTOR_NAME_LOCATION);
        if (!(requestMsg.hasField(ISOConstant.PROCESSING_CODE) &&
                requestMsg.getString(ISOConstant.PROCESSING_CODE).startsWith("33") &&
                ISOMsgUtil.isAcquirer(requestMsg))) {
            respMsg.unset(ISOConstant.ADDITIONAL_DATA_PRIVATE);
        }
        respMsg.unset(ISOConstant.SECURITY_DATA);
        respMsg.unset(ISOConstant.PIN_DATA);
        respMsg.unset(ISOConstant.SECURTIY_RELATED_CONTROL_INFORMATION);
        respMsg.unset(ISOConstant.ORIGINAL_DATA_ELEMENT);
        respMsg.unset(ISOConstant.MAC_KEY_INDEX);
        respMsg.unset(ISOConstant.MESSAGE_SECURITY_CODE);
        respMsg.unset(ISOConstant.RECONCILIATION_DATA_PRIMARY);
        respMsg.unset(ISOConstant.RECONCILIATION_DATA_SECONDARY);
        respMsg.unset(ISOConstant.AMOUNT_NET_RECONCILIATION);
        respMsg.unset(ISOConstant.RECONCILIATION_FEE_AMOUNT_CREDIT);
        respMsg.unset(ISOConstant.RECONCILIATION_FEE_AMOUNT_DEBIT);
        respMsg.unset(ISOConstant.RESERVED_FOR_NATIONAL_USE_116);
        respMsg.setResponseMTI();

        if (requestMsg.getString(ISOConstant.MTI).startsWith(ISOConstant.NETWORK_MANAGEMENT_PC_PREFIX) ||
                requestMsg.getString(ISOConstant.MTI).startsWith(ISOConstant.SETTLEMENT_MTI_PREFIX)) {
            respMsg.unset(ISOConstant.SETTLEMENT_DATE);
        } else {
            if (!respMsg.hasField(ISOConstant.SETTLEMENT_DATE)) {
                try {
                    respMsg.set(ISOConstant.SETTLEMENT_DATE, WorkingDateCash.getInstance().getCurrentWorkingDate());
                } catch (InternalErrorException e) {
                    Logger.log(new LogEvent(EXCEPTION_TAG, e));
                }
            }
        }

        if (!requestMsg.getString(ISOConstant.MTI).startsWith(ISOConstant.NETWORK_MANAGEMENT_PC_PREFIX) &&
                !requestMsg.getString(ISOConstant.MTI).startsWith(ISOConstant.SETTLEMENT_MTI_PREFIX)) {
            respMsg.set(ISOConstant.RECEIVE_INSTITUITON_IDENTIFICATION_CODE, "950001");
            if (requestMsg.getString(ISOConstant.PROCESSING_CODE).startsWith(ISOConstant.VERIFICATION_PC_PREFIX)) {
                respMsg.unset(ISOConstant.TRANSACTION_AMOUNT);
            }

            if (!approvedCode.contains(responseCode)) {
                respMsg.set(ISOConstant.MESSAGE_ERROR_INDICATOR, "00000000000000000");
            } else if (!respMsg.getString(ISOConstant.MTI).startsWith("24") && !respMsg.getString(ISOConstant.PROCESSING_CODE).startsWith(ISOConstant.RECONCILIATION_PC_PRIFIX)) {
                respMsg.set(ISOConstant.APPROVALCODE, requestMsg.getString(ISOConstant.STAN).substring(0, 3) + requestMsg.getString(ISOConstant.STAN).substring(9, 12));
            }
        }
        respMsg.set(ISOConstant.RESPONSE_CODE, responseCode);
        respMsg.set(ISOConstant.ACCOUNT_NUMBER, accountNumber);
        respMsg.unset(ISOConstant.ADDITIONAL_DATA_NATIONAL);
        if (requestMsg.getHeader() != null) {
            respMsg.setHeader(buildSW8Header(requestMsg).getBytes());
        }
        respMsg.recalcBitMap();
        if (respMsg.getMaxField() <= 63) {
            respMsg.set(64, securityRelatedControl.generateMac(respMsg));
        } else {
            respMsg.set(128, securityRelatedControl.generateMac(respMsg));

        }
        return respMsg;
    }*/

   /* protected void updateResponse(Context context) {
        ISOMsg respMsg = context.get(ISOConstant.RESPONSE);
        EntityMapper<FinancialMsgEntity> mapper = new EntityMapper<>(FinancialMsgEntity.class);
        try {
            FinancialMsgEntity resp = mapper.map(respMsg);
            financialMsgDao.saveOrUpdate(resp);
        } catch (Exception e) {
            Logger.log(new LogEvent(EXCEPTION_TAG, e));
        }
    }

    protected long save(ISOMsg reqMsg) throws InternalErrorException, ISOException {
        EntityMapper<FinancialMsgEntity> mapper = new EntityMapper<>(FinancialMsgEntity.class);
        FinancialMsgEntity financialMsgEntity = mapper.map(reqMsg);
        if (financialMsgEntity != null) {
            Long requestId = financialMsgDao.persist(financialMsgEntity);
            MetricManager prometheusMetricManager = (MetricManager) ApplicationContextProvider.getContext().getBean("prometheusMetricManager");
            prometheusMetricManager.incInset2DB(reqMsg);
            return requestId;
        } else
            return 0;
    }

    protected FinancialMsgEntity prepareResponseEntity(Serializable context) {
        ISOMsg resp = ((Context) context).get(ISOConstant.RESPONSE);
        Long requestId = ((Context) context).get(ISOConstant.REQUESTID);
        if (requestId == null)
            return null;
        EntityMapper<FinancialMsgEntity> mapper = new EntityMapper<>(FinancialMsgEntity.class);
        FinancialMsgEntity financialMsgEntity = null;
        try {
            financialMsgEntity = mapper.map(resp);
            if (financialMsgEntity == null)
                return null;
            financialMsgEntity.setAccountNumber(getAccountNumber(resp));
            financialMsgEntity.setRequestId(requestId);
            resp.unset(ISOConstant.ACCOUNT_NUMBER);
            resp.recalcBitMap();
            ((Context) context).put(ISOConstant.RESPONSE, resp);
        } catch (Exception e) {
            Logger.log(new LogEvent("Can not map isoMessage to Entity", e));
        }
        return financialMsgEntity;
    }

    private String getAccountNumber(ISOMsg resp) {
        if (resp.hasField(ISOConstant.ACCOUNT_IDENTIFICATION_1)) {
            return resp.getString(ISOConstant.ACCOUNT_IDENTIFICATION_1);
        } else if (resp.hasField(ISOConstant.ACCOUNT_NUMBER)) {
            return resp.getString(ISOConstant.ACCOUNT_NUMBER);
        } else {
            return "";
        }
    }

    protected String mapErrorCode(Exception e) {
        return Utiles.mapErrorCode(e);
    }

    protected String mapHarimErrorCodeByClassName(String className) {
        return Utiles.mapErrorCode(className);
    }

    protected String getIbanRespCode(String className) {
        return Utiles.getIbanRespCode(className);
    }

    protected String getSayahRespCode(String errorCode){
        return Utiles.getSayahRespCode(errorCode);
    }

    protected ISOMsg getAdditionalResponseDataForVerification(Locale locale, FinancialMsgResponse respMessage) {
        if (respMessage.getAccountOwners() == null || respMessage.getAccountOwners().isEmpty()) {
            return null;
        }
        ISOMsg isoMsg = new ISOMsg(ISOConstant.ADDITIONAL_RESPONSE_DATA);

        String first = respMessage.getAccountOwners().substring(0, 2);
        String name = respMessage.getAccountOwners().substring(2, 2 + Integer.parseInt(first));
        String second = respMessage.getAccountOwners().substring(2 + name.length(), 2 + name.length() + 2);
        String last = respMessage.getAccountOwners().substring(2 + name.length() + 2, 2 + name.length() + 2 + Integer.parseInt(second));
        first = Integer.valueOf(first) > 33 ? "33" : first;
        second = Integer.valueOf(second) > 33 ? "33" : second;
        try {
            isoMsg.setPackager(new DataSetIdentifierPackager());
            if (locale.getLanguage().equalsIgnoreCase("en")) {
                isoMsg.set(2, name.substring(0, Integer.parseInt(first)));
                isoMsg.set(3, last.substring(0, Integer.parseInt(second)));
            } else {
                isoMsg.set(2, IranSystemUtil.fromString(name.substring(0, Integer.parseInt(first))));
                isoMsg.set(3, IranSystemUtil.fromString(last.substring(0, Integer.parseInt(second))));
            }
            isoMsg.set(0, ISOUtil.hex2byte("73" + String.format("%4s", Integer.toHexString(msgSize(isoMsg))).replace(" ", "0")));
            isoMsg.recalcBitMap();
        } catch (ISOException e) {
            Logger.log(new LogEvent(EXCEPTION_TAG, e));
        }

        //TODO if confirm that all account has national Identifier this code must be enabled
        *//*if (isoMsg.getString(ISOConstants.ISO87.PC).startsWith(ISOConstants.ISO87.TRANSFER_TO_PC_PREFIX) ||
                isoMsg.getString(ISOConstants.ISO87.PC).startsWith(ISOConstants.ISO87.TRANSFER_VERIFICATION_PC_PREFIX)) {
            return result;
        } else {
            return concatNationalIdentifier(respMessage, result);
        }*//*
        return isoMsg;
    }

    protected ISOMsg getAdditionalResponseData(FinancialMsgResponse respMessage) {
        ISOMsg isoMsg = new ISOMsg(ISOConstant.ADDITIONAL_RESPONSE_DATA);
        try {
            isoMsg.set(4, "1111");
            isoMsg.set(5, "1111111111");
            isoMsg.set(6, respMessage.getAccountNumber());
            isoMsg.set(0, ISOUtil.hex2byte("73" + String.format("%4s", Integer.toHexString(msgSize(isoMsg))).replace(" ", "0")));
            isoMsg.recalcBitMap();
        } catch (ISOException e) {
            Logger.log(new LogEvent(EXCEPTION_TAG, e));
        }
        return isoMsg;
    }

    protected int msgSize(ISOMsg isoMsg) {
        int size = 0;
        for (int i = 2; i <= 6; i++) {
            if (isoMsg.hasField(i)) {
                if (isoMsg.getComponent(2) instanceof ISOBinaryField) {
                    size += isoMsg.getBytes(i).length;
                } else {
                    size += isoMsg.getString(i).length();
                }
            }
            if (i != 5 && isoMsg.hasField(i)) {
                size += 2;
            }
        }
        return size + 4;
    }

    protected String makeAvailableBalance(FinancialMsgResponse financialMsgResponse) {
        return getBalance("01", financialMsgResponse.getActualBalance()) +
                getBalance("02", financialMsgResponse.getActualBalance());

    }

    protected void mapRespCode(String respCode) throws Exception {
        if (exceptions.get(respCode) != null) {
            throw exceptions.get(respCode);
        }
        throw new InternalErrorException("shetab response code: " + respCode);
    }

    protected String getBalance(String balanceType, BigDecimal balance) {
        String accountType = "00";
        String result = accountType + balanceType;
        if (balance.compareTo(BigDecimal.ZERO) < 0)
            result = result + "D";
        else
            result = result + "C";
        result = result + "3640";
        result = result + PadUtil.Pad(String.valueOf(Math.abs(balance.longValue())), 12, "0", PadUtil.PadPosition.Behind);
        return result;
    }

    protected void isTransactionVerified(ISOMsg reqMsg) throws InvalidTransactionException {
        String isTransactionVerification = ApplicationContextProvider.getContext().getBean(Environment.class).getProperty("checkTransactionVerification");
        boolean checkVerificatin = Boolean.parseBoolean(isTransactionVerification);
        if (checkVerificatin) {
            FinancialMsgEntity verification = financialMsgDao.findVerificationReqByStanAndWorkingDate(reqMsg.getString(ISOConstant.STAN), reqMsg.getString(ISOConstant.PAN));
            if (verification == null) {
                throw new InvalidTransactionException("Transaction is not verified");
            }
        }
    }*/


}
