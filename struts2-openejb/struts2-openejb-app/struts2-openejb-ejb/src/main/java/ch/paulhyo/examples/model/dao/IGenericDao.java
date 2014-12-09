package ch.paulhyo.examples.model.dao;

import java.util.List;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.persistence.Query;

public interface IGenericDao<T> {
	/**
	 * Persist the newInstance object into database
	 * 
	 * @param newInstance
	 * @return
	 * @throws CreateException
	 */
	void create(T newInstance) throws CreateException;

	/**
	 * Save changes made to a persistent object
	 * 
	 * @param transientObject
	 * @throws RcEjbException
	 */
	void merge(T instance) throws EJBException;

	/**
	 * get list of all persisted object
	 * 
	 * @return
	 * @throws FinderException
	 */
	List<T> findAll() throws FinderException;

	/**
	 * Finds an entity by primary key
	 * 
	 * @param id
	 * @return
	 * @throws FinderException
	 */
	T findByPrimaryKey(Object id) throws FinderException;

	/**
	 * Delete entity by its primary key
	 * 
	 * @param id
	 * @return
	 * @throws RcEjbException
	 * @throws FinderException
	 */
	void remove(Object id) throws FinderException, RemoveException;

	/**
	 * Searches a list of entities from the persistence context.
	 * 
	 * @param objvo
	 * @param where
	 * @return
	 */
	List<?> rechercherByWhere(String where);

	List<?> rechercherByWhereObject(Object obj, String where);

	List<?> rechercheByWhere(T instance, String where);

	public List<?> executerRequete(String requete) throws FinderException;

	Query createQuery(String clause);

	void flush();
}
