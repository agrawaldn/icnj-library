package com.library.web.validator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.library.command.formbean.CartBean;

public class CartValidator implements Validator {

    private final Log logger = LogFactory.getLog(getClass());
    
    public boolean supports(Class clazz) {
        return clazz.equals(CartBean.class);
    }

    public void validate(Object obj, Errors errors) {
    	CartBean cart = (CartBean) obj;
        int maxAllowed = cart.getAccount().getAccountType().getMaxBorrowLimit();
        int totalItems = 0;
        if(cart.getCheckoutItems()!= null){
        	totalItems += cart.getCheckoutItems().size();
        	logger.debug("Items to checkout = "+totalItems);	
        }if(cart.getIssuedItems() != null){
        	totalItems += cart.getIssuedItems().size();
        }
        if (totalItems > maxAllowed) {
        	logger.info("Number of items ("+totalItems+") exceed for "+cart.getAccount().getAccountNumber());
        	errors.rejectValue("checkoutItems","error.numberofitemsallowed.exceeded");
        }
        if(cart.getAccount().getActiveFlag() == 'n' || cart.getAccount().getActiveFlag() == 'N'){
        	logger.info("Account inactive "+cart.getAccount().getAccountNumber());
        	errors.rejectValue("account","error.account.inactive");
        }
    }

}