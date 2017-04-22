package org.test.task.dao;

import org.test.task.model.User;

public interface UserDao {

	User findByName(String id);

	void save(User user);
}


