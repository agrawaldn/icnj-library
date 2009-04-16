package com.library.web.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.library.business.MediaLendingService;
import com.library.business.MediaService;
import com.library.command.Media;
import com.library.command.MediaLending;
import com.library.command.formbean.CartBean;
import com.library.command.formbean.MediaLookupFormBean;
import com.library.util.StringUtil;

public class CartController extends SimpleFormController  {
	private final Log logger = LogFactory.getLog(CartController.class);
	private MediaLendingService mediaLendingService;

	private CartBean getCommand(int accountNumber){
		CartBean command = new CartBean();
		if(accountNumber > 0 && (command.getCheckoutItems() == null)){
	    	List<MediaLending> issuedItems = getMediaLendingService().getMediaLendings(accountNumber);
	    	if(issuedItems != null){
	    		logger.debug("Number of items issued to account "+accountNumber+" = "+issuedItems.size());
	    		command.setIssuedItems(issuedItems);
	    	}
		}
		return command;
	}
	public Object formBackingObject(HttpServletRequest request) {
		logger.debug("CartController --> formBackingObject called...");
		Object object = null;
		String acctNo = request.getParameter("accountNo");
		int accountNumber = 0;
		if(!StringUtil.isNullOrEmpty(acctNo)){
			accountNumber = Integer.parseInt(acctNo);
		}
		//try to get shopping cart from the session only when no account number was specified
		if(isSessionForm() && accountNumber <= 0) {
			HttpSession session = request.getSession();
			logger.debug("session form attribute is: "+getFormSessionAttributeName());
			object = session.getAttribute(getFormSessionAttributeName() );
		}
		else{
			object = getCommand(accountNumber);
		}
		return object;
	}
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, 
	        Object command, BindException errors) throws Exception {
		
		//put the cart back in the session after submitting
		request.getSession().setAttribute(getFormSessionAttributeName(),command);
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
}