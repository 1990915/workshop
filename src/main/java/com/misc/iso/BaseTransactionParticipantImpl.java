package com.misc.iso;

import org.jpos.core.Configurable;
import org.jpos.core.Configuration;
import org.jpos.core.ConfigurationException;
import org.jpos.iso.ISOMsg;
import org.jpos.transaction.AbortParticipant;
import org.jpos.transaction.Context;
import org.jpos.transaction.TransactionParticipant;

import java.io.Serializable;

public class BaseTransactionParticipantImpl extends FinancialTransaction implements TransactionParticipant, AbortParticipant, Configurable {

    @Override
    public int prepare(long id, Serializable context) {
        try {
            ISOMsg reqMsg = ((Context) context).get(getRequestInput());
            /*AdditionalDataRequest additionalDataRequest = ((Context) context).get(ISOConstant.ADDITIONAL_DATA_REQUEST);
            if( additionalDataRequest ==null) {
                additionalDataRequest = Utiles.getAdditionalDataRequestOfJSon(reqMsg.getString(ISOConstant.ADDITIONAL_DATA_NATIONAL));
                ((Context) context).put(ISOConstant.ADDITIONAL_DATA_REQUEST, additionalDataRequest);
            }*/
            /*Long requestId = Long.valueOf(additionalDataRequest.getReferenceNo());

            if( requestId == null ) {
                if (reqMsg.hasField(ISOConstant.REQUEST_ID))
                    requestId = Long.valueOf(reqMsg.getString(ISOConstant.REQUEST_ID));
                else
                    requestId = id;
            }*/
        }catch (Exception e){
            //Logger.log(new LogEvent(EXCEPTION_TAG, e));

            throw e;
        }
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

    public void logException(long id , Context context ,Exception e){
        /*ISOMsg reqMsg = context.get(requestInput);
        Long requestId = context.get(ISOConstant.REQUESTID);
        if(requestId ==null)
            requestId = id;
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter( sw);
        e.printStackTrace(pw);
        Logger.log(new LogEvent(EXCEPTION_TAG,
                MessageFormat.format("RequestID:{0}  Stan:{1} TraceNo:{2} Exception:{3}", requestId, ISOMsgUtil.getStan(reqMsg),
                        reqMsg.getString(ISOConstant.STAN),sw)));*/
    }

    /*protected void saveAbortResponse(long id, Serializable context) throws ISOException {
        try {
            ISOMsg isoMsgRequest = ((Context) context).get(getRequestInput());
            ISOMsg resp = ((Context) context).get(getResponseInput());
            if (resp == null) {

                ISOMsg respMsg = (ISOMsg) isoMsgRequest.clone();
                respMsg.setResponseMTI();
                respMsg.setDirection(ISOMsg.OUTGOING);
                respMsg.set(ISOConstant.RESPONSE_CODE, ResponseCode.WAITING_TIME_FOR_RESPONSE_EXCEPTION.getResponseCodeValue());
                respMsg.unset(ISOConstant.ADDITIONAL_DATA_NATIONAL);
                respMsg.recalcBitMap();

                ((Context) context).put(getResponseInput(), respMsg);
            }
            FinancialMsgEntity financialMsgEntity = prepareResponseEntity(context);
            if (financialMsgEntity != null)
                financialMsgDao.persist(financialMsgEntity);
        } catch (Exception e) {
            logException( id, (Context)context, e );
            throw e;
        }
    }*/
   /* protected void saveCommitResponse(long id, Serializable context) {
        try {
            financialMsgDao.persist(prepareResponseEntity(context));
        } catch (Exception e) {
            logException(id, (Context) context, e);
            throw e;
        }
    }*/

    /*protected void prepareExceptionResponse(long id, Context context, Exception e) {
        try {
            ISOMsg reqMsg = context.get(getRequestInput());
            DataDictionaryEntity resDataEntity = context.get(ISOConstant.RESPONSE_CODE_DD);
            if(resDataEntity!=null)
            {
                ISOMsg respMsg = prepareResponse(reqMsg, resDataEntity.getValue());
                context.put(getResponseInput(), respMsg);
            }else {
                context.put(getResponseInput(), prepareResponse(reqMsg, mapErrorCode(e)));
            }
        } catch (ISOException e1) {
            Logger.log(new LogEvent(EXCEPTION_TAG, e));
        }
        logException(id, context, e);
    }*/

    @Override
    public int prepareForAbort(long id, Serializable context) {
        /*AdditionalDataResponse additionalDataResponse = ((Context)context).get(ISOConstant.ADDITIONAL_DATA_RESPONSE);
        if(additionalDataResponse==null )
            additionalDataResponse = new AdditionalDataResponse();

        String exceptionSrcId = ((Context)context).get(ISOConstant.EXCEPTION_SRC_ID);
        ISOMsg response = ((Context) context).get(ISOConstant.RESPONSE);
        *//*if(exceptionSrcId != null && response!=null)
        {
            //additionalDataResponse.setExceptionSrcId(exceptionSrcId);
            response.set(ISOConstant.ADDITIONAL_DATA_RESPONSE, Utiles.getJSonAdditionalDataResponse(additionalDataResponse));
        }*/
        return PREPARED;
    }

    Configuration cfg;
    @Override
    public void setConfiguration(Configuration configuration) throws ConfigurationException {
        //requestInput = configuration.get ("requestInput",ISOConstant.REQUEST);
        //responseInput = configuration.get ("responseInput",ISOConstant.RESPONSE);
        cfg = configuration;
    }
}
