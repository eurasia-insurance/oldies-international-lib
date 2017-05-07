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
	if (number.startsWith("8"))
	    return "7" + number.substring(1);
	return number;
    }

    @Override
    public PhoneNumber parse(final String raw) {
	return parse(raw, null, true);
    }

    @Override
    public PhoneNumber parse(final String raw, CountryCode defaultCountryCode) {
	return parse(raw, defaultCountryCode, true);
    }

    @Override
    public PhoneNumber parse(final String raw, boolean strict) {
	return parse(raw, null, strict);
    }

    private PhoneNumber parse(final String raw, CountryCode defaultCountryCode, boolean strict) {
	try {
	    // получаем plain number
	    // plain number содержит только цифры и символ "+" в начале, если он
	    // нужен
	    String tail = raw.replaceAll("[\\s\\-\\(\\)]", "");
	    boolean hasPlus = tail.startsWith("+");
	    tail = tail.replaceAll("^\\+", "");

	    if (!hasPlus)
		// Считаем, что если человек вводит номер телефона с цифры "8"
		// то
		// это
		// цифра для вызова междгорода. Поэтому ее мы убираем и заменяем
		// цифрой "7" (местные вызовы)
		// Если цифра "8" это начало кода страны, то такой номер должен
		// вводится начиная со знака "+"
		tail = stripHeading8(tail);

	    CountryCode pcc = null;
	    if (pcc == null)
		pcc = identifyCountryCode(tail, strict ? hasPlus : strict);

	    if (pcc == null && defaultCountryCode != null)
		pcc = defaultCountryCode;

	    if (pcc == null && !strict)
		pcc = CountryCode.getFirstByCode(tail);

	    if (pcc == null && strict)
		// по всей видимости задан "короткий" номер без кодов стран и
		// т.п нл
		// при этом не задана страна по умолчанию
		throw new PhoneFormatException("Invalid number foramat. Can't recognize country code number");

	    // если номер не короткий и есть код страны, то убираем его из
	    // "хвоста"
	    if (pcc != null)
		tail = tail.substring(pcc.getPhoneCode().length());

	    return create(pcc, tail, raw);
	} catch (PhoneFormatException e) {
	    return new PhoneNumber(null, null, null, raw);
	}
    }

    // TODO Криво. Переделать.
    // длина area code не всегда 3 знака
    // см. тут https://en.wikipedia.org/wiki/Telephone_numbering_plan#Area_code
    @Override
    public PhoneNumber create(CountryCode country, String number, String raw) {
	if (number == null)
	    return new PhoneNumber();
	String areaCode = (number.length() >= 3) ? number.substring(0, 3) : number;
	String num = (number.length() >= 3) ? number.substring(3) : "";
	return new PhoneNumber(country, areaCode, num, raw);
    }

    @Override
    public PhoneNumber create(CountryCode country, String number) {
	return create(country, number, null);
    }

}
