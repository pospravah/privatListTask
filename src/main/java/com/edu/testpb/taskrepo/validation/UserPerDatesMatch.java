package com.edu.testpb.taskrepo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = UserPerDateValidator.class)
@Target({ METHOD, CONSTRUCTOR, TYPE_USE })
@Retention(RUNTIME)
@Documented
public @interface UserPerDatesMatch {

    String message () default "'User was assigned to some task yet. " +
            "Found repeated per day: " +
            "+ ${repeatedPerDay}";
    Class<?>[] groups () default {};

    Class<? extends Payload>[] payload () default {};
}
