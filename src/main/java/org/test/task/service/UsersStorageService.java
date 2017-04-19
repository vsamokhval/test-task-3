package org.test.task.service;

import org.springframework.stereotype.Service;
import org.test.task.model.Message;
import org.test.task.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class UsersStorageService {

    private static final AtomicLong counter = new AtomicLong();

    public static List<User> users = new ArrayList<User>();

    static {
        presetUsers();
    }

    public static void presetUsers(){
        users.add(new User(counter.incrementAndGet(),"Sam"));
        users.add(new User(counter.incrementAndGet(),"Tommy"));
        users.add(new User(counter.incrementAndGet(),"Kelly"));
    }
}
