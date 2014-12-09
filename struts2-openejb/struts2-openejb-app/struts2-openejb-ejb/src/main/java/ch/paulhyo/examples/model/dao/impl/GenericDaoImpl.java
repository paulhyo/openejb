package ch.paulhyo.examples.model.dao.impl;

import ch.paulhyo.examples.model.dao.IGenericDao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name = "IGenericDao")
public class GenericDaoImpl<T> implements IGenericDao<T> {
	@PersistenceContext(unitName = "GaindePersistenceUnit")
	protected EntityManager entityManager;
	private Class<T> type;
	private String findAllQuery;

	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		this.type = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		findAllQuery = "From " + type.getName();
	}

	@Override
	public void create(T newInstance) throws CreateException {
		entityManager.persist(newInstance);
	}

	@Override
	public void merge(T instance) throws EJBException {
		entityManager.merge(instance);
	}

	@Override
	public void remove(Object key) throws FinderException, RemoveException {
		T instance = null;
		instance = findByPrimaryKey(key);
		entityManager.remove(instance);
	}

	@Override
	public void flush() {
		entityManager.flush();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() throws FinderException {
		Query query = entityManager.createQuery(findAllQuery);
		return (List<T>) query.getResultList();
	}

	@Override
	public T findByPrimaryKey(Object id) throws FinderException {
		return entityManager.find(type, id);
	}

	@Override
	public List<?> rechercherByWhere(String condition) {
		Query query = entityManager.createQuery(condition);
		return (List<?>) query.getResultList();
	}

	@Override
	public List<?> rechercherByWhereObject(Object objvo, String condition) {
		String sqlQuery = "from  " + objvo.getClass().getSimpleName()
				+ " where " + condition;
		Query query = entityManager.createQuery(sqlQuery);
		return query.getResultList();
	}

	@Override
	public List<?> rechercheByWhere(T obj, String condition) {
		String sqlQuery = "from  " + obj.getClass().getSimpleName()
				+ " where 1=1 " + condition;
		Query query = entityManager.createQuery(sqlQuery);
		return query.getResultList();

	}

	public List<?> executerRequete(String requete) throws FinderException {
		Query query = entityManager.createNativeQuery(requete);
		return (List<?>) query.getResultList();
	}

	@Override
	public Query createQuery(String clause) {
		return entityManager.createQuery(clause);
	}
}
