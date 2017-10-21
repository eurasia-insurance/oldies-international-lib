package com.lapsa.international.faces.phone;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.lapsa.international.phone.PhoneType;

import tech.lapsa.javax.faces.beans.localization.ListingBean;

@Named("PhoneType")
@ApplicationScoped
public class PhoneTypeBean implements ListingBean<PhoneType> {

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
