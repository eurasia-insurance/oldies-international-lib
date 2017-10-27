package com.lapsa.international.phone;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.lapsa.international.phone.converter.jaxb.JAXBPhoneNumberAdapter;

import tech.lapsa.java.commons.function.MyObjects;

@XmlJavaTypeAdapter(JAXBPhoneNumberAdapter.class)
public abstract class PhoneNumber implements Serializable {

    private static final long serialVersionUID = 1L;

    public abstract String getFormatted();

    public abstract String getPlain();

    public abstract CountryCode getCountryCode();

    public abstract String getAreaCode();

    public abstract String getPhoneNumber();

    private static final Pattern ONLY_NUMBERS_PATTERN = Pattern.compile("^\\d*$");

    public static String requireOnlyNumbers(String value, String message) throws PhoneFormatException {
	if (!ONLY_NUMBERS_PATTERN.matcher(value).matches())
	    throw new PhoneFormatException(message);
	return value;
    }

    public static String requireOnlyNumbers(String value) throws PhoneFormatException {
	return requireOnlyNumbers(value, String.format("Invalid characters found at '%1$s'", value));
    }

    private static CountryCode identifyCountryCode(final String num, boolean forceException, final String raw)
	    throws PhoneFormatException {
	CountryCode pcc = CountryCode.getByPhonePrefix(num);
	// Если force то обязатльно должно быть совпадение по базе кодов иначе
	// ошибка
	if (pcc == null && forceException)
	    throw new PhoneFormatException(String.format("There is no country code at '%1$s'", raw));

	// возвращаем либо наденный код либо null
	return pcc;
    }

    private static CountryCode identifyCountryCode(String ccNumber, String areaNumber, boolean forceException,
	    final String raw)
	    throws PhoneFormatException {
	return identifyCountryCode(ccNumber + areaNumber, forceException, raw);
    }

    private static PhoneNumber processFullNumber(final CountryCode cc, final String fullNumber, final String raw)
	    throws PhoneFormatException {
	String numberWithoutCountryCode = fullNumber.substring(cc.getPhoneCode().length());
	if (cc.getDefaultAreaCodeLength() > 0
		&& numberWithoutCountryCode.length() >= cc.getDefaultAreaCodeLength()) {
	    String areaNumber = numberWithoutCountryCode.substring(0, cc.getDefaultAreaCodeLength());
	    String phoneNumber = numberWithoutCountryCode.substring(cc.getDefaultAreaCodeLength());
	    return new PhoneNumberComplete(cc, areaNumber, phoneNumber);
	}
	return new PhoneNumberComplete(cc, "", numberWithoutCountryCode);
    }

    // format +7(701)9377979
    private static final Pattern PLUSORZERO_WITH_AREA = Pattern.compile("^(?:\\+|0+)(\\d*)\\((\\d*)\\)(\\d*)$");

    private static PhoneNumber checkPlusOrZeroWithArea(final String raw) throws PhoneFormatException {
	final String plain = raw2plain(raw);
	Matcher m = PLUSORZERO_WITH_AREA.matcher(plain);
	if (!m.matches())
	    return null;
	String ccNumber = m.group(1);
	String areaNumber = m.group(2);
	String phoneNumber = m.group(3);

	CountryCode cc = identifyCountryCode(ccNumber, areaNumber, true, raw);

	return new PhoneNumberComplete(cc, areaNumber, phoneNumber);
    }

    // format 7(701)9377979
    private static Pattern NO_PLUS_WITH_AREA = Pattern.compile("^(\\d*)\\((\\d*)\\)(\\d*)$");

    private static PhoneNumber checkNOPlusOrZeroWithArea(final String raw) throws PhoneFormatException {
	final String plain = raw2plain(raw);
	Matcher m = NO_PLUS_WITH_AREA.matcher(plain);
	if (!m.matches())
	    return null;
	String ccNumber = m.group(1);
	String areaNumber = m.group(2);
	String phoneNumber = m.group(3);

	if ("8".equals(ccNumber))
	    ccNumber = "7";

	CountryCode cc = identifyCountryCode(ccNumber, areaNumber, true, raw);

	return new PhoneNumberComplete(cc, areaNumber, phoneNumber);
    }

    // format +77019377979
    private static Pattern PLUSORZERO_NO_AREA = Pattern.compile("^(?:\\+|0+)(\\d+)$");

    private static PhoneNumber checkPlusOrZeroNOArea(final String raw) throws PhoneFormatException {
	final String plain = raw2plain(raw);
	Matcher m = PLUSORZERO_NO_AREA.matcher(plain);
	if (!m.matches())
	    return null;

	String fullNumber = m.group(1);
	CountryCode cc = identifyCountryCode(fullNumber, true, raw);

	return processFullNumber(cc, fullNumber, raw);
    }

    // format 77019377979
    private static Pattern NO_PLUS_NO_AREA = Pattern.compile("^\\d+$");

