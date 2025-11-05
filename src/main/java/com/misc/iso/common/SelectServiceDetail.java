package com.misc.iso.common;


import com.misc.constant.ISOConstant;
import com.misc.iso.BaseTransactionParticipantImpl;
import org.jpos.iso.ISOMsg;
import org.jpos.transaction.Context;

import java.io.Serializable;

public class SelectServiceDetail extends BaseTransactionParticipantImpl {
    @Override
    public int prepare(long id, Serializable context) {
        try {

            //LOAD ServiceDetail, then put into Context
            //super.prepare(id, context);
            /*FinancialMsgRequest financialMsgRequest = ((Context) context).get(ISOConstant.FINANCIAL_REQUEST);
            ISOMsg isoReq = ((Context) context).get(ISOConstant.REQUEST);
            if (financialMsgRequest.getMti().startsWith("28")) {
                ISOMsg isoMsg = ((Context) context).get(ISOConstant.REQUEST);
                financialMsgRequest.setAcquirerId(isoMsg.getString(ISOConstant.TRANSACTION_ORIGINATOR_INSITUATION_IDENTIFICATION_CODE));
            }
            ServiceDetailItemTypeEntity serviceDetailItemTypeEntity = NakisaUtil.fetchServiceDetail(financialMsgRequest, isoReq);*/
            /*if (serviceDetailItemTypeEntity == null)
                throw new InternalErrorException("error: service detail is not in table.");*/
            ((Context) context).put(ISOConstant.SERVICE_DETAIL, "serviceDetailItemTypeEntity");
            return PREPARED | NO_JOIN;
        } catch (Exception e) {
            //prepareExceptionResponse(id, (Context) context, e);
            return ABORTED | NO_JOIN;
        }
    }

    @Override
    public int prepareForAbort(long id, Serializable context) {
        return PREPARED | NO_JOIN;
    }
}
