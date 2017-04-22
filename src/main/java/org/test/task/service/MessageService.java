package org.test.task.service;

import java.util.List;

import org.test.task.model.Message;


public interface MessageService {

	Message findById(int id);
	
	void saveMessage(Message message);
	
	void updateMessage(Message message);
	
	void deleteMessageById(int id);

	List<Message> findAllMessages();

}
