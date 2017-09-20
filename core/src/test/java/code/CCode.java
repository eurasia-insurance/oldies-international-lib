package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CCode {

    private static Map<String, String> countryCodes = new HashMap<>();
    private static Map<String, List<String>> countryCodePrefixes = new HashMap<>();

    static {
	codesPut("GD", "1", "1473");
	codesPut("AS", "1", "1684");
	codesPut("US", "1", null);
	codesPut("BS", "1", "1242");
	codesPut("JM", "1", "1876");
	codesPut("KN", "1", "1869");
	codesPut("MP", "1", "1670");
	codesPut("KY", "1", "1345");
	codesPut("CA", "1", null); // разобраться
	codesPut("VI", "1", "1340");
	codesPut("MS", "1", "1664");
	codesPut("VG", "1", "1284");
	codesPut("DM", "1", "1767");
	codesPut("GU", "1", "1671");
	codesPut("LC", "1", "1758");
	codesPut("VC", "1", "1784");
	codesPut("DO", "1", "1809");
	codesPut("DO", "1", "1829");
	codesPut("DO", "1", "1849");
	codesPut("AG", "1", "1268");
	codesPut("BB", "1", "1246");
	codesPut("PR", "1", "1787");
	codesPut("PR", "1", "1939");
	codesPut("SX", "1", "1721");
	codesPut("AI", "1", "1264");
	codesPut("TC", "1", "1649");
	codesPut("TT", "1", "1868");
	codesPut("BM", "1", "1441");
	codesPut("EG", "20", null);
	codesPut("ZA", "27", null);
	codesPut("GR", "30", null);
	codesPut("NL", "31", null);
	codesPut("BE", "32", null);
	codesPut("FR", "33", null);
	codesPut("ES", "34", null);
	codesPut("HU", "36", null);
	codesPut("IT", "39", null);
	codesPut("RO", "40", null);
	codesPut("CH", "41", null);
	codesPut("AT", "43", null);
	codesPut("GB", "44", null);
	codesPut("DK", "45", null);
	codesPut("SE", "46", null);
	codesPut("NO", "47", null);
	codesPut("PL", "48", null);
	codesPut("DE", "49", null);
	codesPut("PE", "51", null);
	codesPut("MX", "52", null);
	codesPut("CU", "53", null);
	codesPut("AR", "54", null);
	codesPut("BR", "55", null);
	codesPut("CL", "56", null);
	codesPut("CO", "57", null);
	codesPut("VE", "58", null);
	codesPut("MY", "60", null);
	codesPut("AU", "61", null);
	codesPut("ID", "62", null);
	codesPut("PH", "63", null);
	codesPut("NZ", "64", null);
	codesPut("SG", "65", null);
	codesPut("TH", "66", null);
	codesPut("RU", "7", "73");
	codesPut("RU", "7", "74");
	codesPut("RU", "7", "75");
	codesPut("KZ", "7", "76");
	codesPut("KZ", "7", "77");
	codesPut("KZ", "7", "78");
	codesPut("RU", "7", "79");
	codesPut("JP", "81", null);
	codesPut("KR", "82", null);
	codesPut("VN", "84", null);
	codesPut("CN", "86", null);
	codesPut("TR", "90", null);
	codesPut("IN", "91", null);
	codesPut("PK", "92", null);
	codesPut("AF", "93", null);
	codesPut("LK", "94", null);
	codesPut("MM", "95", null);
	codesPut("IR", "98", null);
	codesPut("SS", "211", null);
	codesPut("MA", "212", null);
	codesPut("DZ", "213", null);
	codesPut("TN", "216", null);
	codesPut("LY", "218", null);
	codesPut("GM", "220", null);
	codesPut("SN", "221", null);
	codesPut("MR", "222", null);
	codesPut("ML", "223", null);
	codesPut("GN", "224", null);
	codesPut("CI", "225", null);
	codesPut("BF", "226", null);
	codesPut("NE", "227", null);
	codesPut("TG", "228", null);
	codesPut("BJ", "229", null);
	codesPut("MU", "230", null);
	codesPut("LR", "231", null);
	codesPut("SL", "232", null);
	codesPut("GH", "233", null);
	codesPut("NG", "234", null);
	codesPut("TD", "235", null);
	codesPut("CF", "236", null);
	codesPut("CM", "237", null);
	codesPut("CV", "238", null);
	codesPut("ST", "239", null);
	codesPut("GQ", "240", null);
	codesPut("GA", "241", null);
	codesPut("CG", "242", null);
	codesPut("CD", "243", null);
	codesPut("AO", "244", null);
	codesPut("GW", "245", null);
	codesPut("IO", "246", null);
	codesPut("AC", "247", null);
	codesPut("SC", "248", null);
	codesPut("SD", "249", null);
	codesPut("RW", "250", null);
	codesPut("ET", "251", null);
	codesPut("SO", "252", null);
	codesPut("DJ", "253", null);
	codesPut("KE", "254", null);
	codesPut("TZ", "255", null);
	codesPut("UG", "256", null);
	codesPut("BI", "257", null);
	codesPut("MZ", "258", null);
	codesPut("ZM", "260", null);
	codesPut("MG", "261", null);
	codesPut("RE", "262", null);
	codesPut("ZW", "263", null);
	codesPut("NA", "264", null);
	codesPut("MW", "265", null);
	codesPut("LS", "266", null);
	codesPut("BW", "267", null);
	codesPut("SZ", "268", null);
	codesPut("KM", "269", null);
	codesPut("SH", "290", null);
	codesPut("ER", "291", null);
	codesPut("AW", "297", null);
	codesPut("FO", "298", null);
	codesPut("GL", "299", null);
	codesPut("GI", "350", null);
	codesPut("PT", "351", null);
	codesPut("LU", "352", null);
	codesPut("IE", "353", null);
	codesPut("IS", "354", null);
	codesPut("AL", "355", null);
	codesPut("MT", "356", null);
	codesPut("CY", "357", null);
	codesPut("FI", "358", null);
	codesPut("BG", "359", null);
	codesPut("LT", "370", null);
	codesPut("LV", "371", null);
	codesPut("EE", "372", null);
	codesPut("MD", "373", null);
	codesPut("AM", "374", null);
	codesPut("BY", "375", null);
	codesPut("AD", "376", null);
	codesPut("MC", "377", null);
	codesPut("SM", "378", null);
	codesPut("VA", "379", null);
	codesPut("UA", "380", null);
	codesPut("RS", "381", null);
	codesPut("ME", "382", null);
	codesPut("XK", "383", null);
	codesPut("HR", "385", null);
	codesPut("SI", "386", null);
	codesPut("BA", "387", null);
	codesPut("EU", "388", null);
	codesPut("MK", "389", null);
	codesPut("CZ", "420", null);
	codesPut("SK", "421", null);
	codesPut("LI", "423", null);
	codesPut("FK", "500", null);
	codesPut("BZ", "501", null);
	codesPut("GT", "502", null);
	codesPut("SV", "503", null);
	codesPut("HN", "504", null);
	codesPut("NI", "505", null);
	codesPut("CR", "506", null);
	codesPut("PA", "507", null);
	codesPut("PM", "508", null);
	codesPut("HT", "509", null);
	codesPut("GP", "590", null);
	codesPut("BO", "591", null);
	codesPut("GY", "592", null);
	codesPut("EC", "593", null);
	codesPut("GF", "594", null);
	codesPut("PY", "595", null);
	codesPut("MQ", "596", null);
	codesPut("SR", "597", null);
	codesPut("UY", "598", null);
	codesPut("AN", "599", null);
	codesPut("TL", "670", null);
	codesPut("NF", "672", null);
	codesPut("AQ", "672", null);
	codesPut("BN", "673", null);
	codesPut("NR", "674", null);
	codesPut("PG", "675", null);
	codesPut("TO", "676", null);
	codesPut("SB", "677", null);
	codesPut("VU", "678", null);
	codesPut("FJ", "679", null);
	codesPut("PW", "680", null);
	codesPut("WF", "681", null);
	codesPut("CK", "682", null);
	codesPut("NU", "683", null);
	codesPut("WS", "685", null);
	codesPut("KI", "686", null);
	codesPut("NC", "687", null);
	codesPut("TV", "688", null);
	codesPut("PF", "689", null);
	codesPut("TK", "690", null);
	codesPut("FM", "691", null);
	codesPut("MH", "692", null);
	codesPut("XF", "800", null);
	codesPut("XC", "808", null);
	codesPut("KP", "850", null);
	codesPut("HK", "852", null);
	codesPut("MO", "853", null);
	codesPut("KH", "855", null);
	codesPut("LA", "856", null);
	codesPut("XS", "870", null);
	codesPut("XU", "878", null);
	codesPut("BD", "880", null);
	codesPut("XG", "881", null);
	codesPut("XN", "88", "882");
	codesPut("XN", "88", "883");
	codesPut("TW", "886", null);
	codesPut("XD", "888", null);
	codesPut("MV", "960", null);
	codesPut("LB", "961", null);
	codesPut("JO", "962", null);
	codesPut("SY", "963", null);
	codesPut("IQ", "964", null);
	codesPut("KW", "965", null);
	codesPut("SA", "966", null);
	codesPut("YE", "967", null);
	codesPut("OM", "968", null);
	codesPut("PS", "970", null);
	codesPut("AE", "971", null);
	codesPut("IL", "972", null);
	codesPut("BH", "973", null);
	codesPut("QA", "974", null);
	codesPut("BT", "975", null);
	codesPut("MN", "976", null);
	codesPut("NP", "977", null);
	codesPut("XR", "979", null);
	codesPut("XT", "991", null);
	codesPut("TJ", "992", null);
	codesPut("TM", "993", null);
	codesPut("AZ", "994", null);
	codesPut("GE", "995", null);
	codesPut("KG", "996", null);
	codesPut("UZ", "998", null);
    }

    private static void codesPut(String a2, String mainPhoneCode, String countryCodePrefix) {
	if (countryCodePrefix == null)
	    countryCodePrefix = mainPhoneCode;
	if (countryCodes.containsKey(a2) && !countryCodes.get(a2).equals(mainPhoneCode))
	    throw new RuntimeException("Code must be uniue '" + a2 + "'");
	countryCodes.put(a2, mainPhoneCode);
	if (!countryCodePrefixes.containsKey(a2)) {
	    List<String> s = new ArrayList<>(1);
	    countryCodePrefixes.put(a2, s);
	}
	countryCodePrefixes.get(a2).add(countryCodePrefix);
    }

    public static List<String> getPhoneCountries() {
	Set<String> cc = countryCodePrefixes.keySet();
	List<String> l = new ArrayList<>(cc.size());
	l.addAll(cc);
	// Collections.sort(l, Collections.reverseOrder(new
	// StringLengthComparator()));
	Collections.sort(l, new StringLengthComparator());
	return l;
    }

    public static String getPhoneCode(String phoneCountry) {
	return countryCodes.get(phoneCountry);
    }

    public static String[] getPhonePrefixes(String phoneCountry) {
	List<String> prefixes = countryCodePrefixes.get(phoneCountry);
	Collections.sort(prefixes, new StringLengthComparator());
	return prefixes.toArray(new String[0]);
    }

    static class StringLengthComparator implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
	    if (o1.length() == o2.length())
		return o1.compareTo(o2);
	    return o1.length() - o2.length();
	}
    }

}
