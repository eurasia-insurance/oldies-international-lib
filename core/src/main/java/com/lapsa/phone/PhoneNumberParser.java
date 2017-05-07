package com.lapsa.phone;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PhoneNumberParser {

    private static CountryCode identifyCountryCode(final String num, boolean forceException, final String raw)
	    throws PhoneFormatException {
	CountryCode pcc = CountryCode.getByPhonePrefix(num);
	// Если force то обязатльно должно быть совпадение по базе кодов иначе
	// ошибка
	if (pcc == null && forceException)
	    throw new PhoneFormatException(
		    String.format("Invalid number format. Country code prefix for number '%1$s' not found", raw));

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
	    return new PhoneNumber(cc, areaNumber, phoneNumber);
	} else {
	    return new PhoneNumber(cc, "", numberWithoutCountryCode);
	}
    }

    // format +7(701)9377979
    private static final Pattern PLUS_WITH_AREA = Pattern.compile("^\\+(\\d+)\\((\\d+)\\)(\\d+)$");

    private static PhoneNumber checkPlusWithArea(final String raw) throws PhoneFormatException {
	final String plain = raw2plain(raw);
	Matcher m = PLUS_WITH_AREA.matcher(plain);
	if (!m.matches())
	    return null;
	String ccNumber = m.group(1);
	String areaNumber = m.group(2);
	String phoneNumber = m.group(3);

	CountryCode cc = identifyCountryCode(ccNumber, areaNumber, true, raw);

	return new PhoneNumber(cc, areaNumber, phoneNumber);
    }

    // format 7(701)9377979
    private static Pattern NO_PLUS_WITH_AREA = Pattern.compile("^(\\d+)\\((\\d+)\\)(\\d+)$");

    private static PhoneNumber checkNoPlusWithArea(final String raw) throws PhoneFormatException {
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

	return new PhoneNumber(cc, areaNumber, phoneNumber);
    }

    // format +77019377979
    private static Pattern PLUS_NO_AREA = Pattern.compile("^\\+(\\d+)$");

    private static PhoneNumber checkPlusNoArea(final String raw) throws PhoneFormatException {
	final String plain = raw2plain(raw);
	Matcher m = PLUS_NO_AREA.matcher(plain);
	if (!m.matches())
	    return null;

	String fullNumber = m.group(1);
	CountryCode cc = identifyCountryCode(fullNumber, true, raw);

	return processFullNumber(cc, fullNumber, raw);
    }

    // format 77019377979
    private static Pattern NO_PLUS_NO_AREA = Pattern.compile("^\\d+$");

    private static PhoneNumber checNoPlusNoArea(final String raw) throws PhoneFormatException {
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

	return new PhoneNumber(raw);
    }

    private static String raw2plain(final String raw) {
	return raw.replaceAll("[\\s\\-]", "");
    }

    static PhoneNumber parse(final String raw) {
	PhoneNumber pn = null;
	try {
	    pn = checkPlusWithArea(raw);
	} catch (PhoneFormatException ignored) {
	}
	if (pn != null)
	    return pn;
	try {
	    pn = checkNoPlusWithArea(raw);
	} catch (PhoneFormatException ignored) {
	}
	if (pn != null)
	    return pn;
	try {
	    pn = checkPlusNoArea(raw);
	} catch (PhoneFormatException ignored) {
	}
	if (pn != null)
	    return pn;
	try {
	    pn = checNoPlusNoArea(raw);
	} catch (PhoneFormatException ignored) {
	}
	if (pn != null)
	    return pn;
	return new PhoneNumber(raw);
    }
}
