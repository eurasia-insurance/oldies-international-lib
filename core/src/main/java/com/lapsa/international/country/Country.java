package com.lapsa.international.country;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.lapsa.international.InternationalLocalizedElement;

public enum Country implements InternationalLocalizedElement {
    AUS("AU", "AUS", "036", "ISO 3166-2:AU"),
    AUT("AT", "AUT", "040", "ISO 3166-2:AT"),
    AZE("AZ", "AZE", "031", "ISO 3166-2:AZ"),
    ALA("AX", "ALA", "248", "ISO 3166-2:AX"),
    ALB("AL", "ALB", "008", "ISO 3166-2:AL"),
    DZA("DZ", "DZA", "012", "ISO 3166-2:DZ"),
    VIR("VI", "VIR", "850", "ISO 3166-2:VI"),
    ASM("AS", "ASM", "016", "ISO 3166-2:AS"),
    AIA("AI", "AIA", "660", "ISO 3166-2:AI"),
    AGO("AO", "AGO", "024", "ISO 3166-2:AO"),
    AND("AD", "AND", "020", "ISO 3166-2:AD"),
    ANT("AN", "ANT", "530", "ISO 3166-2:AN"),
    ATA("AQ", "ATA", "010", "ISO 3166-2:AQ"),
    ATG("AG", "ATG", "028", "ISO 3166-2:AG"),
    ARG("AR", "ARG", "032", "ISO 3166-2:AR"),
    ARM("AM", "ARM", "051", "ISO 3166-2:AM"),
    ABW("AW", "ABW", "533", "ISO 3166-2:AW"),
    AFG("AF", "AFG", "004", "ISO 3166-2:AF"),
    BHS("BS", "BHS", "044", "ISO 3166-2:BS"),
    BGD("BD", "BGD", "050", "ISO 3166-2:BD"),
    BRB("BB", "BRB", "052", "ISO 3166-2:BB"),
    BHR("BH", "BHR", "048", "ISO 3166-2:BH"),
    BLZ("BZ", "BLZ", "084", "ISO 3166-2:BZ"),
    BLR("BY", "BLR", "112", "ISO 3166-2:BY"),
    BEL("BE", "BEL", "056", "ISO 3166-2:BE"),
    BEN("BJ", "BEN", "204", "ISO 3166-2:BJ"),
    BMU("BM", "BMU", "060", "ISO 3166-2:BM"),
    BGR("BG", "BGR", "100", "ISO 3166-2:BG"),
    BOL("BO", "BOL", "068", "ISO 3166-2:BO"),
    BES("BQ", "BES", "535", "ISO 3166-2:BQ"),
    BIH("BA", "BIH", "070", "ISO 3166-2:BA"),
    BWA("BW", "BWA", "072", "ISO 3166-2:BW"),
    BRA("BR", "BRA", "076", "ISO 3166-2:BR"),
    IOT("IO", "IOT", "086", "ISO 3166-2:IO"),
    VGB("VG", "VGB", "092", "ISO 3166-2:VG"),
    BRN("BN", "BRN", "096", "ISO 3166-2:BN"),
    BFA("BF", "BFA", "854", "ISO 3166-2:BF"),
    BDI("BI", "BDI", "108", "ISO 3166-2:BI"),
    BTN("BT", "BTN", "064", "ISO 3166-2:BT"),
    VUT("VU", "VUT", "548", "ISO 3166-2:VU"),
    VAT("VA", "VAT", "336", "ISO 3166-2:VA"),
    GBR("GB", "GBR", "826", "ISO 3166-2:GB"),
    HUN("HU", "HUN", "348", "ISO 3166-2:HU"),
    VEN("VE", "VEN", "862", "ISO 3166-2:VE"),
    UMI("UM", "UMI", "581", "ISO 3166-2:UM"),
    TLS("TL", "TLS", "626", "ISO 3166-2:TL"),
    VNM("VN", "VNM", "704", "ISO 3166-2:VN"),
    GAB("GA", "GAB", "266", "ISO 3166-2:GA"),
    HTI("HT", "HTI", "332", "ISO 3166-2:HT"),
    GUY("GY", "GUY", "328", "ISO 3166-2:GY"),
    GMB("GM", "GMB", "270", "ISO 3166-2:GM"),
    GHA("GH", "GHA", "288", "ISO 3166-2:GH"),
    GLP("GP", "GLP", "312", "ISO 3166-2:GP"),
    GTM("GT", "GTM", "320", "ISO 3166-2:GT"),
    GUF("GF", "GUF", "254", "ISO 3166-2:GF"),
    GIN("GN", "GIN", "324", "ISO 3166-2:GN"),
    GNB("GW", "GNB", "624", "ISO 3166-2:GW"),
    DEU("DE", "DEU", "276", "ISO 3166-2:DE"),
    GGY("GG", "GGY", "831", "ISO 3166-2:GG"),
    GIB("GI", "GIB", "292", "ISO 3166-2:GI"),
    HND("HN", "HND", "340", "ISO 3166-2:HN"),
    HKG("HK", "HKG", "344", "ISO 3166-2:HK"),
    GRD("GD", "GRD", "308", "ISO 3166-2:GD"),
    GRL("GL", "GRL", "304", "ISO 3166-2:GL"),
    GRC("GR", "GRC", "300", "ISO 3166-2:GR"),
    GEO("GE", "GEO", "268", "ISO 3166-2:GE"),
    GUM("GU", "GUM", "316", "ISO 3166-2:GU"),
    DNK("DK", "DNK", "208", "ISO 3166-2:DK"),
    JEY("JE", "JEY", "832", "ISO 3166-2:JE"),
    DJI("DJ", "DJI", "262", "ISO 3166-2:DJ"),
    DMA("DM", "DMA", "212", "ISO 3166-2:DM"),
    DOM("DO", "DOM", "214", "ISO 3166-2:DO"),
    COD("CD", "COD", "180", "ISO 3166-2:CD"),
    EGY("EG", "EGY", "818", "ISO 3166-2:EG"),
    ZMB("ZM", "ZMB", "894", "ISO 3166-2:ZM"),
    ESH("EH", "ESH", "732", "ISO 3166-2:EH"),
    ZWE("ZW", "ZWE", "716", "ISO 3166-2:ZW"),
    ISR("IL", "ISR", "376", "ISO 3166-2:IL"),
    IND("IN", "IND", "356", "ISO 3166-2:IN"),
    IDN("ID", "IDN", "360", "ISO 3166-2:ID"),
    JOR("JO", "JOR", "400", "ISO 3166-2:JO"),
    IRQ("IQ", "IRQ", "368", "ISO 3166-2:IQ"),
    IRN("IR", "IRN", "364", "ISO 3166-2:IR"),
    IRL("IE", "IRL", "372", "ISO 3166-2:IE"),
    ISL("IS", "ISL", "352", "ISO 3166-2:IS"),
    ESP("ES", "ESP", "724", "ISO 3166-2:ES"),
    ITA("IT", "ITA", "380", "ISO 3166-2:IT"),
    YEM("YE", "YEM", "887", "ISO 3166-2:YE"),
    CPV("CV", "CPV", "132", "ISO 3166-2:CV"),
    KAZ("KZ", "KAZ", "398", "ISO 3166-2:KZ"),
    CYM("KY", "CYM", "136", "ISO 3166-2:KY"),
    KHM("KH", "KHM", "116", "ISO 3166-2:KH"),
    CMR("CM", "CMR", "120", "ISO 3166-2:CM"),
    CAN("CA", "CAN", "124", "ISO 3166-2:CA"),
    QAT("QA", "QAT", "634", "ISO 3166-2:QA"),
    KEN("KE", "KEN", "404", "ISO 3166-2:KE"),
    CYP("CY", "CYP", "196", "ISO 3166-2:CY"),
    KGZ("KG", "KGZ", "417", "ISO 3166-2:KG"),
    KIR("KI", "KIR", "296", "ISO 3166-2:KI"),
    TWN("TW", "TWN", "158", "ISO 3166-2:TW"),
    PRK("KP", "PRK", "408", "ISO 3166-2:KP"),
    CHN("CN", "CHN", "156", "ISO 3166-2:CN"),
    CCK("CC", "CCK", "166", "ISO 3166-2:CC"),
    COL("CO", "COL", "170", "ISO 3166-2:CO"),
    COM("KM", "COM", "174", "ISO 3166-2:KM"),
    CRI("CR", "CRI", "188", "ISO 3166-2:CR"),
    CIV("CI", "CIV", "384", "ISO 3166-2:CI"),
    CUB("CU", "CUB", "192", "ISO 3166-2:CU"),
    KWT("KW", "KWT", "414", "ISO 3166-2:KW"),
    CUW("CW", "CUW", "531", "ISO 3166-2:CW"),
    LAO("LA", "LAO", "418", "ISO 3166-2:LA"),
    LVA("LV", "LVA", "428", "ISO 3166-2:LV"),
    LSO("LS", "LSO", "426", "ISO 3166-2:LS"),
    LBR("LR", "LBR", "430", "ISO 3166-2:LR"),
    LBN("LB", "LBN", "422", "ISO 3166-2:LB"),
    LBY("LY", "LBY", "434", "ISO 3166-2:LY"),
    LTU("LT", "LTU", "440", "ISO 3166-2:LT"),
    LIE("LI", "LIE", "438", "ISO 3166-2:LI"),
    LUX("LU", "LUX", "442", "ISO 3166-2:LU"),
    MUS("MU", "MUS", "480", "ISO 3166-2:MU"),
    MRT("MR", "MRT", "478", "ISO 3166-2:MR"),
    MDG("MG", "MDG", "450", "ISO 3166-2:MG"),
    MYT("YT", "MYT", "175", "ISO 3166-2:YT"),
    MAC("MO", "MAC", "446", "ISO 3166-2:MO"),
    MKD("MK", "MKD", "807", "ISO 3166-2:MK"),
    MWI("MW", "MWI", "454", "ISO 3166-2:MW"),
    MYS("MY", "MYS", "458", "ISO 3166-2:MY"),
    MLI("ML", "MLI", "466", "ISO 3166-2:ML"),
    MDV("MV", "MDV", "462", "ISO 3166-2:MV"),
    MLT("MT", "MLT", "470", "ISO 3166-2:MT"),
    MAR("MA", "MAR", "504", "ISO 3166-2:MA"),
    MTQ("MQ", "MTQ", "474", "ISO 3166-2:MQ"),
    MHL("MH", "MHL", "584", "ISO 3166-2:MH"),
    MEX("MX", "MEX", "484", "ISO 3166-2:MX"),
    FSM("FM", "FSM", "583", "ISO 3166-2:FM"),
    MOZ("MZ", "MOZ", "508", "ISO 3166-2:MZ"),
    MDA("MD", "MDA", "498", "ISO 3166-2:MD"),
    MCO("MC", "MCO", "492", "ISO 3166-2:MC"),
    MNG("MN", "MNG", "496", "ISO 3166-2:MN"),
    MSR("MS", "MSR", "500", "ISO 3166-2:MS"),
    MMR("MM", "MMR", "104", "ISO 3166-2:MM"),
    NAM("NA", "NAM", "516", "ISO 3166-2:NA"),
    NRU("NR", "NRU", "520", "ISO 3166-2:NR"),
    NPL("NP", "NPL", "524", "ISO 3166-2:NP"),
    NER("NE", "NER", "562", "ISO 3166-2:NE"),
    NGA("NG", "NGA", "566", "ISO 3166-2:NG"),
    NLD("NL", "NLD", "528", "ISO 3166-2:NL"),
    NIC("NI", "NIC", "558", "ISO 3166-2:NI"),
    NIU("NU", "NIU", "570", "ISO 3166-2:NU"),
    NZL("NZ", "NZL", "554", "ISO 3166-2:NZ"),
    NCL("NC", "NCL", "540", "ISO 3166-2:NC"),
    NOR("NO", "NOR", "578", "ISO 3166-2:NO"),
    ARE("AE", "ARE", "784", "ISO 3166-2:AE"),
    OMN("OM", "OMN", "512", "ISO 3166-2:OM"),
    BVT("BV", "BVT", "074", "ISO 3166-2:BV"),
    IMN("IM", "IMN", "833", "ISO 3166-2:IM"),
    COK("CK", "COK", "184", "ISO 3166-2:CK"),
    NFK("NF", "NFK", "574", "ISO 3166-2:NF"),
    CXR("CX", "CXR", "162", "ISO 3166-2:CX"),
    PCN("PN", "PCN", "612", "ISO 3166-2:PN"),
    SHN("SH", "SHN", "654", "ISO 3166-2:SH"),
    PAK("PK", "PAK", "586", "ISO 3166-2:PK"),
    PLW("PW", "PLW", "585", "ISO 3166-2:PW"),
    PSE("PS", "PSE", "275", "ISO 3166-2:PS"),
    PAN("PA", "PAN", "591", "ISO 3166-2:PA"),
    PNG("PG", "PNG", "598", "ISO 3166-2:PG"),
    PRY("PY", "PRY", "600", "ISO 3166-2:PY"),
    PER("PE", "PER", "604", "ISO 3166-2:PE"),
    POL("PL", "POL", "616", "ISO 3166-2:PL"),
    PRT("PT", "PRT", "620", "ISO 3166-2:PT"),
    PRI("PR", "PRI", "630", "ISO 3166-2:PR"),
    COG("CG", "COG", "178", "ISO 3166-2:CG"),
    KOR("KR", "KOR", "410", "ISO 3166-2:KR"),
    REU("RE", "REU", "638", "ISO 3166-2:RE"),
    RUS("RU", "RUS", "643", "ISO 3166-2:RU"),
    RWA("RW", "RWA", "646", "ISO 3166-2:RW"),
    ROU("RO", "ROU", "642", "ISO 3166-2:RO"),
    SLV("SV", "SLV", "222", "ISO 3166-2:SV"),
    WSM("WS", "WSM", "882", "ISO 3166-2:WS"),
    SMR("SM", "SMR", "674", "ISO 3166-2:SM"),
    STP("ST", "STP", "678", "ISO 3166-2:ST"),
    SAU("SA", "SAU", "682", "ISO 3166-2:SA"),
    SWZ("SZ", "SWZ", "748", "ISO 3166-2:SZ"),
    MNP("MP", "MNP", "580", "ISO 3166-2:MP"),
    SYC("SC", "SYC", "690", "ISO 3166-2:SC"),
    BLM("BL", "BLM", "652", "ISO 3166-2:BL"),
    MAF("MF", "MAF", "663", "ISO 3166-2:MF"),
    SPM("PM", "SPM", "666", "ISO 3166-2:PM"),
    SEN("SN", "SEN", "686", "ISO 3166-2:SN"),
    VCT("VC", "VCT", "670", "ISO 3166-2:VC"),
    KNA("KN", "KNA", "659", "ISO 3166-2:KN"),
    LCA("LC", "LCA", "662", "ISO 3166-2:LC"),
    SRB("RS", "SRB", "688", "ISO 3166-2:RS"),
    SGP("SG", "SGP", "702", "ISO 3166-2:SG"),
    SXM("SX", "SXM", "534", "ISO 3166-2:SX"),
    SYR("SY", "SYR", "760", "ISO 3166-2:SY"),
    SVK("SK", "SVK", "703", "ISO 3166-2:SK"),
    SVN("SI", "SVN", "705", "ISO 3166-2:SI"),
    SLB("SB", "SLB", "090", "ISO 3166-2:SB"),
    SOM("SO", "SOM", "706", "ISO 3166-2:SO"),
    SDN("SD", "SDN", "729", "ISO 3166-2:SD"),
    SUN("SU", "SUN", "810", "ISO 3166-2:SU", false),
    SUR("SR", "SUR", "740", "ISO 3166-2:SR"),
    USA("US", "USA", "840", "ISO 3166-2:US"),
    SLE("SL", "SLE", "694", "ISO 3166-2:SL"),
    TJK("TJ", "TJK", "762", "ISO 3166-2:TJ"),
    THA("TH", "THA", "764", "ISO 3166-2:TH"),
    TZA("TZ", "TZA", "834", "ISO 3166-2:TZ"),
    TCA("TC", "TCA", "796", "ISO 3166-2:TC"),
    TGO("TG", "TGO", "768", "ISO 3166-2:TG"),
    TKL("TK", "TKL", "772", "ISO 3166-2:TK"),
    TON("TO", "TON", "776", "ISO 3166-2:TO"),
    TTO("TT", "TTO", "780", "ISO 3166-2:TT"),
    TUV("TV", "TUV", "798", "ISO 3166-2:TV"),
    TUN("TN", "TUN", "788", "ISO 3166-2:TN"),
    TKM("TM", "TKM", "795", "ISO 3166-2:TM"),
    TUR("TR", "TUR", "792", "ISO 3166-2:TR"),
    UGA("UG", "UGA", "800", "ISO 3166-2:UG"),
    UZB("UZ", "UZB", "860", "ISO 3166-2:UZ"),
    UKR("UA", "UKR", "804", "ISO 3166-2:UA"),
    WLF("WF", "WLF", "876", "ISO 3166-2:WF"),
    URY("UY", "URY", "858", "ISO 3166-2:UY"),
    FRO("FO", "FRO", "234", "ISO 3166-2:FO"),
    FJI("FJ", "FJI", "242", "ISO 3166-2:FJ"),
    PHL("PH", "PHL", "608", "ISO 3166-2:PH"),
    FIN("FI", "FIN", "246", "ISO 3166-2:FI"),
    FLK("FK", "FLK", "238", "ISO 3166-2:FK"),
    FRA("FR", "FRA", "250", "ISO 3166-2:FR"),
    PYF("PF", "PYF", "258", "ISO 3166-2:PF"),
    ATF("TF", "ATF", "260", "ISO 3166-2:TF"),
    HMD("HM", "HMD", "334", "ISO 3166-2:HM"),
    HRV("HR", "HRV", "191", "ISO 3166-2:HR"),
    CAF("CF", "CAF", "140", "ISO 3166-2:CF"),
    TCD("TD", "TCD", "148", "ISO 3166-2:TD"),
    MNE("ME", "MNE", "499", "ISO 3166-2:ME"),
    CZE("CZ", "CZE", "203", "ISO 3166-2:CZ"),
    CHL("CL", "CHL", "152", "ISO 3166-2:CL"),
    CHE("CH", "CHE", "756", "ISO 3166-2:CH"),
    SWE("SE", "SWE", "752", "ISO 3166-2:SE"),
    SJM("SJ", "SJM", "744", "ISO 3166-2:SJ"),
    LKA("LK", "LKA", "144", "ISO 3166-2:LK"),
    ECU("EC", "ECU", "218", "ISO 3166-2:EC"),
    GNQ("GQ", "GNQ", "226", "ISO 3166-2:GQ"),
    ERI("ER", "ERI", "232", "ISO 3166-2:ER"),
    EST("EE", "EST", "233", "ISO 3166-2:EE"),
    ETH("ET", "ETH", "231", "ISO 3166-2:ET"),
    ZAF("ZA", "ZAF", "710", "ISO 3166-2:ZA"),
    SGS("GS", "SGS", "239", "ISO 3166-2:GS"),
    SSD("SS", "SSD", "728", "ISO 3166-2:SS"),
    JAM("JM", "JAM", "388", "ISO 3166-2:JM"),
    JPN("JP", "JPN", "392", "ISO 3166-2:JP"),
    YUG("YU", "YUG", "891", "ISO 3166-2:YU", false),
    XKX("XK", "XKX", "UNDEF", "UNDEF"),
    OTHR("OTHR", "OTHR", "OTHR", "OTHR", false);
    //
    ;

