package com.desarrollox.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.desarrollox.dao.util.ConnectionFactory;
import com.desarrollox.model.Beer;

public class BeerDao extends GenericDao<Beer> {

	public List<Beer> getAllBeers() {

		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Beer> criteria = builder.createQuery(Beer.class);
		criteria.from(Beer.class);

		return manager.createQuery(criteria).getResultList();

	}
	
	public List<Beer> serachByNameCategoryAndNationality(String search){
		
		StringBuilder query = new StringBuilder();
		query.append("	SELECT b from Beer b 	");
		query.append("	WHERE name like '%" + search + "%'");
		query.append("	or b.category like '%" + search + "%'");
		query.append("	or b.nationality like '%" + search + "%'");
		
		TypedQuery<Beer> typedQuery = manager.createQuery(query.toString(), Beer.class);
		List<Beer> resultList = typedQuery.getResultList();
		
		
		return resultList;
		
	}

}
