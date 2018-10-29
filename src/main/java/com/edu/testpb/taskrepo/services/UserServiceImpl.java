package com.edu.testpb.taskrepo.services;

import com.edu.testpb.taskrepo.entity.User;
import com.edu.testpb.taskrepo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    @Override
    public List<User> getUsersList() {
        return repository.findAll();
    }

}
