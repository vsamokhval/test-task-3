package org.test.task.service;

import org.springframework.stereotype.Service;
import org.test.task.model.User;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    private static List<User> users = UsersStorageService.users;

    public User findById(long id) {
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

    public User saveUser(User user) {
        long id;
        if(users.isEmpty()) {
            id = 0;
        } else {
            User usr = users.get(users.size() - 1);
            id = usr.getId() + 1;
        }

        user.setId(id);
        users.add(user);

        System.out.println("Size od users: " + users.size());

        return user;
    }

    public List<User> findAllUsers() {
        return users;
    }
}
