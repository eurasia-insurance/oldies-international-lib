package com.lapsa.cars;

public interface VINCodeValidator {
    boolean isValid(String vinCode);

    boolean isValid(String vinCode, boolean checkDigit);

    boolean isValid(String vinCode, boolean checkDigit, boolean caseSensitive);
}
