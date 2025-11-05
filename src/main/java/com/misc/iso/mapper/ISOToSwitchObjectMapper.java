package com.misc.iso.mapper;

import com.misc.ApplicationContextProvider;
import com.misc.constant.ISOConstant;
import com.misc.iso.BaseTransactionParticipantImpl;
import com.misc.iso.dto.SwitchIsoMsgDto;
import org.jpos.iso.ISOMsg;
import org.jpos.transaction.Context;

import java.io.Serializable;

public class ISOToSwitchObjectMapper extends BaseTransactionParticipantImpl {

    @Override
    public int prepare(long id, Serializable context) {
        //ISO to Object Mapper, then save into Context
        ISOMsg reqMsg = ((Context) context).get(ISOConstant.REQUEST);
        IsoToObjectMapper isoToObjectMapper = ApplicationContextProvider.getContext().getBean(IsoToObjectMapper.class);
        SwitchIsoMsgDto isoMsgDto = isoToObjectMapper.map(reqMsg);
        ((Context) context).put(ISOConstant.SWITCH_REQUEST, isoMsgDto);
        return PREPARED | NO_JOIN;
    }

    @Override
    public void commit(long id, Serializable context) {
        super.commit(id, context);
    }

    @Override
    public void abort(long id, Serializable context) {
        super.abort(id, context);
    }
}
