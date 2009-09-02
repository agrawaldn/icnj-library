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
public class Media extends DomainVO {

	/**
	 * Field: serialVersionUID Field Type: long
	 */
	private static final long serialVersionUID = 1L;
//	private int mediaId;
	private String title;
	private MediaType mediaType;
	private MediaCategory category;
	private int volumeNumber;
	private int totalVolume;
	private int copies;
	private String description;
	private String location;
	private String author;
	private String company;
	private String updatedBy;
	private Date updatedDate;
	/**
	 * @param mediaId the mediaId to set
	 */
//	public void setMediaId(int mediaId) {
//		this.mediaId = mediaId;
//	}
//	/**
//	 * @return the mediaId
//	 */
//	public int getMediaId() {
//		return mediaId;
//	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param mediaType the mediaType to set
	 */
	public void setMediaType(MediaType mediaType) {
		this.mediaType = mediaType;
	}
	/**
	 * @return the mediaType
	 */
	public MediaType getMediaType() {
		return mediaType;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(MediaCategory category) {
		this.category = category;
	}
	/**
	 * @return the category
	 */
	public MediaCategory getCategory() {
		return category;
	}
	/**
	 * @param volumeNumber the volumeNumber to set
	 */
	public void setVolumeNumber(int volumeNumber) {
		this.volumeNumber = volumeNumber;
	}
	/**
	 * @return the volumeNumber
	 */
	public int getVolumeNumber() {
		return volumeNumber;
	}
	/**
	 * @param totalVolume the totalVolume to set
	 */
	public void setTotalVolume(int totalVolume) {
		this.totalVolume = totalVolume;
	}
	/**
	 * @return the totalVolume
	 */
	public int getTotalVolume() {
		return totalVolume;
	}
	/**
	 * @param copies the copies to set
	 */
	public void setCopies(int copies) {
		this.copies = copies;
	}
	/**
	 * @return the copies
	 */
	public int getCopies() {
		return copies;
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
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
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
