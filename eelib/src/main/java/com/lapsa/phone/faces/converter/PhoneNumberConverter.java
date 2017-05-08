package com.lapsa.phone.faces.converter;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.lapsa.phone.PhoneFormatException;
import com.lapsa.phone.PhoneNumber;
import com.lapsa.phone.PhoneNumbers;

@FacesConverter(forClass = PhoneNumber.class)
public class PhoneNumberConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
	if (value == null || value.isEmpty())
	    return null;
	try {
	    return PhoneNumbers.parse(value);
	} catch (PhoneFormatException e) {
	    ResourceBundle bundle = ResourceBundle.getBundle("ConversionMessages", context.getViewRoot().getLocale());
	    String summary = bundle.getString(this.getClass().getName());
	    FacesMessage msg = new FacesMessage(summary);
	    throw new ConverterException(msg);
	}
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
