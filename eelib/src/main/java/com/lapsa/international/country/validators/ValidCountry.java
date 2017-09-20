package com.lapsa.international.country.validators;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.lapsa.international.country.Country;
import com.lapsa.international.validators.AllowDenyOrder;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy = ValidCountryConstraintValidator.class)
public @interface ValidCountry {

    Country[] alloweValues() default {};

    Country[] denyValues() default {};

    String message() default "{com.lapsa.international.country.validators.ValidCountry.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    AllowDenyOrder mode() default AllowDenyOrder.ALLOW_ALL_NOT_DENIED;

}