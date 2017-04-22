package org.test.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.task.dao.MessageDao;
import org.test.task.model.Message;

import java.util.Collections;
import java.util.List;

@Service("messageService")
@Transactional
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageDao dao;

	public List<Message> findAllMessages() {
		List<Message> messages = dao.findAll();
		Collections.sort(messages);
		return messages;
	}

	public Message findById(int id) {
		return dao.findById(id);
	}

	public void saveMessage(Message message) {
		dao.save(message);
	}

	public void updateMessage(Message message) {
		dao.update(message);
	}

	public void deleteMessageById(int id) {
		dao.deleteById(id);
	}
}
