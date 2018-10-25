package com.edu.testpb.taskrepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.time.LocalDate;
import java.util.List;

public class DatabaseLoader implements CommandLineRunner {

    private final NoteRepository repository;

    @Autowired
    public DatabaseLoader(NoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("..........Database loader..........");
        List<User> userList = null;
        userList.add(new User("Сергей"));
        userList.add(new User("Андрей"));
        userList.add(new User("Роман"));
        userList.add(new User("Владимир"));

        NoteItem tItem = new NoteItem(LocalDate.now(), LocalDate.now(), "NoteTaskFake",  userList);
        this.repository.save(tItem);
    }
}
