package com.lapsa.international.phone.converter.jpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.lapsa.international.phone.PhoneNumber;

@Converter(autoApply = true)
public class PhoneNumberAttributeConverter implements AttributeConverter<PhoneNumber, String> {

    @Override
    public String convertToDatabaseColumn(final PhoneNumber attribute) {
	return attribute == null ? null : attribute.getFormatted();
    }

    @Override
    public PhoneNumber convertToEntityAttribute(final String dbData) {
	return dbData == null ? null : PhoneNumber.assertValid(dbData);
    }

}
