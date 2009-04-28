/**
 * Created by: dagrawal on Apr 20, 2009
 * Contact: dev.agrawal@gmail.com for help
 */
package com.library.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContextHolder;
	

public class AuthenticationUtil {
	
	public static Log logger = LogFactory.getLog(AuthenticationUtil.class);
	
	public static String getUserName(){
		String userName = "unknown";
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){
			userName = auth.getName();
		}
		return userName;
	}
}
