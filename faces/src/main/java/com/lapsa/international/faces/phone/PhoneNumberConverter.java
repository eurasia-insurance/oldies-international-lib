package com.lapsa.international.faces.phone;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.lapsa.international.phone.PhoneNumber;

import tech.lapsa.java.commons.function.MyObjects;
import tech.lapsa.java.commons.function.MyOptionals;

@FacesConverter(forClass = PhoneNumber.class)
public class PhoneNumberConverter implements Converter {

    @Override
    public Object getAsObject(final FacesContext context, final UIComponent component, final String value) {
	return MyOptionals.of(value) //
		.map(PhoneNumber::assertValid) //
		.orElse(null);
    }

    @Override
    public String getAsString(final FacesContext context, final UIComponent component, final Object value) {
	return MyOptionals.of(value) //
		.map(MyObjects.cast(PhoneNumber.class)) //
		.map(PhoneNumber::getFormatted) //
		.orElse("");
    }
}
