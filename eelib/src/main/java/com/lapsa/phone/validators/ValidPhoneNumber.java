package com.lapsa.phone.validators;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy = ValidPhoneNumberConstraintValidator.class)
public @interface ValidPhoneNumber {

    String message() default "{com.lapsa.phone.validators.ValidPhoneNumber.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int areaCodeMinLength() default 3;

    int areaCodeMaxLength() default 4;

    int numberMinLength() default 6;

    int numberMaxLength() default 7;

    int getFullNumberMinLength() default 10;

    int getFullNumberNaxLength() default 10;

}