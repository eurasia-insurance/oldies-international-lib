package com.lapsa.phone;

import com.lapsa.country.InternationalLocalizationBundleBase;

public enum PhoneType implements InternationalLocalizationBundleBase {
    MAIN("fa-phone"), // основной телефон
    FAX("fa-fax"), // телефон факса
    MOBILE("fa-mobile"), // мобильный телефон
    WORK("fa-phone"), // рабочий телефон
    HOME("fa-phone"), // домашний телефон
    //
    ;

    private final String fontAwesomeCodeIcon;

    PhoneType(String fontAwesomeCode) {
	this.fontAwesomeCodeIcon = fontAwesomeCode;
    }

    @Override
    public String canonicalName() {
	return String.format("%1$s.%2$s", this.getClass().getName(), name());
    }

    public String getFontAwesomeIcon() {
	return fontAwesomeCodeIcon;
    }
}
