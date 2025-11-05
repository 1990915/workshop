package com.misc.iso.db;

import com.misc.constant.ISOConstant;
import com.misc.iso.BaseTransactionParticipantImpl;
import org.jpos.core.Configuration;
import org.jpos.iso.ISOMsg;
import org.jpos.transaction.Context;
import org.jpos.util.LogEvent;
import org.jpos.util.Logger;

import java.io.Serializable;

public class ISOPersistence extends BaseTransactionParticipantImpl {

    private Configuration cfg;

    @Override
    public int prepare(long id, Serializable context) {
        try {

            ISOMsg reqMsg = ((Context) context).get(ISOConstant.REQUEST);
            Long internalRefNo = ((Context) context).get(ISOConstant.INTERNAL_REFERENCE_ID);
            if(internalRefNo==null)
                internalRefNo = id;
            Long orgReferenceId = null;
            if(((Context) context).get(ISOConstant.ORIGINAL_INTERNAL_REFERENCE_ID)!=null)
                orgReferenceId = Long.parseLong(((Context) context).get(ISOConstant.ORIGINAL_INTERNAL_REFERENCE_ID));
            //Long internalRefNo =  id;

            return PREPARED;
        } catch (Exception e) {
            //prepareExceptionResponse(id, (Context) context, e);
            return ABORTED;
        }
    }

    @Override
    public void setConfiguration (Configuration cfg) {
        this.cfg = cfg;
    }


    @Override
    public void commit(long id, Serializable context) {
        try {
            ISOMsg resp = ((Context) context).get(ISOConstant.RESPONSE);
            Boolean isPersist = ((Context) context).remove(ISOConstant.HOST_CHANNEL_REQUEST_PERSIST);
            //SAVE Success Response

            /*if (isPersist != null && isPersist) {
                saveHostChannelResponse(resp, context);
            } else
                throw new InternalErrorException("transaction not persist in nakisa request detail table.");*/

        } catch (Exception e) {
            //prepareExceptionResponse(id, (Context) context, e);
            Logger.log(new LogEvent("NakisaChannelBalanceResponseDetailPersistence-prepare", e));
        }
        super.commit(id, context);
        clearContext((Context)context);
    }

    @Override
    public void abort(long id, Serializable context) {
        ISOMsg resp = ((Context) context).get(ISOConstant.RESPONSE);
        Boolean isPersist = ((Context) context).remove(ISOConstant.HOST_CHANNEL_REQUEST_PERSIST);
        if(isPersist==null || !(isPersist))
            return;
        //SAVE FAILED Response
        /*saveHostChannelResponse(resp,context);*/
        super.abort(id, context);
        clearContext((Context)context);
    }
    private void clearContext(Context context){
        context.remove(ISOConstant.HOST_CHANNEL_REQUEST);
        //context.remove(ISOConstant.INTERNAL_REFERENCE_ID);
        context.remove(ISOConstant.ORIGINAL_INTERNAL_REFERENCE_ID);
    }
}
