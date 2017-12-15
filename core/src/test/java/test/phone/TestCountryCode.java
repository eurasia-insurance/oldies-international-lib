package test.phone;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import com.lapsa.international.country.Country;
import com.lapsa.international.phone.CountryCode;

public class TestCountryCode {

    @Test
    public void testCountyLinks() {
	for (final CountryCode cc : CountryCode.values())
	    assertThat(String.format(//
		    "%1$s.%2$s is not linked to a %3$s entity", //
		    cc.getClass().getName(), // $1
		    cc.name(), // $2
		    Country.class.getName() // $3
	    ), cc.getCountry(), not(nullValue()));
    }
}
