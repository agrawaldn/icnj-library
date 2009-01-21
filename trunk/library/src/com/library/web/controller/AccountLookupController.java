package com.library.web.controller;

import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import com.library.command.formbean.AccountLookupFormBean;

public class AccountLookupController extends SimpleFormController {
	private final Log logger = LogFactory.getLog(SimpleFormController.class);
	
    public ModelAndView onSubmit(Object command) throws ServletException {
    	AccountLookupFormBean accountLookupBean = (AccountLookupFormBean) command;
    	logger.debug("Account number entered = "+accountLookupBean.getAccountNumber());
    	
    	return new ModelAndView(new RedirectView(getSuccessView()));
    }
    
    
}