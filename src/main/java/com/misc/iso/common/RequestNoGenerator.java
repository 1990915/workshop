package com.misc.iso.common;

import com.misc.iso.BaseTransactionParticipantImpl;

import java.io.Serializable;


public class RequestNoGenerator extends BaseTransactionParticipantImpl {
    @Override
    public int prepare(long id, Serializable context) {
        //Generate RequestNo, then put into Context
        //super.prepare(id, context);
        //SettingDao settingDao = ApplicationContextProvider.getContext().getBean(SettingDao.class);
        //String requestNo = settingDao.nextRequestNo();
        //((Context)context).put(ISOConstant.NAKISA_REQUSET_NO,Long.parseLong(requestNo));
        return PREPARED | NO_JOIN;
    }
}
