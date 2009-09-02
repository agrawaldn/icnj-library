/**
 * Created by: dagrawal on Jan 2, 2009
 * Contact: dev.agrawal@gmail.com for help
 */
package com.library.command.formbean;

import java.io.Serializable;
import java.util.List;

import com.library.domain.Media;

public class MediaLookupFormBean implements Serializable {
	/**
	 * Field: serialVersionUID Field Type: long
	 */
	private static final long serialVersionUID = 1L;
	private String searchString;
	private List<Media> mediaList;
	
	/**
	 * @param mediaList the mediaList to set
	 */
	public void setMediaList(List<Media> mediaList) {
		this.mediaList = mediaList;
	}
	/**
	 * @return the mediaList
	 */
	public List<Media> getMediaList() {
		return mediaList;
	}
	/**
	 * @param searchString the searchString to set
	 */
	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}
	/**
	 * @return the searchString
	 */
	public String getSearchString() {
		return searchString;
	}

}
