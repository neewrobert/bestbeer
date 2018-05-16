package com.desarrollox.dao.util;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1713748812089859387L;
	
	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("livraria");
	
	@Produces //indica ao cdi que esse e um metodo produtor (factory)
	@RequestScoped //indica ao cdi quantos objetos ele ira criar (um a cada requisição)
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	//@Disposes indica que deve fechar ao final de cada requisição
	public void close(@Disposes EntityManager em) {
		em.close();
	}

}
