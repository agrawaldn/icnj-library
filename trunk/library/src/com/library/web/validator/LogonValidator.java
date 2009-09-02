package com.library.web.validator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.library.business.UserService;
import com.library.domain.User;
import com.library.util.StringUtil;

public class LogonValidator implements Validator {

    private final Log logger = LogFactory.getLog(getClass());
    private UserService userService;
    public boolean supports(Class clazz) {
        return clazz.equals(User.class);
    }

    public void validate(Object obj, Errors errors) {
        User user = (User) obj;
        if (StringUtil.isNullOrEmpty(user.getUserName()) || StringUtil.isNullOrEmpty(user.getPassword())) {
            errors.rejectValue("userName", "error.login.not-specified", null,
                    "Value required.");
        } else {
            logger.info("Validating user credentials for: "
                    + user.getUserName());
            if (userService.authenticateUser(user) == false) {
            	logger.info("User authentication failed for "+user.getUserName());
                errors.rejectValue("userName", "error.login.invalid-login",
                        null, "Incorrect Username/Password");
            } 

        }
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