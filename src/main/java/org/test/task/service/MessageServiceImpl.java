package org.test.task.service;

import org.springframework.stereotype.Service;
import org.test.task.model.Message;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service("messageService")
public class MessageServiceImpl implements MessageService {

	private static final int COUNTER_INIT_VALUE = 4;

	private static final AtomicLong counter = new AtomicLong(COUNTER_INIT_VALUE);

	private static List<Message> messages = MessagesStorageService.messages;

	public List<Message> findAllMessages() {
		Collections.sort(messages);
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
		message.setId(counter.incrementAndGet());
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
