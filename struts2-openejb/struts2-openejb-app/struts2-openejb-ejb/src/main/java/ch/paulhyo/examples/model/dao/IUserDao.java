package ch.paulhyo.examples.model.dao;

import ch.paulhyo.examples.model.User;
import ch.paulhyo.examples.model.UserDTO;

public interface IUserDao extends IGenericDao<User> {
	public UserDTO authenticator(String login, String password);
}
