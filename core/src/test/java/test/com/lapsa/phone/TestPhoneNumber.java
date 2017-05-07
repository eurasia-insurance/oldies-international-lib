package test.com.lapsa.phone;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.ResourceBundle;
import java.util.logging.Logger;

import org.junit.BeforeClass;
import org.junit.Test;

import com.lapsa.country.Country;
import com.lapsa.phone.CountryCode;
import com.lapsa.phone.PhoneNumber;

public class TestPhoneNumber {

    private static Logger logger;
    private static ResourceBundle countries;

    @BeforeClass
    public static void init() {
	logger = Logger.getAnonymousLogger();
	countries = ResourceBundle.getBundle(Country.BUNDLE_BASENAME);
    }

    private static void printFormat(PhoneNumber a) {
	logger.info(String.format("Formatted: '%1$s' Plain: '%2$s'", //
		a.getFormatted(), // $1
		a.getPlain() // $2
	));
	logger.info(String.format(//
		"Country code: \"%1$s\" Country number: +%2$s Area code: \"%3$s\" Phone number: \"%4$s\"", //
		countries.getString(a.getCountryCode().getCountry().canonicalName()), // $1
		a.getCountryCode().getPhoneCode(), // $2
		a.getAreaCode(), // $3
		a.getPlain() // $4
	));
    }

    private void testStrict(String value, PhoneNumber expecting, String expectingFormat) {
	PhoneNumber a = PhoneNumber.fromString(value);
	printFormat(a);
	assertThat(a, allOf(not(nullValue()), is(equalTo(expecting))));
	assertThat(a.getFormatted(), allOf(not(nullValue()), is(equalTo(expectingFormat))));
    }

    @Test
    public void testStrictFormat1() {
	testStrict(" 8 (7272)-530721 ", new PhoneNumber(CountryCode.KZ, "7272", "530721"), "+7 (7272) 530721");
    }

    @Test
    public void testStrictFormatRU1() {
	testStrict(" 8 (963)-777-79 79", new PhoneNumber(CountryCode.RU, "963", "7777979"), "+7 (963) 7777979");
    }

    @Test
    public void testStrictFormat2() {
	testStrict(" 8 (727)2-530721 ", new PhoneNumber(CountryCode.KZ, "727", "2530721"), "+7 (727) 2530721");
    }

    @Test
    public void testStrictFormat3() {
	testStrict(" 8 (701)937-7979", new PhoneNumber(CountryCode.KZ, "701", "9377979"), "+7 (701) 9377979");
    }

    @Test
    public void testStrictParseFormat() {
	String[] numbers = new String[] { " 8 (7272)-530721 ", "+1 268-464-1234", "+56(7)9377979", "494357019377979",
		"87272530721" };

	String[] formatted = new String[] { "+7 (7272) 530721", "+1 (268) 4641234", "+56 (7) 9377979",
		"+49 (43) 57019377979", "+7 (727) 2530721" };

	for (int i = 0; i < numbers.length; i++) {
	    String num = numbers[i];
	    String frm = formatted[i];
	    PhoneNumber a = PhoneNumber.fromString(num);
	    printFormat(a);
	    assertThat(a, not(nullValue()));
	    assertThat(a.getFormatted(), allOf(not(nullValue()), is(equalTo(frm))));
	}
    }
}
