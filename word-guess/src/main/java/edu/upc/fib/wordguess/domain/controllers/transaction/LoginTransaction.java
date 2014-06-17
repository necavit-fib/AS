package edu.upc.fib.wordguess.domain.controllers.transaction;

import edu.upc.fib.wordguess.data.DataControllersFactory;
import edu.upc.fib.wordguess.data.dao.RegisteredUserDAO;
import edu.upc.fib.wordguess.data.exception.UsernameNotExists;
import edu.upc.fib.wordguess.domain.model.RegisteredUser;

public class LoginTransaction implements Transaction<Boolean> {

	private String username;
	private String password;
	
	public LoginTransaction(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	@Override
	public Boolean execute() throws UsernameNotExists {
		//data controllers acquisition
		DataControllersFactory dataFactory = DataControllersFactory.getInstance();
		RegisteredUserDAO userController = dataFactory.getRegisteredUserDAO();
		
		//fetch user
		RegisteredUser user = userController.getUser(username);
		
		//if no UsernameNotExists has yet been propagated,
		// the user exists -> check password
		return password.equals(user.getPassword());
	}
	
}