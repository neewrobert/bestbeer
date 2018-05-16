package com.desarrollox.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public abstract class GenericDao<T extends Serializable> implements Serializable {

	/**
	 * Classe DAO  generica para todos os objetos
	 * Possui metodos pradão para INSERIR, DELETAR, ATUALIZAR, BUSCAR POR ID e BUSCAR TODOS
	 */
	private static final long serialVersionUID = 8678449725041854657L;

	private final Class<T> clazz;
	private EntityManager em;
	
	/**
	 * Construtor para a classe DAO
	 * @param Entity Manager
	 * @param Classe a ser persistida
	 */
	public GenericDao(EntityManager manager, Class<T> clazz) {
		this.em = manager;
		this.clazz = clazz;
	}
	
	
	/**
	 *  Metodo responsavel por salvar o Objeto no banco de dados
	 * @param t - Classe a ser inserida no banco
	 */
	public void save(T t) {
		em.persist(t);
	}
	
	/**
	 * Metodo responsavel por deletar o objeto no banco
	 * @param t - Classe a ser deletada no banco
	 */
	public void delete(T t) {
		em.remove(t);
	}
	
	/**
	 * Metodo responsavel por atualizar o objeto no banco
	 * @param t - Classe a ser atualizada no banco
	 */
	public void update(T t) {
		em.merge(t);
	}
	
	/**
	 * Metodo responsavel por buscar o objeto no banco
	 * @param Long id - Identificador do objeto a ser buscado
	 */
	public T findById(Integer id) {
		T instance = em.find(clazz, id);
		return instance;
	}
	
	/**
	 * Lista todos os Objetos no banco
	 * 
	 * @return List<T> - Retorna uma lista com os objetos encontrados
	 */
	public List<T> getAll() {
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(clazz);
		query.select(query.from(clazz));
		List<T> list = em.createQuery(query).getResultList();
		return list;
	}

}
