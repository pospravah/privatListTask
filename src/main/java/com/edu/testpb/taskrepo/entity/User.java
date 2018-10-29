package com.edu.testpb.taskrepo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="users")
public class User {

    private @Id @GeneratedValue Long id;
    private String name;

    public User(String name) {
        this.name = name;
    }
}
