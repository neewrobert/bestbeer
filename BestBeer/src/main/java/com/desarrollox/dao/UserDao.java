package com.desarrollox.dao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.desarrollox.model.User;

public class UserDao extends GenericDao<User> {

	public boolean isUserExist(User user) {
		
		TypedQuery<User> query = manager.createQuery("select u from User u" + " where u.email = :pEmail and u.password = :pSenha", User.class);

		query.setParameter("pEmail", user.getEmail());
		query.setParameter("pSenha", user.getPassword());
		try {
			User result = query.getSingleResult();
		} catch (NoResultException e) {
			return false;
		}

		return true;
	}

}
