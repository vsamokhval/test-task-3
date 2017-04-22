package org.test.task.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.test.task.model.User;


@Repository("userDao")
public class UserDaoImpl extends AbstractDao<String, User> implements UserDao {

	static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	public User findByName(String name) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("name", name));
		User user = (User)criteria.uniqueResult();
		return user;
	}

	public void save(User user) {
		persist(user);
	}

}
