package com.lapsa.phone.converter.jpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.lapsa.phone.PhoneNumber;

@Converter(autoApply = true)
public class PhoneNumberAttributeConverter implements AttributeConverter<PhoneNumber, String> {

    @Override
    public String convertToDatabaseColumn(PhoneNumber attribute) {
	return attribute == null ? null : attribute.getFormatted();
    }

    @Override
    public PhoneNumber convertToEntityAttribute(String dbData) {
	return dbData == null ? null : PhoneNumber.parse(dbData);
    }

}
