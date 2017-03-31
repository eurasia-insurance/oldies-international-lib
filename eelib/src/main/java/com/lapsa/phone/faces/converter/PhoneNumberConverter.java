package com.lapsa.phone.faces.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.lapsa.phone.PhoneNumber;

@FacesConverter(forClass = PhoneNumber.class)
public class PhoneNumberConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
	if (value == null || value.isEmpty())
	    return null;
	return PhoneNumber.fromString(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
	if (value == null)
	    return null;
	if (!(value instanceof PhoneNumber))
	    return null;
	return ((PhoneNumber) value).toString(true);
    }
}
