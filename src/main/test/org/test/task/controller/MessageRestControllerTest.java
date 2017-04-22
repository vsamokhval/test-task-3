package org.test.task.controller;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.test.task.model.Message;
import org.test.task.model.User;
import org.test.task.service.MessageService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

public class MessageRestControllerTest {

    @Mock
    MessageService messageService;


    @InjectMocks
    MessageRestController messageRestController;

    @BeforeClass
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDeleteMessageSuccessful() throws Exception {
        User user = new User("newUser");
        Message message = new Message(10, user, "New Message");

        when(messageService.findById(anyInt())).thenReturn(message);
        doNothing().when(messageService).deleteMessageById(anyInt());
        Assert.assertEquals(messageRestController.deleteMessage(10), new ResponseEntity<Message>(HttpStatus.NO_CONTENT));
        verify(messageService, atLeastOnce()).findById(anyInt());
        verify(messageService, atLeastOnce()).deleteMessageById(message.getId());
    }

    @Test
    public void testDeleteMessageEntityNotFound() throws Exception {
        User user = new User("newUser");
        Message message = new Message(10, user, "New Message");

        when(messageService.findById(anyInt())).thenReturn(null);
        doNothing().when(messageService).deleteMessageById(anyInt());
        Assert.assertEquals(messageRestController.deleteMessage(10), new ResponseEntity<Message>(HttpStatus.NOT_FOUND));
        verify(messageService, atLeastOnce()).findById(anyInt());
        verify(messageService, atLeast(0)).deleteMessageById(message.getId());
    }

}