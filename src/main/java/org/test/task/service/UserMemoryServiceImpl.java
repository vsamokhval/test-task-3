package org.test.task.service;

import org.springframework.stereotype.Service;
import org.test.task.model.User;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

//@Service("userService")
public class UserMemoryServiceImpl implements UserService {
    private static final int COUNTER_INIT_VALUE = 4;

    private static final AtomicInteger counter = new AtomicInteger(COUNTER_INIT_VALUE);


    private static List<User> users = UsersStorageService.users;

    public User findById(int id) {
        for(User user : users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public User findByName(String name) {
        for(User user : users){
            if(user.getName().equals(name)){
                return user;
            }
        }
        return null;
    }

    public void save(User user) {
        user.setId(counter.incrementAndGet());
        users.add(user);
    }

    public List<User> findAllUsers() {
        return users;
    }
}
