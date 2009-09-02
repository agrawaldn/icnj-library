package com.library.web.controller;

import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import com.library.business.UserService;
import com.library.domain.User;

public class LogonFormController extends SimpleFormController {
	private final Log logger = LogFactory.getLog(SimpleFormController.class);
	private UserService userService;
    public ModelAndView onSubmit(Object command) throws ServletException {
    	User user = (User) command;
    	logger.info("user name entered = "+user.getUserName()+" password enterd = "+user.getPassword());
    	//userService.saveUser(user);
    	return new ModelAndView(new RedirectView(getSuccessView()));
    }
    
    
	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	/**
	 * @return the userService
	 */
	public UserService getUserService() {
		return userService;
	}
    

    
}