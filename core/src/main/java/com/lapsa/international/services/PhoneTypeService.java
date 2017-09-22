package com.lapsa.international.services;

import com.lapsa.commons.elements.NamingListingService;
import com.lapsa.international.phone.PhoneType;

public interface PhoneTypeService extends NamingListingService<PhoneType> {

    @Override
    default PhoneType[] getAll() {
	return PhoneType.values();
    }

    @Override
    default PhoneType[] getSelectable() {
	return PhoneType.selectableValues();
    }

    @Override
    default PhoneType[] getNonSelectable() {
	return PhoneType.nonSelectableValues();
    }
}
