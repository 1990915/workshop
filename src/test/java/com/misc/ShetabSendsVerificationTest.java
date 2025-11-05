package com.misc;

import com.misc.constant.ISOConstant;
import org.jpos.iso.*;
import org.jpos.iso.channel.ASCIIChannel;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;
import static com.misc.Mock.*;

public class ShetabSendsVerificationTest {

    //private final static String HEADER_TEMPLATE = "0000000000000000000000000000000000000000000000000000000000000";
    //private final static String HEADER_DATA = "0057000080000000006367950000050222912345 1  1 5432112 4560000";
    //private static final String SHETAB_KEY = "1C1C1C1C1C1C1C1C1C1C1C1C1C1C1C1C";

//    CardInfo kishCbiCard = new CardInfo.builder().
//            pan("6367951210619185").
//            pin1("1234").
//            pin2("12345").
//            cvv2("3668").
//            expDate("0610").
//            track2("6367951210619185=04011010837200000000").
//            iban("**").build();
//
//    CardInfo shetabCard = new CardInfo.builder()
//            .pan("5859831150870847")
//            .build();

  /*  shetab.CardInfo kishCbiCard = new shetab.CardInfo.builder().
            pan("6367951210671491").
            pin1("1233").
            pin2("12345").
            cvv2("6298").
            expDate("0601").
            track2("6367951210671491=06011010837200000000").
            iban("**").build();*/

    private static ISOChannel getConnectedChannel(String ip, int port, ISOPackager packager) {
        BaseChannel isoChannel = new ASCIIChannel(ip, port, packager);
        //isoChannel.setHeader(HEADER_TEMPLATE);

        try {
            isoChannel.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (!isoChannel.isConnected()) {
            System.out.println("-------->>>>>>>>>>> Channel is not connected....");
            try {
                isoChannel.connect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return isoChannel;
    }

//    protected static SecurityRelatedControl getSecurityInfo(int index) {
//        SecurityRCInfoDao securityRCInfoDao = new SecurityRCInfoDao();
//        SecurityRcInfo allKeySet = securityRCInfoDao.getSecurityRCInfos(index);
//        return new SecurityRelatedControl(allKeySet);
//    }

   /* private static SecurityRcInfo getSecurityRCInfos(short index, String deviceType) {
        SecurityRcInfo decryptedSecurityRcInfo = new SecurityRcInfo();
        decryptedSecurityRcInfo.setPinKey(SHETAB_KEY);
        decryptedSecurityRcInfo.setCsdKey(SHETAB_KEY);
        decryptedSecurityRcInfo.setMacKey(SHETAB_KEY);
        decryptedSecurityRcInfo.setMasterKey(SHETAB_KEY);
        decryptedSecurityRcInfo.setId(4);
        decryptedSecurityRcInfo.setIndex(index);
        decryptedSecurityRcInfo.setType(deviceType);
        return decryptedSecurityRcInfo;
    }*/

    public ISOMsg createVerificationMsg() throws Exception {
        String stan = Mock.getStan();
        int indicatorIndex = (Integer.parseInt(stan) % 3) + 1;
        String deviceCode = "02";
        String behdadIdentifier = "349000051000000000000000000000";
        /*SecurityRelatedControl securityRelatedControl = getSecurityInfo(indicatorIndex);*/
        String point_of_service_data_code = pointOfServiceDataCodeMap.get("33" + deviceCode + "*");
        ISOMsg isoMsg = new ISOBuilder.builder().
                mti("2100").
                pan("6367951210619185").
                track2("6367951210619185=04011010837200000000").
                processing_code("330000").
                transaction_amount("364" + ISOUtil.zeropad("50", 13)).
                cardholder_billing_amount("364" + ISOUtil.zeropad("50", 13)).
                transmission_date_time(generateDateTimeTransmition()).
                conversion_rate_cardholder_billing("00000001").
                stan(stan).
                data_expiration("0610").
                local_transaction_date_time(generateLocalDateTime()).
                data_capture("0203").
                aquire_country_code("364").
                function_code("113").
                merchant_category_code_business_type("0000").
                point_of_service_data_code(point_of_service_data_code).
                acquiring_institution_identification_code("603769").
                forwarding_institution_identification_code("950001").
                retrieval_reference_number(Mock.getRetrivalReferenceNumber()).
                card_acceptor_terminal_identification("08830302        ").
                card_acceptor_identification_code("    0883       ").
                additional_data_private("      0116" + "5859831150870847" + "30" + behdadIdentifier).
                transaction_codeing("0200000000D00A024E96CE7C72DA4B0DED2DA4B0DED").
                build();
        lastStan = isoMsg.getString(ISOConstant.STAN);
        lastLocalTransactionDateTime = isoMsg.getString(ISOConstant.LOCAL_TRANSACTION_DATE_TIME);
        //isoMsg.setHeader(HEADER_DATA.getBytes());
        return isoMsg;
    }

    @Test
    public void verificationTest() throws Exception {
        ISOMsg msg = createVerificationMsg();
        ISOChannel channel = getConnectedChannel("127.0.0.1", 12261, msg.getPackager());
//        ISOChannel channel = getConnectedChannel("172.31.65.105", 12261, msg.getPackager());
        //ISOChannel channel = getConnectedChannel("192.168.50.205", 12261, msg.getPackager());

        try {
            msg.dump(System.out, "req ---> ");
            msg.pack();
            channel.send(msg);
            ISOMsg respMsg = channel.receive();
            respMsg.dump(System.out, "resp--->");
            Assert.assertEquals("0000", respMsg.getString(ISOConstant.RESPONSE_CODE));
        } catch (ISOException | IOException e) {
            e.printStackTrace();
        }
    }

}
