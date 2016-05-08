package com.lapsa.phone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lapsa.country.Country;

public enum CountryCode {
    AC("AC", "247", "247"),
    AD("AD", "376", "376"),
    AE("AE", "971", "971"),
    AF("AF", "93", "93"),
    AG("AG", "1", "1268"),
    AI("AI", "1", "1264"),
    AL("AL", "355", "355"),
    AM("AM", "374", "374"),
    AN("AN", "599", "599"),
    AO("AO", "244", "244"),
    AQ("AQ", "672", "672"),
    AR("AR", "54", "54"),
    AS("AS", "1", "1684"),
    AT("AT", "43", "43"),
    AU("AU", "61", "61"),
    AW("AW", "297", "297"),
    AZ("AZ", "994", "994"),
    BA("BA", "387", "387"),
    BB("BB", "1", "1246"),
    BD("BD", "880", "880"),
    BE("BE", "32", "32"),
    BF("BF", "226", "226"),
    BG("BG", "359", "359"),
    BH("BH", "973", "973"),
    BI("BI", "257", "257"),
    BJ("BJ", "229", "229"),
    BM("BM", "1", "1441"),
    BN("BN", "673", "673"),
    BO("BO", "591", "591"),
    BR("BR", "55", "55"),
    BS("BS", "1", "1242"),
    BT("BT", "975", "975"),
    BW("BW", "267", "267"),
    BY("BY", "375", "375"),
    BZ("BZ", "501", "501"),
    CA("CA", "1", "1"),
    CD("CD", "243", "243"),
    CF("CF", "236", "236"),
    CG("CG", "242", "242"),
    CH("CH", "41", "41"),
    CI("CI", "225", "225"),
    CK("CK", "682", "682"),
    CL("CL", "56", "56"),
    CM("CM", "237", "237"),
    CN("CN", "86", "86"),
    CO("CO", "57", "57"),
    CR("CR", "506", "506"),
    CU("CU", "53", "53"),
    CV("CV", "238", "238"),
    CY("CY", "357", "357"),
    CZ("CZ", "420", "420"),
    DE("DE", "49", "49"),
    DJ("DJ", "253", "253"),
    DK("DK", "45", "45"),
    DM("DM", "1", "1767"),
    DO("DO", "1", "1809", "1829", "1849"),
    DZ("DZ", "213", "213"),
    EC("EC", "593", "593"),
    EE("EE", "372", "372"),
    EG("EG", "20", "20"),
    ER("ER", "291", "291"),
    ES("ES", "34", "34"),
    ET("ET", "251", "251"),
    EU("EU", "388", "388"),
    FI("FI", "358", "358"),
    FJ("FJ", "679", "679"),
    FK("FK", "500", "500"),
    FM("FM", "691", "691"),
    FO("FO", "298", "298"),
    FR("FR", "33", "33"),
    GA("GA", "241", "241"),
    GB("GB", "44", "44"),
    GD("GD", "1", "1473"),
    GE("GE", "995", "995"),
    GF("GF", "594", "594"),
    GH("GH", "233", "233"),
    GI("GI", "350", "350"),
    GL("GL", "299", "299"),
    GM("GM", "220", "220"),
    GN("GN", "224", "224"),
    GP("GP", "590", "590"),
    GQ("GQ", "240", "240"),
    GR("GR", "30", "30"),
    GT("GT", "502", "502"),
    GU("GU", "1", "1671"),
    GW("GW", "245", "245"),
    GY("GY", "592", "592"),
    HK("HK", "852", "852"),
    HN("HN", "504", "504"),
    HR("HR", "385", "385"),
    HT("HT", "509", "509"),
    HU("HU", "36", "36"),
    ID("ID", "62", "62"),
    IE("IE", "353", "353"),
    IL("IL", "972", "972"),
    IN("IN", "91", "91"),
    IO("IO", "246", "246"),
    IQ("IQ", "964", "964"),
    IR("IR", "98", "98"),
    IS("IS", "354", "354"),
    IT("IT", "39", "39"),
    JM("JM", "1", "1876"),
    JO("JO", "962", "962"),
    JP("JP", "81", "81"),
    KE("KE", "254", "254"),
    KG("KG", "996", "996"),
    KH("KH", "855", "855"),
    KI("KI", "686", "686"),
    KM("KM", "269", "269"),
    KN("KN", "1", "1869"),
    KP("KP", "850", "850"),
    KR("KR", "82", "82"),
    KW("KW", "965", "965"),
    KY("KY", "1", "1345"),
    KZ("KZ", "7", "76", "77", "78"),
    LA("LA", "856", "856"),
    LB("LB", "961", "961"),
    LC("LC", "1", "1758"),
    LI("LI", "423", "423"),
    LK("LK", "94", "94"),
    LR("LR", "231", "231"),
    LS("LS", "266", "266"),
    LT("LT", "370", "370"),
    LU("LU", "352", "352"),
    LV("LV", "371", "371"),
    LY("LY", "218", "218"),
    MA("MA", "212", "212"),
    MC("MC", "377", "377"),
    MD("MD", "373", "373"),
    ME("ME", "382", "382"),
    MG("MG", "261", "261"),
    MH("MH", "692", "692"),
    MK("MK", "389", "389"),
    ML("ML", "223", "223"),
    MM("MM", "95", "95"),
    MN("MN", "976", "976"),
    MO("MO", "853", "853"),
    MP("MP", "1", "1670"),
    MQ("MQ", "596", "596"),
    MR("MR", "222", "222"),
    MS("MS", "1", "1664"),
    MT("MT", "356", "356"),
    MU("MU", "230", "230"),
    MV("MV", "960", "960"),
    MW("MW", "265", "265"),
    MX("MX", "52", "52"),
    MY("MY", "60", "60"),
    MZ("MZ", "258", "258"),
    NA("NA", "264", "264"),
    NC("NC", "687", "687"),
    NE("NE", "227", "227"),
    NF("NF", "672", "672"),
    NG("NG", "234", "234"),
    NI("NI", "505", "505"),
    NL("NL", "31", "31"),
    NO("NO", "47", "47"),
    NP("NP", "977", "977"),
    NR("NR", "674", "674"),
    NU("NU", "683", "683"),
    NZ("NZ", "64", "64"),
    OM("OM", "968", "968"),
    PA("PA", "507", "507"),
    PE("PE", "51", "51"),
    PF("PF", "689", "689"),
    PG("PG", "675", "675"),
    PH("PH", "63", "63"),
    PK("PK", "92", "92"),
    PL("PL", "48", "48"),
    PM("PM", "508", "508"),
    PR("PR", "1", "1787", "1939"),
    PS("PS", "970", "970"),
    PT("PT", "351", "351"),
    PW("PW", "680", "680"),
    PY("PY", "595", "595"),
    QA("QA", "974", "974"),
    RE("RE", "262", "262"),
    RO("RO", "40", "40"),
    RS("RS", "381", "381"),
    RU("RU", "7", "73", "74", "75", "79"),
    RW("RW", "250", "250"),
    SA("SA", "966", "966"),
    SB("SB", "677", "677"),
    SC("SC", "248", "248"),
    SD("SD", "249", "249"),
    SE("SE", "46", "46"),
    SG("SG", "65", "65"),
    SH("SH", "290", "290"),
    SI("SI", "386", "386"),
    SK("SK", "421", "421"),
    SL("SL", "232", "232"),
    SM("SM", "378", "378"),
    SN("SN", "221", "221"),
    SO("SO", "252", "252"),
    SR("SR", "597", "597"),
    SS("SS", "211", "211"),
    ST("ST", "239", "239"),
    SV("SV", "503", "503"),
    SX("SX", "1", "1721"),
    SY("SY", "963", "963"),
    SZ("SZ", "268", "268"),
    TC("TC", "1", "1649"),
    TD("TD", "235", "235"),
    TG("TG", "228", "228"),
    TH("TH", "66", "66"),
    TJ("TJ", "992", "992"),
    TK("TK", "690", "690"),
    TL("TL", "670", "670"),
    TM("TM", "993", "993"),
    TN("TN", "216", "216"),
    TO("TO", "676", "676"),
    TR("TR", "90", "90"),
    TT("TT", "1", "1868"),
    TV("TV", "688", "688"),
    TW("TW", "886", "886"),
    TZ("TZ", "255", "255"),
    UA("UA", "380", "380"),
    UG("UG", "256", "256"),
    US("US", "1", "1"),
    UY("UY", "598", "598"),
    UZ("UZ", "998", "998"),
    VA("VA", "379", "379"),
    VC("VC", "1", "1784"),
    VE("VE", "58", "58"),
    VG("VG", "1", "1284"),
    VI("VI", "1", "1340"),
    VN("VN", "84", "84"),
    VU("VU", "678", "678"),
    WF("WF", "681", "681"),
    WS("WS", "685", "685"),
    XC("XC", "808", "808"),
    XD("XD", "888", "888"),
    XF("XF", "800", "800"),
    XG("XG", "881", "881"),
    XK("XK", "383", "383"),
    XN("XN", "88", "882", "883"),
    XR("XR", "979", "979"),
    XS("XS", "870", "870"),
    XT("XT", "991", "991"),
    XU("XU", "878", "878"),
    YE("YE", "967", "967"),
    ZA("ZA", "27", "27"),
    ZM("ZM", "260", "260"),
    ZW("ZW", "263", "263");

    private final String phoneCode;
    private final String[] phonePrefixes;
    private final Country country;

    CountryCode(String alpha2, String phoneCode, String... phonePrefixes) {
	this.phoneCode = phoneCode;
	this.phonePrefixes = phonePrefixes;
	this.country = Country.forAlpha2Code(alpha2);
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
}
