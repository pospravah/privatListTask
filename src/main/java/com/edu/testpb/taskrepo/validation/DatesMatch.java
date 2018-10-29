package com.edu.testpb.taskrepo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Constraint(validatedBy = ConsistentDateParameterValidator.class)
//@Constraint(validatedBy = DatesMatchValidator.class)
@Target({ METHOD, CONSTRUCTOR, TYPE_USE })
@Retention(RUNTIME)
@Documented
public @interface  DatesMatch {

    String message () default "'start date' must be less than 'end date'. " +
            "Found: 'start date'=${validatedValue[0]}, " +
            "'end date'=${validatedValue[1]}";

    Class<?>[] groups () default {};

    Class<? extends Payload>[] payload () default {};
}