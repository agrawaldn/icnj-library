package com.library.web.controller;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.library.business.AccountService;
import com.library.business.MediaLendingService;
import com.library.business.MediaService;
import com.library.command.formbean.CartBean;
import com.library.command.formbean.MediaLookupFormBean;
import com.library.domain.Account;
import com.library.domain.Media;
import com.library.domain.MediaLending;
import com.library.util.StringUtil;

public class CartController extends SimpleFormController  {
	private final Log logger = LogFactory.getLog(CartController.class);
	private MediaLendingService mediaLendingService;
	private AccountService accountService;
	
	private CartBean getCommand(int accountId){
		CartBean command = new CartBean();
		if(accountId > 0 && (command.getCheckoutItems() == null)){
	    	List<MediaLending> issuedItems = getMediaLendingService().getMediaLendings(accountId);
	    	if(issuedItems != null && issuedItems.size() > 0){
	    		logger.debug("Number of items issued to account "+accountId+" = "+issuedItems.size());
	    		command.setIssuedItems(issuedItems);
	    		command.setAccount(issuedItems.get(0).getAccount());
	    	}else{
	    		Account account = new Account();
	    		account.setId(accountId);
	    		try {
	    			getAccountService().getAccount(account);
					logger.debug("retreived account number "+account.getAccountNumber());
				} catch (Exception e) {
					logger.error("CartController.getCommand()", e);
				}
	    		command.setAccount(account);
	    	}
		}
		return command;
	}
	public Object formBackingObject(HttpServletRequest request) {
		logger.debug("CartController --> formBackingObject called...");
		Object object = null;
		String acctId = request.getParameter("accountId");
		int accountId = 0;
		if(!StringUtil.isNullOrEmpty(acctId)){
			accountId = Integer.parseInt(acctId);
		}
		//try to get shopping cart from the session only when no account number was specified
		if(isSessionForm() && accountId <= 0) {
			HttpSession session = request.getSession();
			logger.debug("session form attribute is: "+getFormSessionAttributeName());
			object = session.getAttribute(getFormSessionAttributeName() );
			if(object == null){
				object = new CartBean();
			}
		}
		else{
			object = getCommand(accountId);
		}
		return object;
	}
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, 
	        Object command, BindException errors) throws Exception {
		
		logger.debug("onSubmit called on CartController");
		
		//put the cart back in the session after submitting
		//request.getSession().setAttribute(getFormSessionAttributeName(),command);
    	return showForm(request, response, errors);
    }
	public ModelAndView addToCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		CartBean command = (CartBean)session.getAttribute(getFormSessionAttributeName() );
		String mediaId = request.getParameter("mediaId");
		logger.debug("adding item with mediaID = "+mediaId);
		MediaLending ml = getMediaLendingService().getMediaLending(Integer.parseInt(mediaId), command.getAccount());
		command.addItem(ml);
		request.getSession().setAttribute(getFormSessionAttributeName(),command);
		return new ModelAndView("viewCart","cartBean",command);
    }
	public ModelAndView removeFromCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		CartBean command = (CartBean)session.getAttribute(getFormSessionAttributeName() );
		String mediaId = request.getParameter("mediaId");
		logger.debug("removing item with mediaID = "+mediaId);
		command.removeItem(Integer.parseInt(mediaId));
		request.getSession().setAttribute(getFormSessionAttributeName(),command);
		return new ModelAndView("viewCart","cartBean",command);
	}
	public ModelAndView returnItem(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		CartBean command = (CartBean)session.getAttribute(getFormSessionAttributeName() );
		int mediaLendingId = Integer.parseInt(request.getParameter("mediaLendingId"));
		MediaLending returnedItem = command.returnItem(mediaLendingId);
		try {
			mediaLendingService.returnItem(returnedItem);
		} catch (Exception e) {
			logger.error("return item failed for media "+returnedItem.getMedia().getTitle(), e);
			returnedItem.setActualReturnDate(null);
		}
		request.getSession().setAttribute(getFormSessionAttributeName(),command);
		return new ModelAndView("viewCart","cartBean",command);
	}
	public ModelAndView checkout(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		CartBean command = (CartBean)session.getAttribute(getFormSessionAttributeName() );
		try {
			getMediaLendingService().checkout(command.getCheckoutItems());
		} catch (Exception e) {
			logger.error("checkout failed ",e);
		}
		command = getCommand(command.getAccount().getId());
		request.getSession().setAttribute(getFormSessionAttributeName(),command);
		return new ModelAndView("viewCart","cartBean",command);
	}
	/**
	 * @param mediaLendingService the mediaLendingService to set
	 */
	public void setMediaLendingService(MediaLendingService mediaLendingService) {
		this.mediaLendingService = mediaLendingService;
	}
	/**
	 * @return the mediaLendingService
	 */
	public MediaLendingService getMediaLendingService() {
		return mediaLendingService;
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