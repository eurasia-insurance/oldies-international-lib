package com.lapsa.phone.faces.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.lapsa.phone.PhoneFormatException;
import com.lapsa.phone.PhoneNumber;
import com.lapsa.phone.PhoneNumberFactoryProvider;

@FacesConverter(forClass = PhoneNumber.class)
public class PhoneNumberConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
	if (value == null || value.isEmpty())
	    return null;
	try {
	    return PhoneNumberFactoryProvider.provideDefault().parse(value);
	} catch (PhoneFormatException e) {
	    return null;
	}
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
	if (value == null || !(value instanceof PhoneNumber))
	    return null;
	PhoneNumber pn = (PhoneNumber) value;
	return pn.getFormatted();
    }
}
