package org.test.task.controller;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.test.task.model.Message;
import org.test.task.model.User;
import org.test.task.service.MessageService;
import org.test.task.service.UserService;
import org.test.task.validators.UserValidator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class AppControllerTest {

    @Mock
    UserService userService;

    @Mock
    MessageService messageService;

    @Mock
    UserValidator userValidator;

    @InjectMocks
    AppController appController;

    @Spy
    ModelMap model;

    @Mock
    BindingResult result;

    @Spy
    List<Message> messages = new ArrayList<Message>();

    @BeforeClass
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        messages = getMessages();
    }


    @Test
    public void testGetIndexPage() throws Exception {
        when(messageService.findAllMessages()).thenReturn(messages);
        Assert.assertEquals(appController.getIndexPage(model), "userMessages");
        Assert.assertEquals(model.get("messages"), messages);
    }

    @Test
    public void testNewMessage() throws Exception {
        Assert.assertEquals(appController.newMessage(model), "addNewMessage");
        Assert.assertNotNull(model.get("message"));
        Assert.assertFalse((Boolean)model.get("edit"));
        Assert.assertEquals(((Message)model.get("message")).getId(), new Integer(0));
    }

    @Test
    public void testSaveMessageWithExistingUser() throws Exception {
        User user = new User("newUser");
        Message message = new Message(10, user, "New Message");

        when(result.hasErrors()).thenReturn(false);
        when(userService.findByName(anyString())).thenReturn(user);
        doNothing().when(messageService).saveMessage(any(Message.class));
        Assert.assertEquals(appController.saveMessage(message, result), "redirect:/");
        verify(messageService, atLeastOnce()).saveMessage(message);
        verify(userValidator, atLeastOnce()).validate(any(User.class), any(BindingResult.class));
        verify(userService, atLeast(0)).save(user);
    }

    @Test
    public void testSaveMessageWithNewUser() throws Exception {
        User user = new User("newUser");
        Message message = new Message(10, user, "New Message");

        when(result.hasErrors()).thenReturn(false);
        when(userService.findByName(anyString())).thenReturn(null);
        doNothing().when(messageService).saveMessage(any(Message.class));
        Assert.assertEquals(appController.saveMessage(message, result), "redirect:/");
        verify(messageService, atLeastOnce()).saveMessage(message);
        verify(userService, atLeastOnce()).save(user);
    }

    @Test
    public void testSaveMessageWithValidationError() throws Exception {
        User user = new User("newUser");
        Message message = new Message(10, user, "New Message");

        when(result.hasErrors()).thenReturn(true);
        when(userService.findByName(anyString())).thenReturn(user);
        doNothing().when(messageService).saveMessage(any(Message.class));
        Assert.assertEquals(appController.saveMessage(message, result), "addNewMessage");
        verify(messageService, atLeast(0)).saveMessage(message);
        verify(userService, atLeast(0)).save(user);
    }

    @Test
    public void testEditMessage() throws Exception {
        User user = new User("newUser");
        Message message = new Message(10, user, "New Message");

        when(messageService.findById(anyInt())).thenReturn(message);
        Assert.assertEquals(appController.editMessage(10, model), "addNewMessage");
        Assert.assertNotNull(model.get("message"));
        Assert.assertTrue((Boolean)model.get("edit"));
        Assert.assertEquals((model.get("message")), message);
        verify(messageService, atLeastOnce()).findById(10);
    }

    @Test
    public void testUpdateMessageWithExistingUser() throws Exception {
        User user = new User("newUser");
        Message message = new Message(10, user, "New Message");

        when(result.hasErrors()).thenReturn(false);
        when(userService.findByName(anyString())).thenReturn(null);
        doNothing().when(messageService).updateMessage(any(Message.class));
        Assert.assertEquals(appController.updateMessage(message, result), "redirect:/");
        verify(messageService, atLeastOnce()).updateMessage(message);
        verify(userService, atLeastOnce()).save(user);
    }

    @Test
    public void testUpdateMessageWithNewUser() throws Exception {
        User user = new User("newUser");
        Message message = new Message(10, user, "New Message");

        when(result.hasErrors()).thenReturn(false);
        when(userService.findByName(anyString())).thenReturn(user);
        doNothing().when(messageService).updateMessage(any(Message.class));
        Assert.assertEquals(appController.updateMessage(message, result), "redirect:/");
        verify(messageService, atLeastOnce()).updateMessage(message);
        verify(userService, atLeast(0)).save(user);
    }

    @Test
    public void testUpdateMessageWithValidationError() throws Exception {
        User user = new User("newUser");
        Message message = new Message(10, user, "New Message");

        when(result.hasErrors()).thenReturn(true);
        when(userService.findByName(anyString())).thenReturn(user);
        doNothing().when(messageService).updateMessage(any(Message.class));
        Assert.assertEquals(appController.updateMessage(message, result), "addNewMessage");
        verify(messageService, atLeast(0)).updateMessage(message);
        verify(userService, atLeast(0)).save(user);
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