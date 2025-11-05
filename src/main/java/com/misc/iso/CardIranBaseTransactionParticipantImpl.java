package com.misc.iso;

/*import com.misc.ApplicationContextProvider;
import com.misc.common.enums.ResponseCode;
import com.misc.common.iso.AdditionalDataRequest;
import com.misc.common.iso.ISOConstant;
import com.misc.entity.entities.entity.DataDictionaryEntity;
import com.misc.entity.entities.entity.FinancialMsgEntity;
import com.misc.exceptions.InternalErrorException;
import com.misc.utils.ISOMsgUtil;
import com.misc.utils.Utiles;*/
import org.jpos.core.Configurable;
import org.jpos.core.Configuration;
import org.jpos.core.ConfigurationException;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.transaction.AbortParticipant;
import org.jpos.transaction.Context;
import org.jpos.transaction.TransactionParticipant;
import org.jpos.util.LogEvent;
import org.jpos.util.Logger;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.text.MessageFormat;
import java.util.Objects;

//import static com.misc.common.iso.ISOConstant.EXCEPTION_TAG;

public class CardIranBaseTransactionParticipantImpl extends FinancialTransaction implements TransactionParticipant, AbortParticipant, Configurable {
    private static final String CARD_IRAN_KEY_TYPE = "02";
    protected Configuration cfg;

    @Override
    public String getRequestInput() {
        return null;
        //return ISOConstant.CARDIRAN_REQUEST;
    }
    @Override
    public String getResponseInput() {
        return null;
        //return ISOConstant.RESPONSE;
    }
    /*private static short indicatorIndex(ISOMsg isoMsg) throws Exception {
        if (isoMsg.getString(ISOConstant.MTI).startsWith("11") ||
                isoMsg.getString(ISOConstant.MTI).startsWith("12") ||
                isoMsg.getString(ISOConstant.MTI).startsWith("14")) {
            ISOTransformer.P53 p53 = ISOTransformer.getP53Field(isoMsg);
            return (short) (Integer.parseInt(p53.getP4NumberOfIndexUsedInKeySetOnTransaction()) + 1);
        } else {
            return 1;
        }
    }*/

    /*public static ChannelSecurityInfo getSecurityInfo(ISOMsg isoMsg){
        if (ApplicationContextProvider.getContext() != null) {
            try {
                ISOTransformer isoTransformer = ApplicationContextProvider.getContext().getBean(ISOTransformer.class);
                return isoTransformer.getChannelSecurityInfo(isoMsg);
            } catch (InternalErrorException exception) {
                    exception.printStackTrace();
                    Logger.log(new LogEvent(EXCEPTION_TAG, exception));
            }
        }
        return new ChannelSecurityInfo();
    }*/

    @Override
    public int prepare(long id, Serializable context) {
       /* try {
            ISOMsg reqMsg = ((Context) context).get(getRequestInput());
            AdditionalDataRequest additionalDataRequest = ((Context) context).get(ISOConstant.ADDITIONAL_DATA_REQUEST);
            if (additionalDataRequest == null) {
                additionalDataRequest = Utiles.getAdditionalDataRequestOfJSon(reqMsg.getString(ISOConstant.ADDITIONAL_DATA_NATIONAL));
                ((Context) context).put(ISOConstant.ADDITIONAL_DATA_REQUEST, additionalDataRequest);
            }

            Long requestId = Objects.nonNull(additionalDataRequest) ? Long.valueOf(additionalDataRequest.getReferenceNo()) : null;
            if (requestId == null) {
                if (reqMsg.hasField(ISOConstant.REQUEST_ID))
                    requestId = Long.valueOf(reqMsg.getString(ISOConstant.REQUEST_ID));
                else
                    requestId = id;
            }
            Logger.log(new LogEvent(Thread.currentThread().getStackTrace()[2].getClassName(),
                    MessageFormat.format("referenceId:{0}  Stan:{1} TraceNo:{2}", requestId, ISOMsgUtil.getStan(reqMsg), reqMsg.getString(ISOConstant.STAN))));
        } catch (Exception e) {
            Logger.log(new LogEvent(EXCEPTION_TAG, e));

            throw e;
        }*/
        return PREPARED;
    }

