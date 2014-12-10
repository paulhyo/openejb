package ch.paulhyo.examples.service;

import java.util.List;

import ch.paulhyo.examples.domain.User;

public interface UserService {
	
	public void add(User user);

	public User find(int id);

	public List<User> findAll();
}
