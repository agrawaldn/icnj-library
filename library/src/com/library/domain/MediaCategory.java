/**
 * Created by: dagrawal on Dec 29, 2008
 * Contact: dev.agrawal@gmail.com for help
 */
package com.library.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author dagrawal
 *
 */
public class MediaCategory extends DomainVO {

	/**
	 * Field: serialVersionUID Field Type: long
	 */
	private static final long serialVersionUID = 1L;
//	private int mediaCategoryId;
	private String category;
	private String updatedBy;
	private Date updatedDate;
	/**
	 * @param mediaCategoryId the mediaCategoryId to set
	 */
//	public void setMediaCategoryId(int mediaCategoryId) {
//		this.mediaCategoryId = mediaCategoryId;
//	}
//	/**
//	 * @return the mediaCategoryId
//	 */
//	public int getMediaCategoryId() {
//		return mediaCategoryId;
//	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
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
