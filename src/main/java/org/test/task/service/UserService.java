package org.test.task.service;

import org.test.task.model.User;

import java.util.List;

public interface UserService {

    User findById(long id);

    User findByName(String name);

    User saveUser(User user);

    List<User> findAllUsers();

}
