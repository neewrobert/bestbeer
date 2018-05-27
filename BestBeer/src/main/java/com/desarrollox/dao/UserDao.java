package com.desarrollox.dao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.desarrollox.model.User;

public class UserDao extends GenericDao<User> {

	public User isUserExist(User user) {
		
		User result;
		TypedQuery<User> query = manager.createQuery("select u from User u" + " where u.email = :pEmail and u.password = :pSenha", User.class);

		query.setParameter("pEmail", user.getEmail());
		query.setParameter("pSenha", user.getPassword());
		try {
			result = query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

		return result;
	}

}
