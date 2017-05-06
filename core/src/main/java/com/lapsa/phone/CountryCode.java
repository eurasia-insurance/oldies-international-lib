package com.lapsa.phone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lapsa.country.Country;

public enum CountryCode {
    AC("SH", "247", -1, -1, "247"),
    AD("AD", "376", -1, -1, "376"),
    AE("AE", "971", -1, -1, "971"),
    AF("AF", "93", -1, -1, "93"),
    AG("AG", "1", -1, -1, "1268"),
    AI("AI", "1", -1, -1, "1264"),
    AL("AL", "355", -1, -1, "355"),
    AM("AM", "374", -1, -1, "374"),
    AN("AN", "599", -1, -1, "599"),
    AO("AO", "244", -1, -1, "244"),
    AQ("AQ", "672", -1, -1, "672"),
    AR("AR", "54", -1, -1, "54"),
    AS("AS", "1", -1, -1, "1684"),
    AT("AT", "43", -1, -1, "43"),
    AU("AU", "61", -1, -1, "61"),
    AW("AW", "297", -1, -1, "297"),
    AZ("AZ", "994", -1, -1, "994"),
    BA("BA", "387", -1, -1, "387"),
    BB("BB", "1", -1, -1, "1246"),
    BD("BD", "880", -1, -1, "880"),
    BE("BE", "32", -1, -1, "32"),
    BF("BF", "226", -1, -1, "226"),
    BG("BG", "359", -1, -1, "359"),
    BH("BH", "973", -1, -1, "973"),
    BI("BI", "257", -1, -1, "257"),
    BJ("BJ", "229", -1, -1, "229"),
    BM("BM", "1", -1, -1, "1441"),
    BN("BN", "673", -1, -1, "673"),
    BO("BO", "591", -1, -1, "591"),
    BR("BR", "55", -1, -1, "55"),
    BS("BS", "1", -1, -1, "1242"),
    BT("BT", "975", -1, -1, "975"),
    BW("BW", "267", -1, -1, "267"),
    BY("BY", "375", -1, -1, "375"),
    BZ("BZ", "501", -1, -1, "501"),
    CA("CA", "1", -1, -1, "1"),
    CD("CD", "243", -1, -1, "243"),
    CF("CF", "236", -1, -1, "236"),
    CG("CG", "242", -1, -1, "242"),
    CH("CH", "41", -1, -1, "41"),
    CI("CI", "225", -1, -1, "225"),
    CK("CK", "682", -1, -1, "682"),
    CL("CL", "56", -1, -1, "56"),
    CM("CM", "237", -1, -1, "237"),
    CN("CN", "86", -1, -1, "86"),
    CO("CO", "57", -1, -1, "57"),
    CR("CR", "506", -1, -1, "506"),
    CU("CU", "53", -1, -1, "53"),
    CV("CV", "238", -1, -1, "238"),
    CY("CY", "357", -1, -1, "357"),
    CZ("CZ", "420", -1, -1, "420"),
    DE("DE", "49", -1, -1, "49"),
    DJ("DJ", "253", -1, -1, "253"),
    DK("DK", "45", -1, -1, "45"),
    DM("DM", "1", -1, -1, "1767"),
    DO("DO", "1", -1, -1, "1809", "1829", "1849"),
    DZ("DZ", "213", -1, -1, "213"),
    EC("EC", "593", -1, -1, "593"),
    EE("EE", "372", -1, -1, "372"),
    EG("EG", "20", -1, -1, "20"),
    ER("ER", "291", -1, -1, "291"),
    ES("ES", "34", -1, -1, "34"),
    ET("ET", "251", -1, -1, "251"),
    EU("OTHR", "388", -1, -1, "388"),
    FI("FI", "358", -1, -1, "358"),
    FJ("FJ", "679", -1, -1, "679"),
    FK("FK", "500", -1, -1, "500"),
    FM("FM", "691", -1, -1, "691"),
    FO("FO", "298", -1, -1, "298"),
    FR("FR", "33", -1, -1, "33"),
    GA("GA", "241", -1, -1, "241"),
    GB("GB", "44", -1, -1, "44"),
    GD("GD", "1", -1, -1, "1473"),
    GE("GE", "995", -1, -1, "995"),
    GF("GF", "594", -1, -1, "594"),
    GH("GH", "233", -1, -1, "233"),
    GI("GI", "350", -1, -1, "350"),
    GL("GL", "299", -1, -1, "299"),
    GM("GM", "220", -1, -1, "220"),
    GN("GN", "224", -1, -1, "224"),
    GP("GP", "590", -1, -1, "590"),
    GQ("GQ", "240", -1, -1, "240"),
    GR("GR", "30", -1, -1, "30"),
    GT("GT", "502", -1, -1, "502"),
    GU("GU", "1", -1, -1, "1671"),
    GW("GW", "245", -1, -1, "245"),
    GY("GY", "592", -1, -1, "592"),
    HK("HK", "852", -1, -1, "852"),
    HN("HN", "504", -1, -1, "504"),
    HR("HR", "385", -1, -1, "385"),
    HT("HT", "509", -1, -1, "509"),
    HU("HU", "36", -1, -1, "36"),
    ID("ID", "62", -1, -1, "62"),
    IE("IE", "353", -1, -1, "353"),
    IL("IL", "972", -1, -1, "972"),
    IN("IN", "91", -1, -1, "91"),
    IO("IO", "246", -1, -1, "246"),
    IQ("IQ", "964", -1, -1, "964"),
    IR("IR", "98", -1, -1, "98"),
    IS("IS", "354", -1, -1, "354"),
    IT("IT", "39", -1, -1, "39"),
    JM("JM", "1", -1, -1, "1876"),
    JO("JO", "962", -1, -1, "962"),
    JP("JP", "81", -1, -1, "81"),
    KE("KE", "254", -1, -1, "254"),
    KG("KG", "996", -1, -1, "996"),
    KH("KH", "855", -1, -1, "855"),
    KI("KI", "686", -1, -1, "686"),
    KM("KM", "269", -1, -1, "269"),
    KN("KN", "1", -1, -1, "1869"),
    KP("KP", "850", -1, -1, "850"),
    KR("KR", "82", -1, -1, "82"),
    KW("KW", "965", -1, -1, "965"),
    KY("KY", "1", -1, -1, "1345"),
    KZ("KZ", "7", 3, 7, "76", "77", "78"),
    LA("LA", "856", -1, -1, "856"),
    LB("LB", "961", -1, -1, "961"),
    LC("LC", "1", -1, -1, "1758"),
    LI("LI", "423", -1, -1, "423"),
    LK("LK", "94", -1, -1, "94"),
    LR("LR", "231", -1, -1, "231"),
    LS("LS", "266", -1, -1, "266"),
    LT("LT", "370", -1, -1, "370"),
    LU("LU", "352", -1, -1, "352"),
    LV("LV", "371", -1, -1, "371"),
    LY("LY", "218", -1, -1, "218"),
    MA("MA", "212", -1, -1, "212"),
    MC("MC", "377", -1, -1, "377"),
    MD("MD", "373", -1, -1, "373"),
    ME("ME", "382", -1, -1, "382"),
    MG("MG", "261", -1, -1, "261"),
    MH("MH", "692", -1, -1, "692"),
    MK("MK", "389", -1, -1, "389"),
    ML("ML", "223", -1, -1, "223"),
    MM("MM", "95", -1, -1, "95"),
    MN("MN", "976", -1, -1, "976"),
    MO("MO", "853", -1, -1, "853"),
    MP("MP", "1", -1, -1, "1670"),
    MQ("MQ", "596", -1, -1, "596"),
    MR("MR", "222", -1, -1, "222"),
    MS("MS", "1", -1, -1, "1664"),
    MT("MT", "356", -1, -1, "356"),
    MU("MU", "230", -1, -1, "230"),
    MV("MV", "960", -1, -1, "960"),
    MW("MW", "265", -1, -1, "265"),
    MX("MX", "52", -1, -1, "52"),
    MY("MY", "60", -1, -1, "60"),
    MZ("MZ", "258", -1, -1, "258"),
    NA("NA", "264", -1, -1, "264"),
    NC("NC", "687", -1, -1, "687"),
    NE("NE", "227", -1, -1, "227"),
    NF("NF", "672", -1, -1, "672"),
    NG("NG", "234", -1, -1, "234"),
    NI("NI", "505", -1, -1, "505"),
    NL("NL", "31", -1, -1, "31"),
    NO("NO", "47", -1, -1, "47"),
    NP("NP", "977", -1, -1, "977"),
    NR("NR", "674", -1, -1, "674"),
    NU("NU", "683", -1, -1, "683"),
    NZ("NZ", "64", -1, -1, "64"),
    OM("OM", "968", -1, -1, "968"),
    PA("PA", "507", -1, -1, "507"),
    PE("PE", "51", -1, -1, "51"),
    PF("PF", "689", -1, -1, "689"),
    PG("PG", "675", -1, -1, "675"),
    PH("PH", "63", -1, -1, "63"),
    PK("PK", "92", -1, -1, "92"),
    PL("PL", "48", -1, -1, "48"),
    PM("PM", "508", -1, -1, "508"),
    PR("PR", "1", -1, -1, "1787", "1939"),
    PS("PS", "970", -1, -1, "970"),
    PT("PT", "351", -1, -1, "351"),
    PW("PW", "680", -1, -1, "680"),
    PY("PY", "595", -1, -1, "595"),
    QA("QA", "974", -1, -1, "974"),
    RE("RE", "262", -1, -1, "262"),
    RO("RO", "40", -1, -1, "40"),
    RS("RS", "381", -1, -1, "381"),
    RU("RU", "7", 3, 7, "73", "74", "75", "79"),
    RW("RW", "250", -1, -1, "250"),
    SA("SA", "966", -1, -1, "966"),
    SB("SB", "677", -1, -1, "677"),
    SC("SC", "248", -1, -1, "248"),
    SD("SD", "249", -1, -1, "249"),
    SE("SE", "46", -1, -1, "46"),
    SG("SG", "65", -1, -1, "65"),
    SH("SH", "290", -1, -1, "290"),
    SI("SI", "386", -1, -1, "386"),
    SK("SK", "421", -1, -1, "421"),
    SL("SL", "232", -1, -1, "232"),
    SM("SM", "378", -1, -1, "378"),
    SN("SN", "221", -1, -1, "221"),
    SO("SO", "252", -1, -1, "252"),
    SR("SR", "597", -1, -1, "597"),
    SS("SS", "211", -1, -1, "211"),
    ST("ST", "239", -1, -1, "239"),
    SV("SV", "503", -1, -1, "503"),
    SX("SX", "1", -1, -1, "1721"),
    SY("SY", "963", -1, -1, "963"),
    SZ("SZ", "268", -1, -1, "268"),
    TC("TC", "1", -1, -1, "1649"),
    TD("TD", "235", -1, -1, "235"),
    TG("TG", "228", -1, -1, "228"),
    TH("TH", "66", -1, -1, "66"),
    TJ("TJ", "992", -1, -1, "992"),
    TK("TK", "690", -1, -1, "690"),
    TL("TL", "670", -1, -1, "670"),
    TM("TM", "993", -1, -1, "993"),
    TN("TN", "216", -1, -1, "216"),
    TO("TO", "676", -1, -1, "676"),
    TR("TR", "90", -1, -1, "90"),
    TT("TT", "1", -1, -1, "1868"),
    TV("TV", "688", -1, -1, "688"),
    TW("TW", "886", -1, -1, "886"),
    TZ("TZ", "255", -1, -1, "255"),
    UA("UA", "380", -1, -1, "380"),
    UG("UG", "256", -1, -1, "256"),
    US("US", "1", -1, -1, "1"),
    UY("UY", "598", -1, -1, "598"),
    UZ("UZ", "998", -1, -1, "998"),
    VA("VA", "379", -1, -1, "379"),
    VC("VC", "1", -1, -1, "1784"),
    VE("VE", "58", -1, -1, "58"),
    VG("VG", "1", -1, -1, "1284"),
    VI("VI", "1", -1, -1, "1340"),
    VN("VN", "84", -1, -1, "84"),
    VU("VU", "678", -1, -1, "678"),
    WF("WF", "681", -1, -1, "681"),
    WS("WS", "685", -1, -1, "685"),
    // XC("OTHR", "808", "808"),
    // XD("OTHR", "888", "888"),
    // XF("OTHR", "800", "800"),
    // XG("OTHR", "881", "881"),
    XK("XK", "383", -1, -1, "383"),
    // XN("OTHR", "88", "882", "883"),
    // XR("OTHR", "979", "979"),
    // XS("OTHR", "870", "870"),
    // XT("OTHR", "991", "991"),
    // XP("OTHR", "878", "878"),
    YE("YE", "967", -1, -1, "967"),
    ZA("ZA", "27", -1, -1, "27"),
    ZM("ZM", "260", -1, -1, "260"),
    ZW("ZW", "263", -1, -1, "263");

