/**
 * Created by: dagrawal on Dec 29, 2008
 * Contact: dev.agrawal@gmail.com for help
 */
package com.library.command;

import java.io.Serializable;
import java.util.Date;

/**
 * @author dagrawal
 *
 */
public class MediaType implements Serializable {

	/**
	 * Field: serialVersionUID Field Type: long
	 */
	private static final long serialVersionUID = 1L;
	private int mediaTypeId;
	private String mediaType;
	private String description;
	private String updatedBy;
	private Date updatedDate;
	/**
	 * @param mediaTypeId the mediaTypeId to set
	 */
	public void setMediaTypeId(int mediaTypeId) {
		this.mediaTypeId = mediaTypeId;
	}
	/**
	 * @return the mediaTypeId
	 */
	public int getMediaTypeId() {
		return mediaTypeId;
	}
	/**
	 * @param mediaType the mediaType to set
	 */
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}
	/**
	 * @return the mediaType
	 */
	public String getMediaType() {
		return mediaType;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}
	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	/**
	 * @return the updatedDate
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}

}
