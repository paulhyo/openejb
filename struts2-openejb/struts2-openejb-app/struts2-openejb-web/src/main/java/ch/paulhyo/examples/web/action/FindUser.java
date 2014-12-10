package ch.paulhyo.examples.web.action;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import ch.paulhyo.examples.domain.User;
import ch.paulhyo.examples.service.UserService;

public class FindUser {
	private int id;
	private String errorMessage;
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
			this.user = service.find(id);
		} catch (Exception e) {
			this.errorMessage = e.getMessage();
			return "failure";
		}
		return "success";
	}
}
