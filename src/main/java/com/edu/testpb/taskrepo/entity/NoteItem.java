package com.edu.testpb.taskrepo.entity;

import com.edu.testpb.taskrepo.validation.DatesMatch;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@Getter
@Setter
@Entity
public class NoteItem {

    private @Id @GeneratedValue Long id;
    @NotNull
    private LocalDate startDate;
    @NotNull
    private LocalDate endDate;
    @NotNull
    private String description;
    @NotNull
    @OneToMany(cascade = {CascadeType.ALL})
    private List<User> assigned;

    @DatesMatch
    public NoteItem(LocalDate startDate, LocalDate endDate, String description, List<User> users) {
        System.out.println("---NoteItem--- constructor: ");
        this.id = null;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.assigned = users;
    }

}


