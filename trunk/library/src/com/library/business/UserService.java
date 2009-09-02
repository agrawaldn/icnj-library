/**
 * Created by: dagrawal on Dec 29, 2008
 * Contact: dev.agrawal@gmail.com for help
 */
package com.library.business;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.library.domain.User;
import com.library.service.DomainService;

/**
 * @author dagrawal
 *
 */
public class UserService {
	private final Log logger = LogFactory.getLog(getClass());
	private DomainService domainService;

	
	public boolean authenticateUser(User user){
		String[] keys = {"userName","password"};
		String[] values = {user.getUserName(),user.getPassword()};
        int userId = ((User)this.getDomainService().executeNamedQuery("validateUser", keys, values).get(0)).getId();
		if(userId > 0){
			return true;
		}else{
			return false;
		}
	}
	public void saveUser(User user){
		this.getDomainService().saveDomainObject(user);
	}
	/**
	 * @param domainService the domainService to set
	 */
	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}
	/**
	 * @return the domainService
	 */
	public DomainService getDomainService() {
		return domainService;
	}
	/**
	 * @param searchString
	 * @return
	 */
}
