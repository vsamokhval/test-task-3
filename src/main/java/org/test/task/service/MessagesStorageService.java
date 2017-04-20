package org.test.task.service;

import org.test.task.model.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class MessagesStorageService {

    private static final AtomicLong counter = new AtomicLong();

    public static List<Message> messages = new ArrayList<Message>();

    static {
        presetMessages();
    }

    public static void presetMessages(){
        messages.add(new Message(counter.incrementAndGet(), UsersStorageService.users.get(counter.intValue() - 1), "Hello, Sam"));
        messages.add(new Message(counter.incrementAndGet(), UsersStorageService.users.get(counter.intValue() - 1), "Good morning, Tommy"));
        messages.add(new Message(counter.incrementAndGet(), UsersStorageService.users.get(counter.intValue() - 1), "Hi, Kelly"));
    }
}
