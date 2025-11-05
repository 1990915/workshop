package com.misc;

/*import com.misc.SecurityRelatedControl;
import com.misc.common.iso.AdditionalDataRequest;
import com.misc.common.iso.ISOBuilder;
import com.misc.entity.entities.Device;
import com.misc.entity.entities.entity.CardAcceptorInfo;
import com.misc.entity.entities.entity.SecurityRcInfo;
import com.misc.utils.IranSystemUtil;
import com.misc.utils.SecurityUtil;
import com.misc.utils.StringUtil;
import com.misc.utils.Utiles;
import dao.SecurityRCInfoDao;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOUtil;
import org.jpos.iso.packager.GenericPackager;*/
import org.jpos.security.jceadapter.JCEHandlerException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Mock {

    private static final String terminalId = "20011001";
    //    protected static String acquirerBin = "636795";
//    protected static String acquirerBin = "950001";

//        protected static String toPan = "6274121158400440";  //eghtesad Novin
//        protected static String toPan = "6369491009842389";  // new
//    protected static String toPan = "5054161008216024";  //GARD
//    protected static String toPan = "5054166200000910";  //credit gardeshgari
//    protected static String toPan = "6367951022955346";  //CBI
//    protected static String toPan = "6369491009842389";  //hekmat
//    protected static String toPan = "6367957016837986";  //CBI Virtual Kish
//    protected static String toPan = "6367957007989549";  //CBI Virtual 192.168.0.62


    //---------------------------------192.168.50.205 ----------------
//    protected static String pan = "6367951022955338";   //KISH
//    protected static String pin1 = "1878";
    //    protected static String pin1 = "112233";
//    protected static String expireDate = "0306";
//    protected static String cvv2 = "4288";
//    static String track2 = "51022955338=03061108884200000000";
//    protected static String iban = "IR270100008000100000624735";


    //---------------------------------new shetab test 1----------------
//    protected static String pan = "6274121174298356";
//    protected static String pin1 = "5963";
//        //protected static String pin1 = "63222";
//    protected static String expireDate = "0310";
//    protected static String cvv2 = "9804";
//    static String track2 = "21174298356F20011009740754981705";
////    protected static String iban = "IR020650020280201000211001";


    //---------------------------------new shetab test 2----------------
//    protected static String pan = "6274121158400440";
//    protected static String pin1 = "1358";
////    protected static String pin1 = "13589";
//    protected static String expireDate = "9902";
//    protected static String cvv2 = "9804";
//    static String track2 = "21174298356F20011009740754981705";
//    protected static String iban = "IR940550021485002517846001";


    //---------------------------------new shetab test 3----------------
//    protected static String pan = "6369491009842389";
//    protected static String pin1 = "1358";
////    protected static String pin1 = "13589";
//    protected static String expireDate = "9905";
//    protected static String cvv2 = "412";
//    static String track2 = "21174298356F20011009740754981705";
//    protected static String iban = "IR130650120580201567276001";


    //---------------------------------CBI 1  Local----------------
//    protected static String pan = "6367951008123992";
//    protected static String pin1 = "1111";
//    //    protected static String pin1 = "112233";
//    protected static String expireDate = "0310";
//    protected static String cvv2 = "1527";
//    static String track2 = "51022955338=03061108884200000000";
//    protected static String iban = "IR270100008000100000624735";

    //---------------------------------CBI 1  Local----------------
//    protected static String pan = "6367951008127019";
//    protected static String pin1 = "1234";
////        protected static String pin1 = "112233";
//    protected static String expireDate = "0209";
//    protected static String cvv2 = "6681";
//    static String track2 = "51022955338=03061108884200000000";
//    protected static String iban = "IR270100008000100000624735";

    //----------------------------------CBI 2 ----------------
//    protected static String pan = "6367951022955346";
//    protected static String pin1 = "2222";
//    protected static String expireDate = "0306";
//    protected static String cvv2 = "9470";
//    static String track2 = "51022955346F03061102399200000000";
//    protected static String iban = "IR920100008000100000654120";


//    protected static String pan = "6367951011306337";
//    protected static String pin1 = "1234";
////            protected static String pin1 = "112233";
//    protected static String expireDate = "0402";
//    protected static String cvv2 = "1527";
//    static String track2 = "51022955338=03061108884200000000";
//    protected static String iban = "IR270100008000100000624735";
//    protected static String toPan = "5022296510139434";


    //-----------------------------------HEK 1----------------
//    protected static String pan = "6369491009842389";  //hekmat
//    protected static String pin1 = "1358";
//    protected static String expireDate = "9812";
//    protected static String cvv2 = "5261";
//    static String track2 = "91000000003F98061014088000000000";
//    protected static String iban = "IR130650120580201567276001";


    //-----------------------------------GARD 1-----------------------------
//    protected static String pan = "5054161008216024";
//    protected static String expireDate = "0011";
//    protected static String cvv2 = "834";
//    static String track2 = "61008216024F00111207406238889376";
//    protected static String iban = "IR920640151170000577367001";
//    protected static String pin1 = "135891358900";
//    protected static String pin1 = "3662"; //first


    //-----------------------------------GARD 2-----------------------------
//    protected static String pan = "5054161700000049";
//    protected static String pin1 = "9898";
//    protected static String expireDate = "0009";
//    protected static String cvv2 = "123";
//    static String track2 = "61080111220F98081208259149763883";
//    protected static String iban = "IR020640011009000001202001";


    //---------------HEC CRD----------------
//    protected static String pan = "6369496600000048";
//    protected static String pin1 = "1358";
//    protected static String expireDate = "9905";
//    protected static String cvv2 = "289";
//    static String  track2 = "96600000048F20081002891979745815";


    //-----------------------------------GARD CRD---------------------------
//    protected static String pan = "5054166200000910";
////    protected static String pin1 = "8883";
//    protected static String pin1 = "37647";
//    protected static String expireDate = "0408";
//    protected static String cvv2 = "203";
//    protected static String track2 = "66200000910F98081206430100000000";
//    protected static String iban = null;

//----------------------------10.101.8.141-------------------------------
//    protected static String pan = "6367951011306337";
////    protected static String pin1 = "1234";
//            protected static String pin1 = "112233";
//    protected static String expireDate = "0402";
//    protected static String cvv2 = "9351";
//    static String track2 = "51022955338=03061108884200000000";
//    protected static String iban = "IR270100008000100000624735";
//    protected static String toPan = "6362141100000000";
////    protected static String toPan = "6367951011306352";


    //    protected static String device;
    protected static String language = "00";


//    static {
//        try {
//            device = Device.INT.getISOCode();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


   /* static {
        Map<String, Card> cardMap = new HashMap<>();
    }
*/

    public static String lastStan = "000000000001";
    protected static String lastRefrencialNumber = "000000000001";
    public static String lastLocalTransactionDateTime = "00000000000001";
    //    protected static String acquirerBin = "603769";
    protected static String dateTimeTransmition = "0000000001";
    protected static String amount = "3640000000020006";
    protected static String CSDKey = "1C1C1C1C1C1C1C1C1C1C1C1C1C1C1C1C1C1C1C1C1C1C1C1C";
    protected static String CSDAlg = "DESede";
    //    protected static String iban = "IR350190000000110139042003";  //6367951007160045
//    protected static String iban = "IR780100008000100000370065";  //6367951003370069
//    protected static String iban = "IR420100001000000000020669";

//    protected static String iban = null;


    protected static String generateDateCapture() {
        return new SimpleDateFormat("MMdd").format(new Date());
    }

    protected static String generateSettlementDate() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date());
    }

    public static String generateLocalDateTime() {
        String localDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        try {
            String fileName = getStanProperties();
            InputStream input = new FileInputStream(fileName);
            Properties prop = new Properties();
            prop.load(input);
            OutputStream output = new FileOutputStream(fileName);
            prop.setProperty("transaction.date", localDate);
            prop.store(output, null);
        } catch (Exception io) {
            io.printStackTrace();
        }
        return localDate;
    }

    public static String generateDateTimeTransmition() {
        dateTimeTransmition = new SimpleDateFormat("MMddHHmmss").format(new Date());
        return dateTimeTransmition;
    }

    public static String getStan() {
        String stan = "000000000000";
        try {
            String fileName = getStanProperties();
            InputStream input = new FileInputStream(fileName);
            Properties prop = new Properties();
            prop.load(input);
            stan = prop.getProperty("stan.value");
            OutputStream output = new FileOutputStream(fileName);
            prop.setProperty("stan.value", String.valueOf(Long.parseLong(stan) + 1));
            prop.store(output, null);
            output.flush();
            output.close();
        } catch (Exception io) {
            io.printStackTrace();
        }
        return String.format("%12s", stan).replace(' ', '0');
    }
    public static String getStan2824() {
        String stan = "000000000000";
        try {
            String fileName = getStanProperties();
            InputStream input = new FileInputStream(fileName);
            Properties prop = new Properties();
            prop.load(input);
            stan = prop.getProperty("stan.value");
        } catch (Exception io) {
            io.printStackTrace();
        }
        return String.format("%12s", stan).replace(' ', '0');
    }
    private static String getStanProperties() throws URISyntaxException {
        URL resource = Mock.class.getResource("/stan.properties");
        return new File(resource.toURI()).getAbsolutePath();
    }

    public static String getlastStan() {
        String stan = "000000000000";
        try {
            String fileName = getStanProperties();
            InputStream input = new FileInputStream(fileName);
            Properties prop = new Properties();
            prop.load(input);
            stan = prop.getProperty("stan.value");
        } catch (IOException | URISyntaxException io) {
            io.printStackTrace();
        }
        return "00000" + stan;
    }

    public static String getLastLocalTransactionDateTime() {

        try {
            String fileName = getStanProperties();
            InputStream input = new FileInputStream(fileName);
            Properties prop = new Properties();
            prop.load(input);
            return prop.getProperty("transaction.date");
        } catch (IOException | URISyntaxException io) {
            io.printStackTrace();
        }
        return null;
    }

    public static String getRetrivalReferenceNumber() {
        DecimalFormat df = new DecimalFormat("#");
        Double stan = Double.valueOf(Math.ceil(100000 + Math.random() * 899999));
        return "100000" + df.format(stan);
    }

    private static final int deadLineTime = 500000;
   /* public static String getAdditionalDataRequest() {
        AdditionalDataRequest additionalDataRequest = new AdditionalDataRequest();
        additionalDataRequest.setDeadLine(Utiles.getDeadLineDuration(deadLineTime));
        return Utiles.getJSonAdditionalDataRequest(additionalDataRequest);
    }


    protected static ISOMsg createReqMsg(byte[] request) throws ISOException {
        ISOMsg isoMsg = new ISOMsg();
        isoMsg.setPackager(new GenericPackager("cfg/iso2003AsciiPackager.xml"));

        isoMsg.unpack(request);
        if (isoMsg.getMaxField() > 64)
            isoMsg.set(128, SecurityUtil.createMac(isoMsg));
        else
            isoMsg.set(64, SecurityUtil.createMac(isoMsg));
        return isoMsg;
    }*/

    /*public static ISOBuilder.builder getISOBuilder(String device, String acquirerBin, CardInfo cardInfo, String stan) throws Exception {
        CardAcceptorInfo cardAcceptorInfo = getCardAcceptorInfo(language);
        long indicatorIndex = (Long.parseLong(stan) % 3) + 1;
        return new ISOBuilder.builder(getSecurityInfo((int) indicatorIndex)).
                pan(cardInfo.getPan()).
                transaction_amount(amount).
                transmission_date_time(generateDateTimeTransmition()).
                stan(stan).
                local_transaction_date_time(generateLocalDateTime()).
                data_capture(generateDateCapture()).
                aquire_country_code("364").
                merchant_category_code_business_type("6012").
                point_of_service_capability(pointOfServiceCapabilityMap.get(device)).
                acquiring_institution_identification_code(acquirerBin).
                retrieval_reference_number(getRetrivalReferenceNumber()).
                card_acceptor_terminal_identification(String.format("%-16s", terminalId)).
                card_acceptor_identification_code("48713326").
                card_acceptor_name_location(cardAcceptorInfo).
                additional_data_private("      " + language).
                pin_data(device.startsWith("59") || device.startsWith("07") || device.startsWith("05") ? cardInfo.getPin2() : cardInfo.getPin1()).
                securityRelatedControlInfo("0202010" + indicatorIndex + "02").
                transaction_codeing(device + "00000000" + getTransactionSupplementaryData(Device.translateISOCode(device)));
    }*/

    private static CardAcceptorInfo getCardAcceptorInfo(String code) {

        CardAcceptorInfo cardAcceptorInfo = new CardAcceptorInfo();
        if (code.equalsIgnoreCase("01")) {
            cardAcceptorInfo.setName("Modern ISC CO".getBytes());
            cardAcceptorInfo.setCity("TEHRAN       ".getBytes());
            cardAcceptorInfo.setStateTypeCode("THR");
            cardAcceptorInfo.setCountryTypeCode("IRN");
            cardAcceptorInfo.setCityCode("108012");
            cardAcceptorInfo.setPhoneNumber("     02142712850");
            cardAcceptorInfo.setEmailAddress("s_salehi@modernisc.com");
            cardAcceptorInfo.setUrlAddress("wwww.modernisc.com");
            cardAcceptorInfo.setPostalCode("1234567890");

        } else {
            //cardAcceptorInfo.setName(IranSystemUtil.fromString("سامان"));
            //cardAcceptorInfo.setCity(IranSystemUtil.fromString("تهران"));
            cardAcceptorInfo.setStateTypeCode("THR");
            cardAcceptorInfo.setCountryTypeCode("IRN");
            cardAcceptorInfo.setCityCode("108012");
            cardAcceptorInfo.setPhoneNumber("     02142712850");
            cardAcceptorInfo.setEmailAddress("s_salehi@modernisc.com");
            cardAcceptorInfo.setUrlAddress("wwww.modernisc.com");
            cardAcceptorInfo.setPostalCode("1234567890");
        }

        return cardAcceptorInfo;
    }

   /* protected static SecurityRelatedControl getSecurityInfo(int index) {
        SecurityRCInfoDao securityRCInfoDao = new SecurityRCInfoDao();
        SecurityRcInfo allKeySet = securityRCInfoDao.getSecurityRCInfos(index);
        return new SecurityRelatedControl(allKeySet);
    }*/

   /* protected static String getTransactionSupplementaryData(Device device) {
        if (device == Device.VRU) {
            return "016" + "00" + "12009842712850" + "0000";
        } else if (device == Device.MOB) {
            return "032" + "14192.168.50.205" + "1400989354165439" + "0000";
        } else if (device == Device.POS) {
            return "030" + "14192.168.50.205" + "12009842712850" + "0000";
        } else if (device == Device.INT) {
            return "020" + "14192.168.50.205" + "00" + "0000";
        } else {
            return "00400000000";
        }
    }*/


    public static Map<String, String> pointOfServiceDataCodeMap = new HashMap<>();

    static {
        pointOfServiceDataCodeMap.put("0002*", "FFFFFFFFFFFFFFFF0040000044400000");
        pointOfServiceDataCodeMap.put("0102*", "08000000100000000040000044400000");
        pointOfServiceDataCodeMap.put("1302d", "08000000100000000040000044400000");
        pointOfServiceDataCodeMap.put("2002*", "FFFFFFFFFFFFFFFF0040000044400000");
        pointOfServiceDataCodeMap.put("2702d", "FFFFFFFFFFFFFFFF0040000044400000");
        pointOfServiceDataCodeMap.put("2802d", "20000000400000000040000044400000");
        pointOfServiceDataCodeMap.put("3102*", "08000000100000000040000044400000");
        pointOfServiceDataCodeMap.put("3302*", "20000000400000000040000044400000");
        pointOfServiceDataCodeMap.put("3402*", "08000000100000000040000044400000");
        pointOfServiceDataCodeMap.put("4002*", "08000000100000000040000044400000");
        pointOfServiceDataCodeMap.put("4K02*", "08000000100000000040000044400000");
        pointOfServiceDataCodeMap.put("4L02*", "20000000400000000040000044400000");
        pointOfServiceDataCodeMap.put("5002*", "08000000100000000040000044400000");
        pointOfServiceDataCodeMap.put("6002d", "08000000100000000040000044400000");
        pointOfServiceDataCodeMap.put("7102*", "08000000100000000040000044400000");
        pointOfServiceDataCodeMap.put("9002*", "FFFFFFFFFFFFFFFF0040000044400000");

        pointOfServiceDataCodeMap.put("0014*", "08000000100000004000000044400000");
        pointOfServiceDataCodeMap.put("0114*", "FFFFFFFFFFFFFFFF4000000044400000");
        pointOfServiceDataCodeMap.put("1314d", "08000000100000004000000044400000");
        pointOfServiceDataCodeMap.put("2014*", "08000000100000004000000044400000");
        pointOfServiceDataCodeMap.put("2714d", "20000000400000004000000044400000");
        pointOfServiceDataCodeMap.put("2814d", "20000000400000004000000044400000");
        pointOfServiceDataCodeMap.put("3114*", "08000000100000004000000044400000");
        pointOfServiceDataCodeMap.put("3314*", "20000000400000004000000044400000");
        pointOfServiceDataCodeMap.put("3414*", "08000000100000004000000044400000");
        pointOfServiceDataCodeMap.put("4014*", "FFFFFFFFFFFFFFFF4000000044400000");
        pointOfServiceDataCodeMap.put("4K14*", "FFFFFFFFFFFFFFFF4000000044400000");
        pointOfServiceDataCodeMap.put("4L14*", "FFFFFFFFFFFFFFFF4000000044400000");
        pointOfServiceDataCodeMap.put("5014*", "08000000100000004000000044400000");
        pointOfServiceDataCodeMap.put("6014d", "08000000100000004000000044400000");
        pointOfServiceDataCodeMap.put("7114*", "08000000100000004000000044400000");
        pointOfServiceDataCodeMap.put("9014*", "FFFFFFFFFFFFFFFF4000000044400000");

        pointOfServiceDataCodeMap.put("0003*", "FFFFFFFFFFFFFFFF4000000044400000");
        pointOfServiceDataCodeMap.put("0103*", "08000000108000004000000044400000");
        pointOfServiceDataCodeMap.put("1303d", "08000000108000004000000044400000");
        pointOfServiceDataCodeMap.put("2003*", "FFFFFFFFFFFFFFFF4000000044400000");
        pointOfServiceDataCodeMap.put("2703d", "FFFFFFFFFFFFFFFF4000000044400000");
        pointOfServiceDataCodeMap.put("2803d", "20000000108000004000000044400000");
        pointOfServiceDataCodeMap.put("3103*", "08000000108000004000000044400000");
        pointOfServiceDataCodeMap.put("3303*", "20000000400000004000000044400000");
        pointOfServiceDataCodeMap.put("3403*", "08000000108000004000000044400000");
        pointOfServiceDataCodeMap.put("4003*", "08000000108000004000000044400000");
        pointOfServiceDataCodeMap.put("4K03*", "08000000108000004000000044400000");
        pointOfServiceDataCodeMap.put("4L03*", "20000000400000004000000044400000");
        pointOfServiceDataCodeMap.put("5003*", "08000000108000004000000044400000");
        pointOfServiceDataCodeMap.put("6003d", "08000000108000004000000044400000");
        pointOfServiceDataCodeMap.put("7103*", "08000000108000004000000044400000");
        pointOfServiceDataCodeMap.put("9003*", "FFFFFFFFFFFFFFFF4000000044400000");


        pointOfServiceDataCodeMap.put("0043*", "08000000100000000080000044400000");
        pointOfServiceDataCodeMap.put("0143*", "FFFFFFFFFFFFFFFF0080000044400000");
        pointOfServiceDataCodeMap.put("1343d", "08000000100000000080000044400000");
        pointOfServiceDataCodeMap.put("2043*", "08000000100000000080000044400000");
        pointOfServiceDataCodeMap.put("2743d", "20000000400000000080000044400000");
        pointOfServiceDataCodeMap.put("2843d", "20000000400000000080000044400000");
        pointOfServiceDataCodeMap.put("3143*", "08000000100000000080000044400000");
        pointOfServiceDataCodeMap.put("3343*", "20000000400000000080000044400000");
        pointOfServiceDataCodeMap.put("3443*", "08000000100000000080000044400000");
        pointOfServiceDataCodeMap.put("4043*", "08000000100000000080000044400000");
        pointOfServiceDataCodeMap.put("4K43*", "08000000102000000080000044400000");
        pointOfServiceDataCodeMap.put("4L43*", "20000000400000000080000044400000");
        pointOfServiceDataCodeMap.put("5043*", "08000000100000000080000044400000");
        pointOfServiceDataCodeMap.put("6043d", "08000000100000000080000044400000");
        pointOfServiceDataCodeMap.put("7143*", "08000000100000000080000044400000");
        pointOfServiceDataCodeMap.put("9043*", "FFFFFFFFFFFFFFFF0080000044400000");

        pointOfServiceDataCodeMap.put("0007*", "FFFFFFFFFFFFFFFF1000000020000000");
        pointOfServiceDataCodeMap.put("0107*", "FFFFFFFFFFFFFFFF1000000020000000");
        pointOfServiceDataCodeMap.put("1307d", "FFFFFFFFFFFFFFFF1000000020000000");
        pointOfServiceDataCodeMap.put("2007*", "FFFFFFFFFFFFFFFF1000000020000000");
        pointOfServiceDataCodeMap.put("2707d", "FFFFFFFFFFFFFFFF1000000020000000");
        pointOfServiceDataCodeMap.put("2807d", "FFFFFFFFFFFFFFFF1000000020000000");
        pointOfServiceDataCodeMap.put("3107*", "FFFFFFFFFFFFFFFF1000000020000000");
        pointOfServiceDataCodeMap.put("3307*", "FFFFFFFFFFFFFFFF1000000020000000");
        pointOfServiceDataCodeMap.put("3407*", "FFFFFFFFFFFFFFFF1000000020000000");
        pointOfServiceDataCodeMap.put("4007*", "FFFFFFFFFFFFFFFF1000000020000000");
        pointOfServiceDataCodeMap.put("4K07*", "FFFFFFFFFFFFFFFF1000000020000000");
        pointOfServiceDataCodeMap.put("4L07*", "FFFFFFFFFFFFFFFF1000000020000000");
        pointOfServiceDataCodeMap.put("5007*", "20000000100000001000000020000000");
        pointOfServiceDataCodeMap.put("6007d", "FFFFFFFFFFFFFFFF1000000020000000");
        pointOfServiceDataCodeMap.put("7107*", "20000000100000001000000020000000");
        pointOfServiceDataCodeMap.put("9007*", "FFFFFFFFFFFFFFFF1000000020000000");

        pointOfServiceDataCodeMap.put("0005*", "20000000100000000400000024800000");
        pointOfServiceDataCodeMap.put("0105*", "FFFFFFFFFFFFFFFF0400000024800000");
        pointOfServiceDataCodeMap.put("1305d", "FFFFFFFFFFFFFFFF0400000024800000");
        pointOfServiceDataCodeMap.put("2005*", "20000000100000000400000024800000");
        pointOfServiceDataCodeMap.put("2775d", "20000000400000000400000024800000");
        pointOfServiceDataCodeMap.put("2805d", "20000000400000000400000024800000");
        pointOfServiceDataCodeMap.put("3105*", "FFFFFFFFFFFFFFFF0400000024800000");
        pointOfServiceDataCodeMap.put("3305*", "20000000400000000400000024800000");
        pointOfServiceDataCodeMap.put("3405*", "FFFFFFFFFFFFFFFF0400000024800000");
        pointOfServiceDataCodeMap.put("4005*", "FFFFFFFFFFFFFFFF0400000024800000");
        pointOfServiceDataCodeMap.put("4K05*", "FFFFFFFFFFFFFFFF0400000024800000");
        pointOfServiceDataCodeMap.put("4L05*", "20000000400000000400000024800000");
        pointOfServiceDataCodeMap.put("5005*", "20000000100000000400000024800000");
        pointOfServiceDataCodeMap.put("6005d", "FFFFFFFFFFFFFFFF0400000024800000");
        pointOfServiceDataCodeMap.put("7105*", "20000000100000000400000024800000");
        pointOfServiceDataCodeMap.put("9005*", "FFFFFFFFFFFFFFFF0400000024800000");

        pointOfServiceDataCodeMap.put("0059*", "20000000100000000800000024800000");
        pointOfServiceDataCodeMap.put("0159*", "FFFFFFFFFFFFFFFF0800000024800000");
        pointOfServiceDataCodeMap.put("1359d", "FFFFFFFFFFFFFFFF0800000024800000");
        pointOfServiceDataCodeMap.put("2059*", "20000000100000000800000024800000");
        pointOfServiceDataCodeMap.put("2759d", "20000000400000000800000024800000");
        pointOfServiceDataCodeMap.put("2859d", "20000000400000000800000024800000");
        pointOfServiceDataCodeMap.put("3159*", "FFFFFFFFFFFFFFFF0800000024800000");
        pointOfServiceDataCodeMap.put("3359*", "20000000400000000800000024800000");
        pointOfServiceDataCodeMap.put("3459*", "FFFFFFFFFFFFFFFF0800000024800000");
        pointOfServiceDataCodeMap.put("4059*", "FFFFFFFFFFFFFFFF0800000024800000");
        pointOfServiceDataCodeMap.put("4K59*", "FFFFFFFFFFFFFFFF0800000024800000");
        pointOfServiceDataCodeMap.put("4L59*", "20000000400000000800000024800000");
        pointOfServiceDataCodeMap.put("5059*", "20000000100000000800000024800000");
        pointOfServiceDataCodeMap.put("6059d", "FFFFFFFFFFFFFFFF0800000024800000");
        pointOfServiceDataCodeMap.put("7159*", "20000000100000000800000024800000");
        pointOfServiceDataCodeMap.put("9059*", "FFFFFFFFFFFFFFFF0800000024800000");

        pointOfServiceDataCodeMap.put("0072*", "FFFFFFFFFFFFFFFF080000004XX00000");
        pointOfServiceDataCodeMap.put("0172*", "FFFFFFFFFFFFFFFF080000004XX00000");
        pointOfServiceDataCodeMap.put("1372d", "FFFFFFFFFFFFFFFF080000004XX00000");
        pointOfServiceDataCodeMap.put("2072*", "FFFFFFFFFFFFFFFF080000004XX00000");
        pointOfServiceDataCodeMap.put("2772d", "FFFFFFFFFFFFFFFF080000004XX00000");
        pointOfServiceDataCodeMap.put("2872d", "FFFFFFFFFFFFFFFF080000004XX00000");
        pointOfServiceDataCodeMap.put("3172*", "FFFFFFFFFFFFFFFF080000004XX00000");
        pointOfServiceDataCodeMap.put("3372*", "FFFFFFFFFFFFFFFF080000004XX00000");
        pointOfServiceDataCodeMap.put("3472*", "FFFFFFFFFFFFFFFF080000004XX00000");
        pointOfServiceDataCodeMap.put("4072*", "FFFFFFFFFFFFFFFF080000004XX00000");
        pointOfServiceDataCodeMap.put("4K72*", "FFFFFFFFFFFFFFFF080000004XX00000");
        pointOfServiceDataCodeMap.put("4L72*", "FFFFFFFFFFFFFFFF080000004XX00000");
        pointOfServiceDataCodeMap.put("5072*", "FFFFFFFFFFFFFFFF080000004XX00000");
        pointOfServiceDataCodeMap.put("6072d", "FFFFFFFFFFFFFFFF080000004XX00000");
        pointOfServiceDataCodeMap.put("7172*", "FFFFFFFFFFFFFFFF080000004XX00000");
        pointOfServiceDataCodeMap.put("9059*", "2000000040000000080000004XX00000");
    }

    static Map<String, String> pointOfServiceCapabilityMap = new HashMap<>();

    static {
        pointOfServiceCapabilityMap.put("02", "28000000" + "50000000" + "6000000000000000NY" + "0C");
        pointOfServiceCapabilityMap.put("03", "28000000" + "50800000" + "6000000000000000NY" + "0C");
        pointOfServiceCapabilityMap.put("05", "20000000" + "50000000" + "6000000000000000NN" + "0C");
        pointOfServiceCapabilityMap.put("07", "20000000" + "50000000" + "6000000000000000NN" + "0C");
        pointOfServiceCapabilityMap.put("14", "28000000" + "50000000" + "6000000000000000NN" + "0C");
        pointOfServiceCapabilityMap.put("43", "28000000" + "50000000" + "6000000000000000NY" + "0C");
        pointOfServiceCapabilityMap.put("59", "20000000" + "50000000" + "6000000000000000NN" + "0C");
        pointOfServiceCapabilityMap.put("72", "20000000" + "40000000" + "6000000000000000NY" + "00");
    }

    protected static String generateExpirDate(String device, String expireDate) throws NoSuchPaddingException, UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, JCEHandlerException {
        if (device.startsWith("59") || device.startsWith("05")) {
            return expireDate;
        } else {
            return "0000";
        }

    }
    /*protected static String generateSecurityData(String device, int index, CardInfo cardInfo) throws Exception {
        String pin_data = getSecurityInfo(index).encryptPin(cardInfo.getPin1(), cardInfo.getPan());
        String secureData = "";
        if (device.startsWith(Device.INT.getValue()) ||
                device.startsWith(Device.MOB.getValue()) ||
                device.startsWith(Device.VRU.getValue())) {
            secureData = ISOUtil.hexString(getSecurityInfo(index).encrypt(
                    (StringUtil.padLeft(cardInfo.getCvv2(), 4, ' ') + "FFFFFFFFFFFF").getBytes()
                    , CSDAlg));
        } else {
            secureData = "00000000000000000000000000000000";
        }

        if (cardInfo.getPin1().length() > 12) {
            return secureData + pin_data.substring(16) + "00000000000000000000000000000000";

        } else {
            return secureData + "000000000000000000000000000000000000000000000000";
        }
    }*/
}
