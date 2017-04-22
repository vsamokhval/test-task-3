package org.test.task.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.test.task.model.Message;

import java.util.List;


@Repository("messageDao")
public class MessageDaoImpl extends AbstractDao<Integer, Message> implements MessageDao {

	static final Logger logger = LoggerFactory.getLogger(MessageDaoImpl.class);
	
	public Message findById(int id) {
		Message message = getByKey(id);
		return message;
	}

	public void save(Message message) {
		persist(message);
	}

	public void deleteById(int id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		Message message = (Message)crit.uniqueResult();
		delete(message);
	}

	public List<Message> findAll() {
		Criteria criteria = createEntityCriteria();
		List<Message> message = (List<Message>) criteria.list();

		return message;
	}

}
