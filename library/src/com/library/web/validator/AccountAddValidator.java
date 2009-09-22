package com.library.web.validator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.library.domain.Account;

public class AccountAddValidator implements Validator {

    private final Log logger = LogFactory.getLog(getClass());
    
    public boolean supports(Class clazz) {
        return clazz.equals(Account.class);
    }

    public void validate(Object obj, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contact.firstName", "error.firstname.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contact.lastName", "error.lastname.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contact.contactHome", "error.contacthome.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contact.streetAddress", "error.streetaddress.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contact.city", "error.city.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fee.paid", "error.feepaid.empty");
        Account account = (Account) obj;
        if ( account.getContact().getContactHome() <= 111111111L) {
        	errors.rejectValue("contact.contactHome","error.contacthome.invalid");
        } 
    }

}