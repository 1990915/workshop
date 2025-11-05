package com.misc.iso;

import org.jpos.iso.ISOComponent;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOField;
import org.jpos.iso.ISOUtil;
import org.jpos.iso.packager.GenericSubFieldPackager;
import org.jpos.util.LogEvent;
import org.jpos.util.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DataSetIdentifierPackager extends GenericSubFieldPackager {
    public DataSetIdentifierPackager() throws ISOException {
        super();
    }

    @Override
    public int unpack(ISOComponent m, byte[] b) throws ISOException {
        int consumed = 0;
        if (getFirstField() == 2) {
            ISOComponent c = fld[0].createComponent(0);
            consumed += fld[0].unpack(c, b, consumed);
            m.set(c);
        }
        b= Arrays.copyOfRange(b,consumed,b.length);
        return super.unpack(m, b);
    }

    @Override
    public byte[] pack(ISOComponent m) throws ISOException {
        LogEvent evt = new LogEvent (this, "pack");
        try
        {
            ISOComponent c;
            List<byte[]> l = new ArrayList<byte[]>();
            Map fields = m.getChildren();
            int len = 0;

            if (fields.get(0)!=null)
            {
                c = (ISOComponent) fields.get (0);
                byte[] b = fld[0].pack(c);
                len += b.length;
                l.add(b);
            }

            if (emitBitMap())
            {
                // BITMAP (-1 in HashTable)
                c = (ISOComponent) fields.get (-1);
                byte[] b = getBitMapfieldPackager().pack(c);
                len += b.length;
                l.add(b);
            }

            for (int i=getFirstField(); i<=m.getMaxField(); i++)
            {
                c = (ISOComponent) fields.get (i);
                if (c == null && !emitBitMap())
                    c = new ISOField(i, "");
                if (c != null) {
                    try
                    {
                        byte[] b = fld[i].pack(c);
                        len += b.length;
                        l.add(b);
                    }
                    catch (Exception e)
                    {
                        evt.addMessage ("error packing subfield "+i);
                        evt.addMessage (c);
                        evt.addMessage (e);
                        throw e;
                    }
                }
            }
            int k = 0;
            byte[] d = new byte[len];
            for (byte[] b :l) {
                System.arraycopy(b, 0, d, k, b.length);
                k += b.length;
            }
            if (logger != null)  // save a few CPU cycle if no logger available
                evt.addMessage (ISOUtil.hexString (d));
            return d;
        }
        catch (ISOException e)
        {
            evt.addMessage (e);
            throw e;
        }
        catch (Exception e)
        {
            evt.addMessage (e);
            throw new ISOException (e);
        }
        finally
        {
            Logger.log(evt);
        }
    }
}
