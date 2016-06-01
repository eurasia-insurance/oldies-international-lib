package com.lapsa.phone;

import com.lapsa.country.InternationalLocalizationBundleBase;

public enum PhoneType implements InternationalLocalizationBundleBase {
    MAIN, // основной телефон
    FAX, // телефон факса
    MOBILE, // мобильный телефон
    WORK, // рабочий телефон
    HOME, // домашний телефон
    //
    ;

    @Override
    public String canonicalName() {
	return String.format("%1$s.%2$s", this.getClass().getName(), name());
    }
}