    private static PhoneNumber checNOPlusOrZeroNOArea(final String raw) throws PhoneFormatException {
	final String plain = raw2plain(raw);
	Matcher m = NO_PLUS_NO_AREA.matcher(plain);
	if (!m.matches())
	    return null;

	String fullNumber = plain;

	{ // сначала ищем совпадение даже если в начале "8"
	    CountryCode cc = identifyCountryCode(fullNumber, false, raw);
	    if (cc != null)
		return processFullNumber(cc, fullNumber, raw);
	}

	// если совпадения не найдено, ищем заменяя 8 на 7
	if (fullNumber.startsWith("8")) {
	    fullNumber = "7" + fullNumber.substring(1);

	    CountryCode cc = identifyCountryCode(fullNumber, false, raw);
	    if (cc != null)
		return processFullNumber(cc, fullNumber, raw);
	}

	return null;
    }

    private static String raw2plain(final String raw) {
	return raw.replaceAll("[\\s\\-]", "");
    }

    public static PhoneNumber parseStrict(final String raw) throws PhoneFormatException {
	PhoneNumber pn = null;
	pn = checkPlusOrZeroWithArea(raw);
	if (pn != null)
	    return pn;
	pn = checkPlusOrZeroNOArea(raw);
	if (pn != null)
	    return pn;
	pn = checkNOPlusOrZeroWithArea(raw);
	if (pn != null)
	    return pn;
	pn = checNOPlusOrZeroNOArea(raw);
	if (pn != null)
	    return pn;
	throw new PhoneFormatException(String.format("Invalid phone format at '%1$s'", raw));
    }

    public static PhoneNumber parse(final String raw) {
	try {
	    return parseStrict(raw);
	} catch (PhoneFormatException e) {
	    return new PhoneNumberUncomplete(raw);
	}
    }

    public static PhoneNumber of(CountryCode countryCode, String areaCode, String phoneNumber) {
	return new PhoneNumberComplete(countryCode, areaCode, phoneNumber);
    }

    private static final class PhoneNumberComplete extends PhoneNumber {

	private static final long serialVersionUID = 1L;

	private static final String DEFAULT_FORMATTED_FORMAT = "+%1$s (%2$s) %3$s";
	private static final String DEFAULT_PLAIN_FORMAT = "%1$s%2$s%3$s";

	private final CountryCode countryCode;
	private final String areaCode;
	private final String phoneNumber;

	private PhoneNumberComplete(CountryCode countryCode, String areaCode, String phoneNumber) {
	    MyObjects.requireNonNull(countryCode, "Country code can not be null");
	    MyObjects.requireNonNull(countryCode, "Area code can not be null");
	    MyObjects.requireNonNull(phoneNumber, "Phone number can not be null");
	    this.countryCode = countryCode;
	    this.areaCode = areaCode;
	    this.phoneNumber = phoneNumber;
	}

	public boolean isComplete() {
	    return countryCode != null && areaCode != null && phoneNumber != null;
	}

	@Override
	public int hashCode() {
	    return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
	    return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public String toString() {
	    return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
	}

	@Override
	public String getFormatted() {
	    if (!isComplete())
		return getPlain();
	    String ret = String.format(DEFAULT_FORMATTED_FORMAT, countryCode.getPhoneCode(), areaCode, phoneNumber);
	    ret = ret.replaceAll("\\(\\s*\\)", "");
	    ret = ret.trim();
	    ret = ret.replaceAll("\\s+", " ");
	    return ret;
	}

	@Override
	public String getPlain() {
	    return String.format(DEFAULT_PLAIN_FORMAT, //
		    countryCode == null ? "" : countryCode.getPhoneCode(), // 1
		    areaCode == null ? "" : areaCode, // 2
		    phoneNumber == null ? "" : phoneNumber // 3
	    ).replaceAll("\\s+", " ").trim();
	}

	// GENERATED

	@Override
	public CountryCode getCountryCode() {
	    return countryCode;
	}

	@Override
	public String getAreaCode() {
	    return areaCode;
	}

	@Override
	public String getPhoneNumber() {
	    return phoneNumber;
	}
    }

    private static final class PhoneNumberUncomplete extends PhoneNumber {

	private static final long serialVersionUID = 1L;

	private final String raw;

	private PhoneNumberUncomplete(String raw) {
	    MyObjects.requireNonNull(raw, "Phone number code can not be null");
	    this.raw = raw;
	}

	@Override
	public int hashCode() {
	    return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
	    return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public String toString() {
	    return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
	}

	@Override
	public String getFormatted() {
	    return raw;
	}

	@Override
	public String getPlain() {
	    return raw;
	}

	@Override
	public CountryCode getCountryCode() {
	    return null;
	}

	@Override
	public String getAreaCode() {
	    return null;
	}

	@Override
	public String getPhoneNumber() {
	    return null;
	}

    }
}
