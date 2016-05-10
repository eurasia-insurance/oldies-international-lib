package com.lapsa.phone;

public class DefaultPhoneNumberFactory implements PhoneNumberFactory {

    public CountryCode identifyCountryCode(final String num, boolean force) throws PhoneFormatException {
	CountryCode pcc = CountryCode.getByPhonePrefix(num);
	// Если force то обязатльно должно быть совпадение по базе кодов иначе
	// ошибка
	if (pcc == null && force)
	    throw new PhoneFormatException(
		    String.format("Invalid number format. Country code prefix for number '%1$s' not found", num));

	// возвращаем либо наденный код либо null
	return pcc;
    }

    private String stripHeading8(String number) {
	if (number.startsWith("8")) {
	    // то нужно проверить, может быть это код страны начинающийся с
	    // символа "8"
	    CountryCode pcc = CountryCode.getByPhonePrefix(number);
	    if (pcc == null)
		// если не код страны, то тогда это локальное правило набора
		// цифры "8" для выхода на другие area codes
		// поэтому меняем локальную "8" на международную "7"
		return "7" + number.substring(1);
	}
	return number;

    }

    @Override
    public PhoneNumber parse(String format) throws PhoneFormatException {
	return parse(format, null, false);
    }

    @Override
    public PhoneNumber parse(String format, CountryCode defaultCountryCode) throws PhoneFormatException {
	return parse(format, defaultCountryCode, false);
    }

    @Override
    public PhoneNumber parse(String format, boolean strict) throws PhoneFormatException {
	return parse(format, null, strict);
    }

    @Override
    public PhoneNumber parse(String format, CountryCode defaultCountryCode, boolean strict)
	    throws PhoneFormatException {
	// получаем plain number
	// plain number содержит только цифры и символ "+" в начале, если он
	// нужен
	String tail = format.replaceAll("[^\\d\\+]", "");
	boolean hasPlus = tail.startsWith("+");
	tail = tail.replaceAll("^\\+", "");

	if (!hasPlus)
	    tail = stripHeading8(tail);

	CountryCode pcc = null;
	if (pcc == null)
	    pcc = identifyCountryCode(tail, strict ? hasPlus : strict);

	if (pcc == null && defaultCountryCode != null)
	    pcc = defaultCountryCode;

	if (pcc == null && !strict)
	    pcc = CountryCode.getFirstByCode(tail);

	if (pcc == null && strict)
	    // по всей видимости задан "короткий" номер без кодов стран и т.п нл
	    // при этом не задана страна по умолчанию
	    throw new PhoneFormatException("Invalid number foramat. Can't recognize country code number");

	// если номер не короткий и есть код страны, то убираем его из
	// "хвоста"
	tail = tail.substring(pcc.getPhoneCode().length());

	return create(pcc, tail);
    }

    // TODO Криво. Переделать.
    @Override
    public PhoneNumber create(CountryCode country, String number) throws PhoneFormatException {
	String areaCode = number.substring(0, 3);
	String num = number.substring(3);
	return new PhoneNumber(country, areaCode, num);
    }

}
