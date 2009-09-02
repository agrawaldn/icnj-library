package com.library.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import com.library.business.AccountService;
import com.library.domain.Account;
import com.library.domain.AccountType;
import com.library.domain.Contact;

public class AccountMaintenanceController extends SimpleFormController  {
	private final Log logger = LogFactory.getLog(AccountMaintenanceController.class);
	private AccountService accountService;

	private Account getCommand(){
		Account command = new Account();
		Contact contact = new Contact();
		command.setContact(contact);
		AccountType accountType = new AccountType();
		command.setAccountType(accountType);
		return command;
	}
	public Object formBackingObject(HttpServletRequest request) {
		return getCommand();
		
	}
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, 
	        Object command, BindException errors) throws Exception {
		Account acct = (Account) command;
		logger.debug("onSubmit() called for Account creation "+acct.getContact().getFirstName());
		this.getAccountService().createAccount(acct);
    	return showForm(request, response, errors);
    }
	/**
	 * @param accountService the accountService to set
	 */
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	/**
	 * @return the accountService
	 */
	public AccountService getAccountService() {
		return accountService;
	}
    
    
}