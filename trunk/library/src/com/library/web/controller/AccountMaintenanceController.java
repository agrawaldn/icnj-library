package com.library.web.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import com.library.business.AccountService;
import com.library.domain.Account;
import com.library.domain.AccountType;
import com.library.domain.Contact;
import com.library.domain.Fee;
import com.library.util.DateUtil;

public class AccountMaintenanceController extends SimpleFormController  {
	private final Log logger = LogFactory.getLog(AccountMaintenanceController.class);
	private AccountService accountService;

	private Account getCommand(){
		//logger.debug("getCommand() called in AccountMaintenanceController");
		Account command = new Account();
		Contact contact = new Contact();
		command.setContact(contact);
		AccountType accountType = new AccountType();
		command.setAccountType(accountType);
		Fee fee = new Fee();
		command.setFee(fee);
		return command;
	}
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception	{    
		DateFormat df = new SimpleDateFormat(DateUtil.dateFormat);    
		df.setLenient(false);    
		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, true));    
		super.initBinder(request,binder);
	}
	public Object formBackingObject(HttpServletRequest request) {
		return getCommand();
		
	}
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, 
	        Object command, BindException errors) throws Exception {
		Account acct = (Account) command;
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