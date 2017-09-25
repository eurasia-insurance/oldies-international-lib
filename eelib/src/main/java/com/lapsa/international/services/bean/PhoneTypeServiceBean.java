package com.lapsa.international.services.bean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.faces.services.FacesSelectItemService;
import com.lapsa.international.phone.PhoneType;

@Named("phoneTypeService")
@ApplicationScoped
public class PhoneTypeServiceBean implements FacesSelectItemService<PhoneType> {

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
