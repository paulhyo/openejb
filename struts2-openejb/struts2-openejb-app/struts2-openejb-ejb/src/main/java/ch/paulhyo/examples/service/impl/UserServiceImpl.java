package ch.paulhyo.examples.service.impl;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.paulhyo.examples.domain.User;
import ch.paulhyo.examples.service.UserService;


@Stateless
@Local(UserService.class)  
public class UserServiceImpl implements UserService {
	
	@PersistenceContext(unitName = "user")
	private EntityManager manager;

	public void add(User user) {
		manager.persist(user);
	}

	public User find(int id) {
		return manager.find(User.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		return manager.createQuery("select u from User u").getResultList();
	}
}