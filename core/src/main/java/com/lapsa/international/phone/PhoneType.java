package com.lapsa.international.phone;

import com.lapsa.international.InternationalLocalizedElement;

public enum PhoneType implements InternationalLocalizedElement {
    MAIN("fa-phone"), // основной телефон
    FAX("fa-fax"), // телефон факса
    MOBILE("fa-mobile"), // мобильный телефон
    WORK("fa-phone"), // рабочий телефон
    HOME("fa-phone"), // домашний телефон
    //
    ;

    private final String fontAwesomeCodeIcon;

    //

    private PhoneType(String fontAwesomeCode) {
	this.fontAwesomeCodeIcon = fontAwesomeCode;
    }

    //

    public static final Stream<PhoneType> valuesStream() {
	return Stream.of(values());
    }

    // GENERATED

    public String getFontAwesomeIcon() {
	return fontAwesomeCodeIcon;
    }
}
