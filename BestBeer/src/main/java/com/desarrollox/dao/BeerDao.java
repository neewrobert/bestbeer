package com.desarrollox.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import com.desarrollox.model.Beer;

public class BeerDao extends GenericDao<Beer> {

	public List<Beer> getAllBeers() {

		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Beer> criteria = builder.createQuery(Beer.class);
		criteria.from(Beer.class);

		return manager.createQuery(criteria).getResultList();

	}

}
