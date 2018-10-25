package com.edu.testpb.taskrepo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {

    private @Id @GeneratedValue Long id;
    private String name;

    public User(String name) {
        this.name = name;
    }
}
