package com.library.web.validator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.library.command.formbean.CartBean;
import com.library.domain.Account;

public class CartValidator implements Validator {

    private final Log logger = LogFactory.getLog(getClass());
    
    public boolean supports(Class clazz) {
        return clazz.equals(CartBean.class);
    }

    public void validate(Object obj, Errors errors) {
    	logger.error("cart validator called");
        CartBean cart = (CartBean) obj;
        int maxAllowed = cart.getAccount().getAccountType().getMaxBorrowLimit();
        int totalItems = 0;
        if(cart.getCheckoutItems()!= null){
        	totalItems += cart.getCheckoutItems().size();
        }if(cart.getIssuedItems() != null){
        	totalItems += cart.getIssuedItems().size();
        }
        logger.debug("Total items = "+totalItems);
        if (totalItems > maxAllowed) {
        	errors.rejectValue("checkoutItems","error.numberofitemsallowed.exceeded");
        }
    }

}