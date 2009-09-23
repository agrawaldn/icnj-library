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
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import com.library.business.AccountService;
import com.library.domain.Account;
import com.library.domain.AccountType;
import com.library.domain.Contact;
import com.library.domain.Fee;
import com.library.util.DateUtil;
import com.library.util.StringUtil;

public class AccountController extends SimpleFormController  {
	private final Log logger = LogFactory.getLog(AccountController.class);
	private AccountService accountService;

	private Account getCommand(int accountId){
		logger.debug("AccountController --> getCommand() called with accountId = "+accountId);
		Account account = new Account();
		if(accountId <= 0){
			Contact contact = new Contact();
			account.setContact(contact);
			AccountType accountType = new AccountType();
			account.setAccountType(accountType);
			Fee fee = new Fee();
			account.setFee(fee);
		}else{
			account.setId(accountId);
			try {
				accountService.getAccount(account);
			} catch (Exception e) {
				logger.error("AccountController.getCommand()",e);
			}
		}
		return account;
	}
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception	{    
		DateFormat df = new SimpleDateFormat(DateUtil.dateFormat);    
		df.setLenient(false);    
		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, true));    
		super.initBinder(request,binder);
	}
	public Object formBackingObject(HttpServletRequest request) {
		logger.debug("AccountController --> formBackingObject() called");
		Object command = null;
		String acctId = request.getParameter("accountId");
		int accountId = 0;
		if(!StringUtil.isNullOrEmpty(acctId)){
			accountId = Integer.parseInt(acctId);
		}
		command = getCommand(accountId);
		return command;
		
	}
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, 
	        Object command, BindException errors) throws Exception {
		Account acct = (Account) command;
		//logger.debug("account_id = "+acct.getId());
		if(acct.getId() > 0){
			this.getAccountService().updateAccount(acct);
		}else{
			this.getAccountService().createAccount(acct);
		}
    	return showForm(request, response, errors);
    }
	private boolean hasErrors(Account command, ModelAndView accountView ){
		BindException errors = new BindException(command, "account");
		if (getValidator().supports(command.getClass())) {
			ValidationUtils.invokeValidator(getValidator(), command, errors);
		}
		if (errors.hasErrors()) { 
			accountView.addAllObjects(errors.getModel());
			return true;
		}
		return false;
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