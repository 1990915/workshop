package com.misc.iso;

import org.jpos.core.Configuration;
import org.jpos.core.ConfigurationException;
import org.jpos.iso.ISOMsg;
import org.jpos.transaction.Context;
import org.jpos.util.LogEvent;
import org.jpos.util.Logger;

import java.io.Serializable;


public class Monitoring extends BaseTransactionParticipantImpl {

    @Override
    public void setConfiguration(Configuration configuration) throws ConfigurationException {
        //requestInput = configuration.get ("requestInput",ISOConstant.REQUEST);
        //responseInput = configuration.get ("responseInput",ISOConstant.RESPONSE);
        super.setConfiguration(configuration);
    }

    //MetricManager metricManager;
    @Override
    public int prepare(long id, Serializable context) {
        try {
            super.prepare(id,context);
            ISOMsg requestIsoMsg = ((Context) context).get(requestInput);
            /*metricManager = ApplicationContextProvider.getContext().getBean(MetricManager.class);
            metricManager.doRequestMetrics(requestIsoMsg);*/
        } catch (Exception e) {
            e.printStackTrace();
            logException(id,(Context)context,e);
        }
        return PREPARED;
    }


    @Override
    public void commit(long id, Serializable context) {
        doMonitor((Context) context);
    }

    private void doMonitor(Context context) {
        ISOMsg requestIsoMsg = context.get(requestInput);
        ISOMsg responseIsoMsg = context.get(responseInput);
        try {
            if (responseIsoMsg != null) {
                //metricManager.doResponsetMetrics(requestIsoMsg, responseIsoMsg, responseIsoMsg.getString(39));
            }
        } catch (Exception e) {
            e.printStackTrace();
            Logger.log(new LogEvent("Exception", e));
        }
    }

    @Override
    public void abort(long id, Serializable context) {
        doMonitor((Context) context);
    }
}