    private final String phoneCode;
    private final String[] phonePrefixes;
    private final Country country;

    private final int areaCodeLength;
    private final int numberLength;

    CountryCode(String alpha2, String phoneCode, int areaCodeLength, int numberLength, String... phonePrefixes) {
	this.phoneCode = phoneCode;
	this.phonePrefixes = phonePrefixes;
	this.country = Country.forAlpha2Code(alpha2);
	this.areaCodeLength = areaCodeLength;
	this.numberLength = numberLength;
    }

    public Country getCountry() {
	return country;
    }

    public String getPhoneCode() {
	return phoneCode;
    }

    @Override
    public String toString() {
	return "+" + phoneCode;
    }

    public static CountryCode getByPhonePrefix(String number) {
	if (number == null || number.isEmpty())
	    return null;
	for (String prefix : prefixesSortedList) {
	    if (number.startsWith(prefix))
		return prefixesMap.get(prefix);
	}
	return null;
    }

    public static CountryCode getFirstByCode(String code) {
	if (code == null || code.isEmpty())
	    return null;
	for (CountryCode i : CountryCode.values()) {
	    if (code.startsWith(i.getPhoneCode()))
		return i;
	}
	return null;
    }

    private static List<String> prefixesSortedList;
    private static Map<String, CountryCode> prefixesMap;

    static {
	prefixesSortedList = new ArrayList<>();
	prefixesMap = new HashMap<>();
	for (CountryCode code : CountryCode.values()) {
	    for (String p : code.phonePrefixes) {
		prefixesSortedList.add(p);
		prefixesMap.put(p, code);
	    }
	}
	Collections.sort(prefixesSortedList, Collections.reverseOrder(new StringLengthComparator()));
    }

    public String[] prefixes() {
	return phonePrefixes;
    }

    public int getAreaCodeLength() {
	return areaCodeLength;
    }

    public int getNumberLength() {
	return numberLength;
    }
}
