package code;

import com.lapsa.international.country.Country;
import com.lapsa.international.phone.CountryCode;

public class CodeGenerator {

    public static void main(final String[] args) {
	final CodeGenerator p = new CodeGenerator();
	p.generatePhoneCCodeEnum();
	p.generateCountryEnum();
    }

    public void generatePhoneCCodeEnum() {
	System.out.println(String.format("-------- %s --------", CountryCode.class.getName()));
	boolean first = true;
	for (final String countryCode : CCode.getPhoneCountries()) {
	    if (!first)
		System.out.println(",");
	    final String phoneCode = CCode.getPhoneCode(countryCode);
	    final String[] phonePrefixes = CCode.getPhonePrefixes(countryCode);
	    System.out.print(String.format("%1$s(\"%1$s\", \"%2$s\"", countryCode, phoneCode));
	    for (final String prefix : phonePrefixes)
		System.out.print(String.format(", \"%1$s\"", prefix));
	    System.out.print(")");
	    first = false;
	}
	System.out.println(";");

    }

    public void generateCountryEnum() {
	System.out.println(String.format("-------- %s --------", Country.class.getName()));
	boolean first = true;
	for (final Country c : Country.values()) {

	    if (!first)
		System.out.println(",");
	    System.out.print(String.format("%2$s(\"%1$s\", \"%2$s\", \"%3$s\", \"%4$s\")", c.getAlpha2Code(),
		    c.getAlpha3Code(), c.getDigitalCode(), c.getISOCode()));

	    System.out.print(")");
	    first = false;
	}
	System.out.println(";");
    }
}
