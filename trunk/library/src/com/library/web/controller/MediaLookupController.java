package com.library.web.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.library.business.MediaService;
import com.library.command.formbean.MediaLookupFormBean;
import com.library.domain.Media;
import com.library.util.StringUtil;

public class MediaLookupController extends SimpleFormController  {
	private final Log logger = LogFactory.getLog(MediaLookupController.class);
	private MediaService mediaService;

	private MediaLookupFormBean getCommand(String searchString){
		MediaLookupFormBean command = new MediaLookupFormBean();
		if(!StringUtil.isNullOrEmpty(searchString)){
	    	List<Media> mediaList = getMediaService().getMatchingMedias(searchString);
	    	if(mediaList != null){
	    		logger.debug("mediaList size = "+mediaList.size());
	    		command.setMediaList(mediaList);
	    	}
		}
		return command;
	}
	public Object formBackingObject(HttpServletRequest request) {
		logger.debug("formBackingObject called...");
		String searchString = request.getParameter("searchString");
		return getCommand(searchString);
		
	}
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, 
	        Object command, BindException errors) throws Exception {

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