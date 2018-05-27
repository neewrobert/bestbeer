package com.desarrollox.dao;

import javax.persistence.EntityManager;

import com.desarrollox.dao.util.ConnectionFactory;
import com.desarrollox.model.BaseEntity;

public class GenericDao<T extends BaseEntity> {

	protected static EntityManager manager = ConnectionFactory.getEntityManager();

	public T findById(Class<T> clazz, Long id) {
		return manager.find(clazz, id);
	}

	public void saveOrUpdate(T obj) {
		try {
			manager.getTransaction().begin();
			if (obj.getId() == null) {
				manager.persist(obj);
				manager.getTransaction().commit();
			} else {
				manager.merge(obj);
				manager.getTransaction().commit();
			}
		} catch (Exception e) {
			manager.getTransaction().rollback();
		}
	}

	public void removeById(Class<T> clazz, Long id) {

		T t = findById(clazz, id);

		try {

			manager.getTransaction().begin();
			manager.remove(t);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		}

	}

	public void removeByObj(T t) {


		try {

			manager.getTransaction().begin();
			manager.remove(t);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		}

	}

}
