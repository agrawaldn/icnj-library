package com.library.web.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.portlet.bind.PortletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.library.business.AccountService;
import com.library.business.MediaLendingService;
import com.library.command.formbean.CartBean;
import com.library.domain.Account;
import com.library.domain.MediaLending;
import com.library.util.StringUtil;

public class CartController extends SimpleFormController  {
	private final Log logger = LogFactory.getLog(CartController.class);
	private MediaLendingService mediaLendingService;
	private AccountService accountService;
	
	private CartBean getCommand(int accountId){
		CartBean command = new CartBean();
		logger.debug("getCommand() --> accountId = "+accountId);
		if(accountId > 0 && (command.getCheckoutItems() == null || command.getCheckoutItems().size() < 1)){
	    	List<MediaLending> issuedItems = getMediaLendingService().getMediaLendings(accountId);
	    	if(issuedItems != null && issuedItems.size() > 0){
	    		//logger.debug("Number of items issued to account "+accountId+" = "+issuedItems.size());
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
		Object object = null;
		String acctId = request.getParameter("accountId");
		logger.debug("formBackingObject() --> accountId = "+acctId);
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
		command.addToCart(ml);
		request.getSession().setAttribute(getFormSessionAttributeName(),command);
		return new ModelAndView("viewCart","cartBean",command);
    }
	public ModelAndView removeFromCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		CartBean command = (CartBean)session.getAttribute(getFormSessionAttributeName() );
		String mediaId = request.getParameter("mediaId");
		logger.debug("removing item with mediaID = "+mediaId);
		command.removeFromCart(Integer.parseInt(mediaId));
		request.getSession().setAttribute(getFormSessionAttributeName(),command);
		return new ModelAndView("viewCart","cartBean",command);
	}
	public ModelAndView returnItem(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		CartBean command = (CartBean)session.getAttribute(getFormSessionAttributeName() );
		int mediaLendingId = Integer.parseInt(request.getParameter("mediaLendingId"));
		MediaLending returnedItem = command.returnItem(mediaLendingId);
		if(!StringUtil.isNullOrEmpty(request.getParameter("paid"))){
			char paid = request.getParameter("paid").charAt(0);
			returnedItem.getFee().setPaid(paid);
			logger.debug("paid yes/no = "+paid);
		}
		try {
			mediaLendingService.returnItem(returnedItem);
		} catch (Exception e) {
			logger.error("return item failed for media "+returnedItem.getMedia().getTitle(), e);
			returnedItem.setActualReturnDate(null);
		}
		request.getSession().setAttribute(getFormSessionAttributeName(),command);
		return new ModelAndView("viewCart","cartBean",command);
	}

	private boolean hasErrors(CartBean command, ModelAndView cartView ){
		BindException errors = new BindException(command, "cartBean");
		if (getValidator().supports(command.getClass())) {
			ValidationUtils.invokeValidator(getValidator(), command, errors);
		}
		if (errors.hasErrors()) { 
			cartView.addAllObjects(errors.getModel());
			return true;
		}
		return false;
	}
	public ModelAndView checkout(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		CartBean command = (CartBean)session.getAttribute(getFormSessionAttributeName() );
		ModelAndView cartView = new ModelAndView("viewCart","cartBean",command);  
		if(!hasErrors(command,cartView)){	
			List<MediaLending> checkoutItems = command.getCheckoutItems();
			try {
				getMediaLendingService().checkout(checkoutItems);
			} catch (Exception e) {
				logger.error("checkout failed ",e);
			}
			command.moveItemsToIssuedList();
			//command = getCommand(command.getAccount().getId());
		}
		request.getSession().setAttribute(getFormSessionAttributeName(),command);
		return cartView;
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