package com.library.web.validator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.library.command.formbean.AccountLookupFormBean;

public class AccountLookupValidator implements Validator {

    private final Log logger = LogFactory.getLog(getClass());
    
    public boolean supports(Class clazz) {
        return clazz.equals(AccountLookupFormBean.class);
    }

    public void validate(Object obj, Errors errors) {
        AccountLookupFormBean account = (AccountLookupFormBean) obj;
        if ( account.getAccountNumber() < 1) {
        	logger.info("Account number not specified.");
        	errors.rejectValue("accountNumber","error.accountnumber.empty", null,"Value required");
//            errors.rejectValue("userName", "error.login.not-specified", null,
//                    "Value required.");
        } 
    }

}