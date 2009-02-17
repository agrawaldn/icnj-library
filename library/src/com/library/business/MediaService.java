/**
 * Created by: dagrawal on Dec 29, 2008
 * Contact: dev.agrawal@gmail.com for help
 */
package com.library.business;

import java.util.List;

import com.library.command.Account;
import com.library.command.Media;
import com.library.dao.MediaDAO;

/**
 * @author dagrawal
 *
 */
public class MediaService {
	private MediaDAO mediaDAO;

	/**
	 * @param mediaDAO the mediaDAO to set
	 */
	public void setMediaDAO(MediaDAO mediaDAO) {
		this.mediaDAO = mediaDAO;
	}

	/**
	 * @return the mediaDAO
	 */
	public MediaDAO getMediaDAO() {
		return mediaDAO;
	}

	/**
	 * @param searchString
	 * @return
	 */
	public List<Media> getMatchingMedias(String searchString) {
		return getMediaDAO().getMatchingMedias(searchString);
	}
}
