package com.edu.testpb.taskrepo.utils;

import com.edu.testpb.taskrepo.entity.NoteItem;
import com.edu.testpb.taskrepo.entity.User;
import com.edu.testpb.taskrepo.services.NoteItemService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Setter
@Getter
@Service
public class AssignmentUtil {

    static NoteItemService noteService;

    @Autowired
    public AssignmentUtil(NoteItemService noteService) {
        this.noteService = noteService;
    }

    static public Map<String, Set<String>> getAllDaysAssignment() {

        Map<String, Set<String>> allAssignment = new HashMap<>();
        List<NoteItem> allTasks = noteService.getItemList();

        for (NoteItem item : allTasks) {
            Set<User> perDay = new HashSet<>(item.getAssigned());

            LocalDate start = item.getStartDate();
            LocalDate end = item.getEndDate();
            while (!start.isAfter(end) || start.equals(end)) {
                Set<String> str = new HashSet<>();
                perDay.stream().forEach((user) -> str.add(user.getName()));
                start = start.plusDays(1);
                System.out.println(start);
                System.out.println(str);
                final String temp = start.toString();
                if (allAssignment.containsKey(temp)) {
                    Set<String> tempSetNames = allAssignment.get(temp);
                    str.addAll(tempSetNames);
                }
                allAssignment.put(temp, str);
            }
        }
        return allAssignment;
    }

    static public Map<String, Set<String>> getDayOfTaskAssinfment(NoteItem task){

        Map<String, Set<String>> dayAssignment = new HashMap<>();

        Set<User> perDay = new HashSet<>(task.getAssigned());

        LocalDate start = task.getStartDate();
        LocalDate end = task.getEndDate();
        while (!start.isAfter(end) || start.equals(end)) {
            Set<String> str = new HashSet<>();
            perDay.stream().forEach((user) -> str.add(user.getName()));
            start = start.plusDays(1);
            System.out.println(start);
            System.out.println(str);
            final String temp = start.toString();
            if (dayAssignment.containsKey(temp)) {
                Set<String> tempSetNames = dayAssignment.get(temp);
                str.addAll(tempSetNames);
            }
            dayAssignment.put(temp, str);
        }
        return dayAssignment;
    }
}