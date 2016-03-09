package com.lapsa.validators;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = ValidPhoneNumberConstraintValidator.class)
public @interface ValidPhoneNumber {

    String message() default "{com.lapsa.validators.ValidPhoneNumber}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    boolean checkPrefix() default true;

}