    @Override
    public void commit(long id, Serializable context) {
//
    }

    @Override
    public void abort(long id, Serializable context) {
//
    }

    public void logException(long id, Context context, Exception e) {
        ISOMsg reqMsg = context.get(getRequestInput());
        Long requestId = null;
        if (requestId == null)
            requestId = id;
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
       /* Logger.log(new LogEvent(EXCEPTION_TAG,
                MessageFormat.format("RequestID:{0}  Stan:{1} TraceNo:{2} Exception:{3}", requestId, ISOMsgUtil.getStan(reqMsg),
                        reqMsg.getString(ISOConstant.STAN), sw)));*/
    }

    protected void saveAbortResponse(long id, Serializable context) throws ISOException {
        try {
            ISOMsg isoMsgRequest = ((Context) context).get(getRequestInput());
            ISOMsg resp = ((Context) context).get(getResponseInput());
            if (resp == null) {

                ISOMsg respMsg = (ISOMsg) isoMsgRequest.clone();
                respMsg.setResponseMTI();
                respMsg.setDirection(ISOMsg.OUTGOING);
                //respMsg.set(ISOConstant.RESPONSE_CODE, ResponseCode.WAITING_TIME_FOR_RESPONSE_EXCEPTION.getResponseCodeValue());
                //respMsg.unset(ISOConstant.ADDITIONAL_DATA_NATIONAL);
                respMsg.recalcBitMap();

                ((Context) context).put(getResponseInput(), respMsg);
            }
            /*FinancialMsgEntity financialMsgEntity = prepareResponseEntity(context);
            if (financialMsgEntity != null)
                financialMsgDao.persist(financialMsgEntity);*/
        } catch (Exception e) {
            logException(id, (Context) context, e);
            throw e;
        }
    }

    protected void saveCommitResponse(long id, Serializable context) {
        try {
            //financialMsgDao.persist(prepareResponseEntity(context));
        } catch (Exception e) {
            logException(id, (Context) context, e);
            throw e;
        }
    }

    protected void prepareExceptionResponse(long id, Context context, Exception e) {
        try {
            ISOMsg reqMsg = context.get(getRequestInput());
            //DataDictionaryEntity resDataEntity = context.get(ISOConstant.RESPONSE_CODE_DD);
            if (true) {
            //if (resDataEntity != null) {
                ISOMsg respMsg = null;
                //ISOMsg respMsg = prepareResponse(reqMsg, resDataEntity.getValue());
                context.put(getResponseInput(), respMsg);
            } else {
                //context.put(ISOConstant.CARDIRAN_RESPONSE, prepareResponse(reqMsg, mapErrorCode(e)));
            }
        } catch (Exception e1) {
            //Logger.log(new LogEvent(EXCEPTION_TAG, e));
        }
        logException(id, context, e);
    }

    @Override
    public void setConfiguration(Configuration configuration) throws ConfigurationException {
        //requestInput = configuration.get("requestInput", ISOConstant.REQUEST);
        //responseInput = configuration.get("responseInput", ISOConstant.RESPONSE);
        cfg = configuration;
    }

    @Override
    public int prepareForAbort(long id, Serializable context) {
        return PREPARED;
    }

    protected ISOMsg prepareResponse(ISOMsg requestMsg, String responseCode) throws ISOException {
        return prepareResponse(requestMsg, null,
                /*CardIRANResponseCodeMapping.mapResponseCode2003To93(responseCode)*/null);
    }

    protected ISOMsg prepareResponse(ISOMsg requestMsg, String accountNumber, String responseCode) throws ISOException {
        /*if (ApplicationContextProvider.getContext() != null) {
            return ISOTransformer.prepareResponse(requestMsg, null, responseCode);

        }*/
        return null;
    }
}
