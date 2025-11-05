package com.misc.iso;

import com.misc.constant.ISOConstant;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOSource;
import org.jpos.space.Space;
import org.jpos.transaction.Context;
import org.jpos.transaction.ContextConstants;
import org.jpos.transaction.TransactionManager;
import org.jpos.transaction.participant.SendResponse;
import org.jpos.util.LogEvent;
import org.jpos.util.Logger;

import java.io.Serializable;

public class ResponseSend extends SendResponse {

    protected Space isp;
    public void setTransactionManager(TransactionManager tm) {
        this.isp = tm.getInputSpace();
    }
    @Override
    public int prepare(long id, Serializable context) {
        super.prepare(id,context);
        Context ctx = (Context)context;
        ISOSource isoSource = ctx.get(ContextConstants.SOURCE.toString());
        return isoSource != null && isoSource.isConnected() ? PREPARED | READONLY : FAIL;
    }
    @Override
    public void commit(long id, Serializable context) {
        super.commit(id, context);
        ISOMsg resp = ((Context)context).get(ISOConstant.RESPONSE);
        Logger.log(new LogEvent("SendResponse", resp));
        clearContext((Context)context);
    }
    @Override
    public void abort(long id, Serializable context) {
        ISOMsg resp = ((Context) context).get(ISOConstant.RESPONSE);
        Logger.log(new LogEvent("SendResponse", resp));
        super.abort(id, context);
        clearContext((Context) context);
    }
    private void clearContext(Context context){
        context.remove(ISOConstant.FINANCIAL_REQUEST);
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
        //context.remove(ISOConstant.EXCEPTION_SRC_ID);
        context.remove(ISOConstant.AUTHENTICATION_TYPE);
        context.remove(ISOConstant.ORIGINAL_NAKISA_REQUSET_NO);
    }
}
