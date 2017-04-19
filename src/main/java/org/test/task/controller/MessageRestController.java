package org.test.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.test.task.model.Message;
import org.test.task.service.MessageService;

@RestController
public class MessageRestController {
 
    @Autowired
    MessageService messageService;


    @RequestMapping(value = "/message/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Message> deleteMessage(@PathVariable("id") long id) {

        Message message = messageService.findById(id);
        if (message == null) {
            return new ResponseEntity<Message>(HttpStatus.NOT_FOUND);
        }

        messageService.deleteMessageById(id);
        return new ResponseEntity<Message>(HttpStatus.NO_CONTENT);
    }
 
}