package com.lapsa.phone;

public interface PhoneNumberFactory {
    PhoneNumber create(PhoneCCode country, String number) throws PhoneFormatException;

    PhoneNumber parse(String anyFormat) throws PhoneFormatException;

    PhoneNumber parse(String anyFormat, PhoneCCode defaultCountryCode) throws PhoneFormatException;
    
    PhoneCCode identifyCountryCode(String number, boolean force) throws PhoneFormatException;
}
