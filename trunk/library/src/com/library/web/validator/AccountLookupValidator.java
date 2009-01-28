package com.library.web.validator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.library.command.formbean.AccountLookupFormBean;
import com.library.util.StringUtil;

public class AccountLookupValidator implements Validator {

    private final Log logger = LogFactory.getLog(getClass());
    
    public boolean supports(Class clazz) {
        return clazz.equals(AccountLookupFormBean.class);
    }

    public void validate(Object obj, Errors errors) {
        AccountLookupFormBean account = (AccountLookupFormBean) obj;
        if ( StringUtil.isNullOrEmpty(account.getAccountName())) {
        	logger.info("Name not specified.");
        	errors.rejectValue("accountName","error.accountname.empty", null,"Value required");
        } 
    }

}