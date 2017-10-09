package com.lapsa.international.phone.validators;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.lapsa.international.phone.CountryCode;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy = ValidPhoneNumberConstraintValidator.class)
public @interface ValidPhoneNumber {

    CountryCode[] countriesRequired() default {};
    
    String message() default "{com.lapsa.international.phone.validators.ValidPhoneNumber.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}