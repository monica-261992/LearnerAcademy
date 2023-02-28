package org.simplilearn.dao;

import org.simplilearn.lms.entities.User;

public interface UserDao {
	
	void insert(User user);
	User get(String username,String password);
	void update(User user);

}
