package org.test.task.service;

import org.springframework.stereotype.Service;
import org.test.task.model.Message;

import java.util.Iterator;
import java.util.List;

@Service("messageService")
public class MessageServiceImpl implements MessageService{

	private static List<Message> messages = MessagesStorageService.messages;

	public List<Message> findAllMessages() {
		return messages;
	}

	public Message findById(long id) {
		for(Message message : messages){
			if(message.getId() == id){
				return message;
			}
		}
		return null;
	}
	
	public void saveMessage(Message message) {
		long id;
		if(messages.isEmpty()) {
			id = 0;
		} else {
			Message msg = messages.get(messages.size() - 1);
			id = msg.getId() + 1;
		}

		message.setId(id);
		messages.add(message);
	}

	public void updateMessage(Message message) {
		int index = messages.indexOf(message);
		messages.set(index, message);
	}

	public void deleteMessageById(long id) {
		
		for (Iterator<Message> iterator = messages.iterator(); iterator.hasNext(); ) {
			Message message = iterator.next();
		    if (message.getId() == id) {
		        iterator.remove();
		    }
		}
	}

	public void deleteAllMessages(){
		messages.clear();
	}
}
