package com.library.web.controller;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.library.business.AccountService;
import com.library.command.Account;
import com.library.command.formbean.AccountLookupFormBean;
import com.library.util.StringUtil;

public class AccountLookupController extends SimpleFormController  {
	private final Log logger = LogFactory.getLog(AccountLookupController.class);
	private AccountService accountService;

	private AccountLookupFormBean getCommand(String searchString){
		AccountLookupFormBean command = new AccountLookupFormBean();
		if(!StringUtil.isNullOrEmpty(searchString)){
	    	List<Account> accountList = accountService.getMatchingAccounts(searchString);
	    	logger.debug("accountList size = "+accountList.size());
	    	command.setAccountList(accountList);
		}
		return command;
	}
	public Object formBackingObject(HttpServletRequest request) {
		logger.debug("formBackingObject called...");
		String searchString = request.getParameter("searchString");
		return getCommand(searchString);
		
	}
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, 
	        Object command, BindException errors) throws Exception {

		//request.getSession().setAttribute(getFormSessionAttributeName(), accountLookupFormBean);
    	//return new ModelAndView("accountLookup","accountLookupFormBean",accountLookupFormBean);
    	//return new ModelAndView(new RedirectView(getSuccessView()));
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