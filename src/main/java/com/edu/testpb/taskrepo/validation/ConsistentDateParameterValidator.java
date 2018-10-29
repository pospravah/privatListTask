package com.edu.testpb.taskrepo.validation;

import com.edu.testpb.taskrepo.entity.NoteItem;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;
import java.time.LocalDate;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class ConsistentDateParameterValidator
        implements ConstraintValidator<DatesMatch, Object[]> {

    @Override
    public boolean isValid(
            Object[] value,
            ConstraintValidatorContext context) {

        System.out.println("--- ConsistentDateParameterValidator --- value --- " );
        NoteItem temp = (NoteItem)value[0];

        if (!(temp.getStartDate() instanceof LocalDate) || !(temp.getEndDate() instanceof LocalDate)) {
            throw new IllegalArgumentException(
                    "Illegal method signature, expected two parameters of type LocalDate.");
        }

        LocalDate lStart = temp.getStartDate();
        LocalDate lEnd = temp.getEndDate();

        if (lStart == null || lEnd == null) {
            return true;
        }

        return lEnd.isAfter(lStart);
    }
}