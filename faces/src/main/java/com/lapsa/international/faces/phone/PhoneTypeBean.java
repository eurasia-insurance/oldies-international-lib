package com.lapsa.international.faces.phone;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.faces.services.FacesSelectItemListingService;
import com.lapsa.international.phone.PhoneType;

@Named("phoneTypeService")
@ApplicationScoped
public class PhoneTypeServiceBean implements FacesSelectItemListingService<PhoneType> {

    @Override
    public PhoneType[] getAll() {
	return PhoneType.values();
    }

    @Override
    public PhoneType[] getSelectable() {
	return PhoneType.selectableValues();
    }

    @Override
    public PhoneType[] getNonSelectable() {
	return PhoneType.nonSelectableValues();
    }
}
