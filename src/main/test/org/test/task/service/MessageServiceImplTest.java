package org.test.task.service;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.test.task.dao.MessageDao;
import org.test.task.model.Message;
import org.test.task.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class MessageServiceImplTest {
    @Mock
    MessageDao dao;

    @InjectMocks
    MessageServiceImpl messageService;

    @Spy
    List<Message> messages = new ArrayList<Message>();

    @BeforeClass
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        messages = getMessages();
    }


    @Test
    public void testFindAllMessages() throws Exception {
        when(dao.findAll()).thenReturn(messages);

        Assert.assertEquals(messageService.findAllMessages(), messages);
        verify(dao, atLeastOnce()).findAll();
    }

    @Test
    public void testFindById() throws Exception {
        when(dao.findById(anyInt())).thenReturn(messages.get(0));

        Assert.assertEquals(messageService.findById(anyInt()), messages.get(0));
        verify(dao, atLeastOnce()).findById(anyInt());
    }

    @Test
    public void testSaveMessage() throws Exception {
        doNothing().when(dao).save(any(Message.class));
        messageService.saveMessage(messages.get(0));
        verify(dao, atLeastOnce()).save(messages.get(0));
    }

    @Test
    public void testUpdateMessage() throws Exception {
        doNothing().when(dao).update(any(Message.class));
        messageService.updateMessage(messages.get(0));
        verify(dao, atLeastOnce()).update(messages.get(0));
    }

    @Test
    public void testDeleteMessageById() throws Exception {
        doNothing().when(dao).deleteById(anyInt());
        messageService.deleteMessageById(messages.get(0).getId());
        verify(dao, atLeastOnce()).deleteById(1);
    }

    public List<Message> getMessages() {
        List<Message> messages = new ArrayList<Message>();
        messages.add(new Message(1, getUser1(), "Hello, Mark"));
        messages.add(new Message(1, getUser2(), "Hello, Ann"));
        return messages;
    }

    public User getUser1() {
        return new User(1, "Mark");
    }

    public User getUser2() {
        return new User(2, "Ann");
    }

}