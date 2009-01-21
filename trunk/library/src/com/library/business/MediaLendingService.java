/**
 * Created by: dagrawal on Dec 29, 2008
 * Contact: dev.agrawal@gmail.com for help
 */
package com.library.business;

import com.library.dao.MediaLendingDAO;

/**
 * @author dagrawal
 *
 */
public class MediaLendingService {
	private MediaLendingDAO mediaLendingDAO;

	/**
	 * @param mediaLendingDAO the mediaLendingDAO to set
	 */
	public void setMediaLendingDAO(MediaLendingDAO mediaLendingDAO) {
		this.mediaLendingDAO = mediaLendingDAO;
	}

	/**
	 * @return the mediaLendingDAO
	 */
	public MediaLendingDAO getMediaLendingDAO() {
		return mediaLendingDAO;
	}
}
