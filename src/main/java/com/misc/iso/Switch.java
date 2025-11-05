package com.misc.iso;

import com.misc.constant.ISOConstant;
import org.jpos.core.Configurable;
import org.jpos.core.Configuration;
import org.jpos.iso.ISOMsg;
import org.jpos.transaction.Context;
import org.jpos.transaction.GroupSelector;
import org.jpos.util.LogEvent;
import org.jpos.util.Logger;

import java.io.Serializable;

public class Switch implements GroupSelector, Configurable {
    private Configuration cfg;

    @Override
    public int prepare(long id, Serializable context) {
        return PREPARED | READONLY | NO_JOIN;
    }

    @Override
    public String select(long id, Serializable context) {
        String select;
        String selectTransaction;
        try {
            ISOMsg reqMsg = ((Context) context).get(ISOConstant.REQUEST);
            String mti = reqMsg.getString(ISOConstant.MTI);
            String processingCode = reqMsg.getString(ISOConstant.PROCESSING_CODE);
            String functionCode = reqMsg.getString(ISOConstant.FUNCTION_CODE);
            String acqBin = reqMsg.getString(ISOConstant.ACQUIRING_INSTITUTION_IDENTIFICATION_CODE);
            String issuerPan = reqMsg.getString(ISOConstant.PAN).substring(0, 6);
            String originalDataElement = reqMsg.getString(ISOConstant.ORIGINAL_DATA_ELEMENT);

            select = mti.concat("-").concat(processingCode).concat("-").concat(functionCode);
            selectTransaction = cfg.get(select);
            if (selectTransaction != null) {
                ((Context) context).put(ISOConstant.SERVICE_SELECTOR, select);
                return selectTransaction;
            }
            select = select.concat("-").concat(acqBin);
            selectTransaction = cfg.get(select);
            if (selectTransaction != null) {
                ((Context) context).put(ISOConstant.SERVICE_SELECTOR, select);
                return selectTransaction;
            }
            select = select.concat("-").concat(issuerPan);
            selectTransaction = cfg.get(select);
            if (selectTransaction != null) {
                ((Context) context).put(ISOConstant.SERVICE_SELECTOR, select);
                return selectTransaction;
            }

        } catch (Exception e) {
            Logger.log(new LogEvent("Exception", "This transaction not supported by host." + e));
            return null;
        }
        return null;
    }

    public void setConfiguration(Configuration cfg) {
        this.cfg = cfg;
    }
}

