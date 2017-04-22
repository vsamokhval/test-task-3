package org.test.task.dao;

import org.test.task.model.Message;

import java.util.List;

public interface MessageDao {

	Message findById(int id);

	void save(Message message);

	void update(Message message);

	void deleteById(int id);

	List<Message> findAll();
}


