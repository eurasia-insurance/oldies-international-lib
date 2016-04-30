package com.lapsa.country.test.messages;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

import com.lapsa.country.Country;

public class MessagesBundleTest {

    @Test
    public void testNoExcessRecordsRussian() {
	Locale locale = Locale.forLanguageTag("ru");
	assertThat(locale.getLanguage(), allOf(not(nullValue()), is("ru")));
	ResourceBundle resources = ResourceBundle.getBundle(Country.BUNDLE_BASENAME, locale);
	assertThat(resources, not(nullValue()));
	assertThat(resources.getString("com.lapsa.country.Country.AND"), allOf(not(nullValue()), is("Андорра")));
	testBundle(resources);
    }

    @Test
    public void testNoExcessRecordsKazakh() {
	Locale locale = Locale.forLanguageTag("kk");
	assertThat(locale.getLanguage(), allOf(not(nullValue()), is("kk")));
	ResourceBundle resources = ResourceBundle.getBundle(Country.BUNDLE_BASENAME, locale);
	assertThat(resources, not(nullValue()));
	assertThat(resources.getString("com.lapsa.country.Country.TLS"), allOf(not(nullValue()), is("Шығыс Тимор")));
	testBundle(resources);
    }

    @Test
    public void testNoExcessRecordsEnglish() {
	Locale locale = Locale.forLanguageTag("en");
	assertThat(locale.getLanguage(), allOf(not(nullValue()), is("en")));
	ResourceBundle resources = ResourceBundle.getBundle(Country.BUNDLE_BASENAME, locale);
	assertThat(resources, not(nullValue()));
	assertThat(resources.getString("com.lapsa.country.Country.TLS"), allOf(not(nullValue()), is("Timor-Leste")));
	testBundle(resources);
    }

    private void testBundle(ResourceBundle resources) {
	Enumeration<String> keys = resources.getKeys();
	while (keys.hasMoreElements()) {
	    String key = keys.nextElement();
	    Country city = findByFullName(Country.values(), key);
	    if (city != null)
		continue;
	    fail(String.format("Resource bunddle key '%1$s' is not present", key));
	}
    }

    private <T extends Enum<?>> T findByFullName(T[] values, String key) {
	for (T c : values) {
	    String name = String.format("%s.%s", c.getClass().getName(), c.name());
	    if (name.equals(key))
		return c;
	}
	return null;
    }
}
