package test.com.lapsa.phone;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.lapsa.phone.CountryCode;
import com.lapsa.phone.PhoneFormatException;
import com.lapsa.phone.PhoneNumber;
import com.lapsa.phone.PhoneNumberFactory;
import com.lapsa.phone.PhoneNumberFactoryProvider;

public class TestPhoneNumber {

    private static Logger logger;

    private PhoneNumberFactory factory;

    @BeforeClass
    public static void init() {
	logger = Logger.getAnonymousLogger();
    }

    @Before
    public void beforeTest() {
	factory = PhoneNumberFactoryProvider.provideDefault();
    }

    private static void printFormat(PhoneNumber a) {
	logger.info(String.format("Formatted: '%1$s' Plain: '%2$s'", //
		a.getFormatted(), // $1
		a.getNumbered() // $2
	));
	logger.info(String.format(//
		"Country code: %1$s Country number: %2$s Area code: %3$s Number: %4$s", //
		a.getCountryCode().name(), // $1
		a.getCountryCode().getPhoneCode(), // $2
		a.getAreaCode(), // $3
		a.getNumber() // $4
	));
    }

    private void testStrict(String value, PhoneNumber expecting, String expectingFormat) throws PhoneFormatException {
	PhoneNumber a = factory.parse(value);
	printFormat(a);
	assertThat(a, allOf(not(nullValue()), is(equalTo(expecting))));
	assertThat(a.getFormatted(), allOf(not(nullValue()), is(equalTo(expectingFormat))));
    }

    @Test
    public void testStrictFormat1() {
	try {
	    testStrict(" 8 (7272)-530721 ", new PhoneNumber(CountryCode.KZ, "727", "2530721"), "+7 (727) 2530721");
	} catch (PhoneFormatException e) {
	    fail(e.getMessage());
	}
    }

    @Test
    public void testStrictFormatRU1() {
	try {
	    testStrict(" 8 (963)-777-79 79", new PhoneNumber(CountryCode.RU, "963", "7777979"), "+7 (963) 7777979");
	} catch (PhoneFormatException e) {
	    fail(e.getMessage());
	}
    }

    @Test
    public void testStrictFormat2() {
	try {
	    testStrict(" 8 (727)2-530721 ", new PhoneNumber(CountryCode.KZ, "727", "2530721"), "+7 (727) 2530721");
	} catch (PhoneFormatException e) {
	    fail(e.getMessage());
	}
    }

    @Test(expected = PhoneFormatException.class)
    public void testStrictFormat3() throws PhoneFormatException {
	testStrict(" 8 (2272)-530721 ", new PhoneNumber(CountryCode.KR, "272", "530721"), "+82 (272) 530721");
    }

    @Test
    public void testStrictFormat4() {
	try {
	    testStrict(" 8 (701)937-7979", new PhoneNumber(CountryCode.KZ, "701", "9377979"), "+7 (701) 9377979");
	} catch (PhoneFormatException e) {
	    fail(e.getMessage());
	}
    }

    @Test
    public void testStrictParseFormat() {
	String[] numbers = new String[] { " 8 (7272)-530721 ", "+1 268-464-1234", "+56(7)9377979", "494357019377979",
		"87272530721", "+218 91-2345678", "962 7 9012 3456 " };

	String[] formatted = new String[] { "+7 (727) 2530721", "+1 (268) 4641234", "+56 (793) 77979",
		"+49 (435) 7019377979", "+7 (727) 2530721", "+218 (912) 345678", "+962 (790) 123456" };

	for (int i = 0; i < numbers.length; i++) {
	    String num = numbers[i];
	    String frm = formatted[i];
	    PhoneNumber a = factory.parse(num);
	    printFormat(a);
	    assertThat(a, not(nullValue()));
	    assertThat(a.getFormatted(), allOf(not(nullValue()), is(equalTo(frm))));
	}
    }
}
