package com.library.web.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import com.library.business.AccountService;
import com.library.business.MediaService;
import com.library.domain.Account;
import com.library.domain.AccountType;
import com.library.domain.Contact;
import com.library.domain.Fee;
import com.library.domain.Media;
import com.library.domain.MediaCategory;
import com.library.domain.MediaType;
import com.library.util.DateUtil;

public class MediaController extends SimpleFormController  {
	private final Log logger = LogFactory.getLog(MediaController.class);
	private MediaService mediaService;

	private Media getCommand(){
		Media media = new Media();
		media.setMediaType(new MediaType());
		media.setCategory(new MediaCategory());
		return media;
	}
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception	{    
		DateFormat df = new SimpleDateFormat(DateUtil.dateFormat);    
		df.setLenient(false);    
		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, true));    
		super.initBinder(request,binder);
	}
	public Object formBackingObject(HttpServletRequest request) {
		return getCommand();
		
	}
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, 
	        Object command, BindException errors) throws Exception {
		Media media = (Media) command;
		this.getMediaService().addMedia(media);
    	return showForm(request, response, errors);
    }
	/**
	 * @param mediaService the mediaService to set
	 */
	public void setMediaService(MediaService mediaService) {
		this.mediaService = mediaService;
	}
	/**
	 * @return the mediaService
	 */
	public MediaService getMediaService() {
		return mediaService;
	}

}