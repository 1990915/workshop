package com.misc.iso;

import com.misc.constant.ISOConstant;
import org.jpos.core.Configurable;
import org.jpos.core.Configuration;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISORequestListener;
import org.jpos.iso.ISOSource;
import org.jpos.iso.channel.ASCIIChannel;
import org.jpos.space.Space;
import org.jpos.space.SpaceFactory;
import org.jpos.transaction.Context;
import org.jpos.util.LogEvent;
import org.jpos.util.Logger;

import java.net.InetAddress;

public class ChannelListener implements ISORequestListener, Configurable {

    private String queueName;
    private String destination;
    private Space sp;
    private long timeout;

    public ChannelListener() {
        super();
    }


    public boolean process(ISOSource isoSrc, ISOMsg isoMsg) {
        InetAddress clientIP = ((ASCIIChannel) isoSrc).getSocket().getInetAddress();
        //ISOMsg protectedMsg = null;
        Logger.log(new LogEvent("REQUEST-FROM-YOOZ-WITH-IP:" + clientIP.getHostAddress(), isoMsg));
        Context ctx = new Context();
        ctx.put(ISOConstant.REQUEST, isoMsg);
        ctx.put(ISOConstant.ISOSOURCE, isoSrc);
        ctx.put(ISOConstant.DESTINATION, destination);
        sp.out(queueName, ctx, timeout);
        return true;
    }

    public void setConfiguration(Configuration cfg) {
        queueName = cfg.get("queue");
        destination = cfg.get("ctx.DESTINATION");
        timeout = cfg.getLong("timeout");
        sp = SpaceFactory.getSpace(cfg.get("space"));
    }

}
