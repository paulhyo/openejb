package ch.paulhyo.examples.web.action;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import ch.paulhyo.examples.domain.User;
import ch.paulhyo.examples.service.UserService;

public class AddUser {
	private int id;
	private String firstName;
	private String lastName;
	private String errorMessage;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String execute() {
		try {
			UserService service = null;
			Properties props = new Properties();
			props.put(Context.INITIAL_CONTEXT_FACTORY,
					"org.apache.openejb.core.LocalInitialContextFactory");
			Context ctx = new InitialContext(props);
			service = (UserService) ctx.lookup("UserServiceImplLocal");
			service.add(new User(id, firstName, lastName));
		} catch (Exception e) {
			this.errorMessage = e.getMessage();
			return "failure";
		}
		return "success";
	}
}