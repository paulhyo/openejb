package ch.paulhyo.examples.model.dao.impl;

import java.util.List;

import javax.ejb.Stateless;

import ch.paulhyo.examples.model.User;
import ch.paulhyo.examples.model.UserDTO;
import ch.paulhyo.examples.model.dao.IUserDao;

@Stateless(name = "IUserDao")
public class UserDaoImpl<T> extends GenericDaoImpl<User> implements IUserDao {
	public UserDTO authenticator(String login, String password) {		
		// Recherche du user 
		List<User> users = null;
		UserDTO userDto = null;
		users = (List<User>) rechercherByWhere("SELECT U FROM User U WHERE U.login ='"+login+"' AND U.password ='"+password+"'");
		// conversion en userDto
		if (users != null && !users.isEmpty()) {
		userDto = convertUserToDto(users.get(0)); 
		}
		return userDto; 
	}
	private UserDTO convertUserToDto(User user) {
		UserDTO userDto = null;
		if (user != null) {
			userDto = new UserDTO();
			userDto.setLogin(user.getLogin());
			userDto.setPassword(user.getPassword());
			userDto.setNom(user.getNom());
		}
		return userDto;
	}	
}