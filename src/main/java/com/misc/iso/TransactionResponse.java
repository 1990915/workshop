package com.misc.iso;

/*import com.misc.channel.cardiran.common.CardIranBaseTransactionParticipantImpl;
import com.misc.channel.cardiran.common.ISOMsgLogProtector;
import com.misc.common.enums.ResponseCode;
import com.misc.common.iso.ISOConstant;*/

import com.misc.constant.ISOConstant;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOSource;
import org.jpos.transaction.Context;
import org.jpos.transaction.ContextConstants;
import org.jpos.util.LogEvent;
import org.jpos.util.Logger;

import java.io.Serializable;


public class TransactionResponse extends CardIranBaseTransactionParticipantImpl {
    String tagResponseLog = "RESPONSE-TO-CARDIRAN";

    @Override
    public int prepare(long id, Serializable context) {
        super.prepare(id, context);
        Context ctx = (Context) context;
        ISOSource isoSource = ctx.get(ContextConstants.SOURCE.toString());
        return isoSource != null && isoSource.isConnected() ? PREPARED | READONLY : FAIL;
    }

    @Override
    public void commit(long id, Serializable context) {
        this.sendResponse((Context) context);
        clearContext((Context) context);
    }


    @Override
    public void abort(long id, Serializable context) {
        this.sendResponse((Context) context);
        clearContext((Context) context);
    }

    private void clearContext(Context context) {
        /*context.remove(ISOConstant.FINANCIAL_REQUEST);
        context.remove(ISOConstant.FINANCIAL_RESPONSE);
        context.remove(ISOConstant.PAN_INFO);
        context.remove(ISOConstant.DST_PAN_INFO);
        context.remove(ISOConstant.NAKISA_IBAN_INFO);
        context.remove(ISOConstant.NAKISA_RESULT);
        context.remove(ISOConstant.SERVICE_DETAIL);
        context.remove(ISOConstant.NAKISA_ERROR);
        context.remove(ISOConstant.RESPONSE_CODE_DD);
        context.remove(ISOConstant.ORIGINAL_INTERNAL_REFERENCE_ID);
        context.remove(ISOConstant.ISOSOURCE);
        context.remove(ISOConstant.DESTINATION);
        context.remove("timeout");
        context.remove(ISOConstant.WORKING_DATE);
        context.remove(ISOConstant.NAKISA_REQUSET_NO);
        context.remove(ISOConstant.REVERSAL_REQUIRED);
        context.remove(ISOConstant.ADDITIONAL_AMOUNTS_4BALANCE);
        context.remove(ISOConstant.REQUESTID);
        context.remove(ISOConstant.DESTINATION);
        context.remove(ISOConstant.NAKISA_DEADLINE_TIME);
        context.remove(ISOConstant.ACCOUNT_INFO);*/
    }

    private void sendResponse(Context ctx) {
        ISOSource src = ctx.get(ISOConstant.ISOSOURCE);
        ISOMsg reqMsg = ctx.get(ISOConstant.CARDIRAN_REQUEST);
        //RESPONSE 93
//        ISOMsg protectedReqMsg = ISOMsgLogProtector.protectRequest2003(reqMsg);
        ISOMsg resp = ctx.get(ISOConstant.REQUEST);
        resp.set(ISOConstant.RESPONSE_CODE, "0000");
        try {
            if (ctx.get(ContextConstants.TX.toString()) != null) {
                ctx.log("*** PANIC - TX not null - RESPONSE OMITTED ***");
            } else if (resp == null) {
                ctx.log(ISOConstant.CARDIRAN_RESPONSE + " not present");
                reqMsg.setDirection(ISOMsg.OUTGOING);
                reqMsg.setResponseMTI();
                //reqMsg.set(ISOConstant.RESPONSE_CODE, ResponseCode.INTERNAL_ERROR_EXCEPTION.getResponseCodeValue().substring(1));
                reqMsg.unset(ISOConstant.ADDITIONAL_DATA_NATIONAL);
                reqMsg.recalcBitMap();
                ISOMsg protectedRespMsg = null;
                //ISOMsg protectedRespMsg = ISOMsgLogProtector.protectResponse93(reqMsg);
                ctx.put(ISOConstant.CARDIRAN_RESPONSE, reqMsg);
                src.send(reqMsg);
                Logger.log(new LogEvent(tagResponseLog, protectedRespMsg));
            } else if (src == null) {
                ctx.log(ISOConstant.ISOSOURCE + " not present");
            } else if (!src.isConnected()) {
                ctx.log(ISOConstant.ISOSOURCE + " is no longer connected");
            } else {
                //ISOMsg protectedRespMsg = ISOMsgLogProtector.protectResponse93(resp);
                Logger.log(new LogEvent("RESPONSE-TO-YOOZ", resp));
                src.send(resp);
                //Logger.log(new LogEvent(tagResponseLog, protectedRespMsg));
            }
        } catch (Exception var7) {
            ctx.log(var7);
        } finally {
            //ISOMsg protectedRespMsg = ISOMsgLogProtector.protectResponse93(resp);
            //Logger.log(new LogEvent(tagResponseLog, protectedRespMsg));
        }
    }


}
