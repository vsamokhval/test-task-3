package org.test.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.task.dao.UserDao;
import org.test.task.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao dao;

    @Override
    public User findById(int id) {
        return null;
    }

    public User findByName(String name) {
        return dao.findByName(name);
    }

    public void save(User user) {
        dao.save(user);
    }
}
