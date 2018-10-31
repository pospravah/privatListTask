package com.edu.testpb.taskrepo.validation;

import com.edu.testpb.taskrepo.entity.NoteItem;
import com.edu.testpb.taskrepo.entity.User;
import com.edu.testpb.taskrepo.utils.AssignmentUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class UserPerDateValidator implements ConstraintValidator<UserPerDatesMatch, Object[]> {

    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {

        System.out.println("---- Validation User per Dates match --- isValid run -");

        NoteItem temp = (NoteItem) value[0];
        User tempUser = null;

        Map<String, Set<String>> dayAssignment = AssignmentUtil.getDayOfTaskAssinfment(temp);
        Map<String, Set<String>> allAssignment = AssignmentUtil.getAllDaysAssignment();

        /**
         *  Validation for existing users per date
         */
        System.out.println("allAssignment.keySet: "+allAssignment.keySet());
        System.out.println("allAssignment.values: "+allAssignment.values());
        System.out.println("dayAssignment.keySet: " + dayAssignment.keySet());
        System.out.println("dayAssignment.values: "+ dayAssignment.values());

        Set<String> secondListNames = new HashSet<String>();
        Set<String> firstListNames = new HashSet<String>();

        Map<String, Set<String>> repeatedPerDay = new HashMap<>();

        Set<String> crossDates = new HashSet<>();

        for(String firstKey : allAssignment.keySet()) {
            for (String secondKey : dayAssignment.keySet()) {
                // Go inside if cross Dates
                if (secondKey.equals(firstKey)) {
                    String crossDate = secondKey;
                    crossDates.add(crossDate);
                }
            }
        }

        Set<String> repeatedUsersPerDay = new HashSet<>();
        for (String day: crossDates){

            firstListNames = allAssignment.get(day);
            secondListNames = dayAssignment.get(day);
            repeatedUsersPerDay.clear();

            for (String first : firstListNames){
                if (secondListNames.contains(first)){
                    repeatedUsersPerDay.add(first);
                }
            }
            for (String second: secondListNames){
                if (firstListNames.contains(second)){
                    repeatedUsersPerDay.add(second);
                }
            }

            repeatedPerDay.put(day, repeatedUsersPerDay);
        }

        if (!repeatedPerDay.isEmpty()) {
            // result of searching duplicates:
            System.out.println("Resulted duplicate list: " + repeatedPerDay);
//            throw new IllegalArgumentException(
//                    "Day is buzy for user Check existing assignment" + repeatedPerDay );
            return false;
            }
        return true;
        }

}