    private final String alpha2Code;
    private final String alpha3Code;
    private final String digitalCode;
    private final String isoCode;
    private final boolean actual;

    //

    private Country(String alpha2Code, String alpha3Code, String digitalCode, String isoCode, boolean actual) {
	this.alpha2Code = Objects.requireNonNull(alpha2Code);
	this.alpha3Code = Objects.requireNonNull(alpha3Code);
	this.digitalCode = Objects.requireNonNull(digitalCode);
	this.isoCode = Objects.requireNonNull(isoCode);
	this.actual = actual;
    }

    private Country(String alpha2Code, String alpha3Code, String digitalCode, String isoCode) {
	this.alpha2Code = Objects.requireNonNull(alpha2Code);
	this.alpha3Code = Objects.requireNonNull(alpha3Code);
	this.digitalCode = Objects.requireNonNull(digitalCode);
	this.isoCode = Objects.requireNonNull(isoCode);
	this.actual = true;
    }

    //

    public static final Stream<Country> valuesStream() {
	return Stream.of(values());
    }

    //

    private static final Predicate<Country> SELECTABLE_FILTER = Country::isActual;

    public static final Country[] selectableValues() {
	return valuesStream() //
		.filter(SELECTABLE_FILTER) //
		.toArray(Country[]::new);
    }

