package org.test.task.service;

import org.test.task.model.User;

public interface UserService {

    User findById(int id);

    User findByName(String name);

    void save(User user);

}
