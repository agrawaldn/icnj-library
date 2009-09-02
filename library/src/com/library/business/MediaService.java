/**
 * Created by: dagrawal on Dec 29, 2008
 * Contact: dev.agrawal@gmail.com for help
 */
package com.library.business;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.library.domain.Media;
import com.library.service.DomainService;

/**
 * @author dagrawal
 *
 */
public class MediaService {
	private final Log logger = LogFactory.getLog(getClass());
	private DomainService domainService;

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
	public List<Media> getMatchingMedias(String searchString) {
		String[] keys = {"pattern"};
		String[] values = {"%"+searchString.toLowerCase()+"%"}; 
		return (List<Media>)this.getDomainService().executeNamedQuery("fetchMedias", keys, values);
	}
}
