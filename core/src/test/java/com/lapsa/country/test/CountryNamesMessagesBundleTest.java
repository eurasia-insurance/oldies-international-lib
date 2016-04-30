package com.lapsa.country.test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

import com.lapsa.country.Country;

public class CountryNamesMessagesBundleTest {

    @Test
    public void testRussianBundle() {
	ResourceBundle resources = ResourceBundle.getBundle(Country.BUNDLE_BASENAME, Locale.forLanguageTag("ru"));
	assertThat(resources, not(nullValue()));

	for (Country c : Country.values()) {
	    String name = resources.getString(String.format("%s.%s", c.getClass().getName(), c.name()));
	    assertThat(name, not(nullValue()));
	}
    }

    @Test
    public void testKazakhBundle() {
	ResourceBundle resources = ResourceBundle.getBundle(Country.BUNDLE_BASENAME, Locale.forLanguageTag("kk"));
	assertThat(resources, not(nullValue()));

	for (Country c : Country.values()) {
	    String name = resources.getString(String.format("%s.%s", c.getClass().getName(), c.name()));
	    assertThat(name, not(nullValue()));
	}
    }

    @Test
    public void testEnglishBundle() {
	ResourceBundle resources = ResourceBundle.getBundle(Country.BUNDLE_BASENAME, Locale.ENGLISH);
	assertThat(resources, not(nullValue()));
	for (Country c : Country.values()) {
	    String name = resources.getString(String.format("%s.%s", c.getClass().getName(), c.name()));
	    assertThat(name, not(nullValue()));
	}
    }
}
