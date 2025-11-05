package com.misc.iso.mapper;

import com.misc.iso.dto.SwitchIsoMsgDto;
import org.jpos.iso.ISOMsg;

public interface IsoToObjectMapper {
    SwitchIsoMsgDto map(ISOMsg isoMsg);
}
