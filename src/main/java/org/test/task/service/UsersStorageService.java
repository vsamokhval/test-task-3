package org.test.task.service;

import org.test.task.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class UsersStorageService {

    private static final AtomicInteger counter = new AtomicInteger();

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
