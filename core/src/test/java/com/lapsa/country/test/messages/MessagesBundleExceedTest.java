package com.lapsa.country.test.messages;

import static org.junit.Assert.*;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

import com.lapsa.country.Country;
import com.lapsa.country.LocalizedElement;
import com.lapsa.localization.LocalizationLanguage;
import com.lapsa.phone.PhoneType;

public class MessagesBundleExceedTest extends BaseMessagesBundleTest {

    public static final String BUNDLE_BASENAME = LocalizedElement.BUNDDLE_BASE_NAME;

    @Test
    public void testNoExcessRecordsRussian() {
	Locale locale = getLocale(LANG_RU);
	ResourceBundle resources = getResourceBundle(BUNDLE_BASENAME, locale);
	testBundle(resources);
    }

    @Test
    public void testNoExcessRecordsKazakh() {
	Locale locale = getLocale(LANG_KK);
	ResourceBundle resources = getResourceBundle(BUNDLE_BASENAME, locale);
	testBundle(resources);
    }

    @Test
    public void testNoExcessRecordsEnglish() {
	Locale locale = getLocale(LANG_EN);
	ResourceBundle resources = getResourceBundle(BUNDLE_BASENAME, locale);
	testBundle(resources);
    }

    private void testBundle(ResourceBundle resources) {
	Enumeration<String> keys = resources.getKeys();
	while (keys.hasMoreElements()) {
	    String key = keys.nextElement();
	    if (findByFullName(Country.values(), key) != null)
		continue;
	    if (findByFullName(PhoneType.values(), key) != null)
		continue;
	    if (findByFullName(LocalizationLanguage.values(), key) != null)
		continue;
	    fail(String.format("Resource bunddle key '%1$s' is not present", key));
	}
    }

    private <T extends Enum<?>> T findByFullName(T[] values, String key) {
	for (T c : values) {
	    String name = String.format("%s.%s", c.getClass().getName(), c.name());
	    if (name.equals(key))
		return c;
	    String shrt = String.format("%s.%s.short", c.getClass().getName(), c.name());
	    if (shrt.equals(key))
		return c;
	}
	return null;
    }
}
