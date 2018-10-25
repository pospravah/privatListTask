package com.edu.testpb.taskrepo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Getter
@Setter
@Entity
public class NoteItem {

    private @Id @GeneratedValue Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<User> assigned;

    public NoteItem() {
    }

    public NoteItem(LocalDate startDate, LocalDate endDate, String description, List<User> users) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.assigned = users;
    }

}


