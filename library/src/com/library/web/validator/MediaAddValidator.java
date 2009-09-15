package com.library.web.validator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.library.domain.Media;

public class MediaAddValidator implements Validator {

    private final Log logger = LogFactory.getLog(getClass());
    
    public boolean supports(Class clazz) {
        return clazz.equals(Media.class);
    }

    public void validate(Object obj, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "error.title.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "author", "error.author.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mediaType.mediaType", "error.mediatype.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "category.category", "error.category.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "company", "error.company.empty");
    }

}