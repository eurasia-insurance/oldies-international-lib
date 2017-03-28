package com.lapsa.cars.validators;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy = ValidVINCodeConstraintValidator.class)
public @interface ValidVINCode {

    boolean checkDigit() default true;

    boolean caseSensitive() default false;

    String message() default "{com.lapsa.cars.validators.ValidVINCode.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}