    private static final Predicate<Country> NON_SELECTABLE_FILTER = SELECTABLE_FILTER.negate();

    public static final Country[] nonSelectableValues() {
	return valuesStream() //
		.filter(NON_SELECTABLE_FILTER) //
		.toArray(Country[]::new);
    }

    //

    public static Country forDigit(int digitalCode) {
	return forDigitalCode(String.valueOf(digitalCode));
    }

    public static Country forDigitalCode(String digitalCode) {
	return valuesStream() //
		.filter(x -> x.digitalCode.equals(digitalCode)) //
		.findAny() //
		.orElse(null);
    }

    public static Country forAlpha2Code(String alpha2Code) {
	return valuesStream() //
		.filter(x -> x.alpha2Code.equals(alpha2Code)) //
		.findAny() //
		.orElse(null);
    }

    public static Country forAlpha3Code(String alpha3Code) {
	return valuesStream() //
		.filter(x -> x.alpha3Code.equals(alpha3Code)) //
		.findAny() //
		.orElse(null);
    }

    public static Country forISOCode(String isoCode) {
	return valuesStream() //
		.filter(x -> x.isoCode.equals(isoCode)) //
		.findAny() //
		.orElse(null);
    }

    // GENERATED

    public String getAlpha2Code() {
	return alpha2Code;
    }

    public String getAlpha2CodeLowercase() {
	return alpha2Code.toLowerCase();
    }

    public String getAlpha3Code() {
	return alpha3Code;
    }

    public String getAlpha3CodeLowercase() {
	return alpha3Code.toLowerCase();
    }

    public String getDigitalCode() {
	return digitalCode;
    }

    public String getISOCode() {
	return isoCode;
    }

    public boolean isActual() {
	return actual;
    }
}
