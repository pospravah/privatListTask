package com.edu.testpb.taskrepo.validation;

import com.edu.testpb.taskrepo.entity.NoteItem;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;
import java.time.LocalDate;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class DatesMatchValidator implements ConstraintValidator<DatesMatch, NoteItem> {


    @Override
    public boolean isValid (NoteItem value, ConstraintValidatorContext context) {
        System.out.println("---- ValidationTarget --- isValid run -");
        if (value == null ||
                !(value.getStartDate() instanceof LocalDate) ||
                !(value.getEndDate() instanceof LocalDate)) {
            return false;
        }

        return ((LocalDate) value.getStartDate()).isBefore((LocalDate) value.getEndDate());
    }
}


