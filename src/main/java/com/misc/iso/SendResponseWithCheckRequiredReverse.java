package com.misc.iso;

/*import com.misc.ApplicationContextProvider;
import com.misc.common.iso.ISOConstant;
import com.misc.exceptions.InternalErrorException;
import com.misc.exceptions.NotSuccessfulOriginalTransactionException;
import com.misc.reverse.Reversal;*/
import org.jpos.iso.ISOException;
import org.jpos.transaction.Context;
import java.io.Serializable;


public class SendResponseWithCheckRequiredReverse extends TransactionResponse {

    @Override
    public int prepare(long id, Serializable context) {
        try {
            createReversalTransaction((Context) context);
        } catch (Exception /*| InternalErrorException | NotSuccessfulOriginalTransactionException*/  e) {
            //Logger.log(new LogEvent(EXCEPTION_TAG, e));
        }
        return super.prepare(id, context);
    }
    @Override
    public void abort(long id, Serializable context) {
        try {
            createReversalTransaction((Context) context);
        } catch (Exception /*| InternalErrorException | NotSuccessfulOriginalTransactionException*/  e) {
            //Logger.log(new LogEvent(EXCEPTION_TAG, e));
        }
        super.abort(id, context);
    }
    private void createReversalTransaction(Context context) throws ISOException/*, InternalErrorException, NotSuccessfulOriginalTransactionException*/ {
        /*ISOMsg requestMsg = context.get(ISOConstant.CARDIRAN_REQUEST);
        ISOMsg resp = context.get(ISOConstant.CARDIRAN_RESPONSE);
        Reversal reversal = ApplicationContextProvider.getContext().getBean(Reversal.class);
        if (resp != null && !requestMsg.getMTI().startsWith("24") &&
                requiredReversal.contains(resp.getString(ISOConstant.RESPONSE_CODE))) {
            reversal.checkRequiredReversalCreate(requiredReversal, requestMsg, resp,
                    ISOConstant.ISS_CHANNEL_ID,
                    ISOConstant.ISS_CHANNEL_ID,
                    null);

        }*/
    }
}
