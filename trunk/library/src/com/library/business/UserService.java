/**
 * Created by: dagrawal on Dec 29, 2008
 * Contact: dev.agrawal@gmail.com for help
 */
package com.library.business;

import com.library.command.User;
import com.library.dao.UserDAO;

/**
 * @author dagrawal
 *
 */
public class UserService {
	private UserDAO userDAO;
	
	public boolean authenticateUser(User user){
		if(userDAO.getUser(user).getUserId() > 0){
			return true;
		}else{
			return false;
		}
	}
	public void saveUser(User user){
		userDAO.saveUser(user);
	}
	/**
	 * @param userDAO the userDAO to set
	 */
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	/**
	 * @return the userDAO
	 */
	public UserDAO getUserDAO() {
		return userDAO;
	}
}
