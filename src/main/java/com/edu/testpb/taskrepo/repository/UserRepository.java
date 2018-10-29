package com.edu.testpb.taskrepo.repository;

import com.edu.testpb.taskrepo.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

    public interface UserRepository extends CrudRepository<User, Long> {

        @Override
        List<User> findAll();
    }