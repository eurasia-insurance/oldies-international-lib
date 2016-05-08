package com.lapsa.phone.faces.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.lapsa.phone.CountryCode;
import com.lapsa.phone.PhoneFormatException;
import com.lapsa.phone.PhoneNumber;
import com.lapsa.phone.PhoneNumberFactory;

@FacesConverter(forClass = PhoneNumber.class)
public class PhoneNumberConverter implements Converter {

    @Inject
    private PhoneNumberFactory phoneNumberFactory;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
	if (value == null || value.isEmpty())
	    return null;
	try {
	    return phoneFactory.parse(value, CountryCode.KZ);
	} catch (PhoneFormatException e) {
	    throw new ConverterException(e);
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
