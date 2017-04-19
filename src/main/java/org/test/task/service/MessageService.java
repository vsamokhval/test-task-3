package org.test.task.service;

import java.util.List;

import org.test.task.model.Message;


public interface MessageService {

	Message findById(long id);
	
	void saveMessage(Message message);
	
	void updateMessage(Message message);
	
	void deleteMessageById(long id);

	List<Message> findAllMessages();
	
	void deleteAllMessages();
	

}
