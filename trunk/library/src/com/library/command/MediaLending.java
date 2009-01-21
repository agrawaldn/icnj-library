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
public class MediaLending implements Serializable {

	/**
	 * Field: serialVersionUID Field Type: long
	 */
	private static final long serialVersionUID = 1L;
	private int mediaLendingId;
	private Media media;
	private Account account;
	private Date lendingDate;
	private Date returnDate;
	private Date actualReturnDate;
	private String updatedBy;
	private Date updatedDate;
	/**
	 * @param mediaLendingId the mediaLendingId to set
	 */
	public void setMediaLendingId(int mediaLendingId) {
		this.mediaLendingId = mediaLendingId;
	}
	/**
	 * @return the mediaLendingId
	 */
	public int getMediaLendingId() {
		return mediaLendingId;
	}
	/**
	 * @param media the media to set
	 */
	public void setMedia(Media media) {
		this.media = media;
	}
	/**
	 * @return the media
	 */
	public Media getMedia() {
		return media;
	}
	/**
	 * @param account the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}
	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}
	/**
	 * @param lendingDate the lendingDate to set
	 */
	public void setLendingDate(Date lendingDate) {
		this.lendingDate = lendingDate;
	}
	/**
	 * @return the lendingDate
	 */
	public Date getLendingDate() {
		return lendingDate;
	}
	/**
	 * @param returnDate the returnDate to set
	 */
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	/**
	 * @return the returnDate
	 */
	public Date getReturnDate() {
		return returnDate;
	}
	/**
	 * @param actualReturnDate the actualReturnDate to set
	 */
	public void setActualReturnDate(Date actualReturnDate) {
		this.actualReturnDate = actualReturnDate;
	}
	/**
	 * @return the actualReturnDate
	 */
	public Date getActualReturnDate() {
		return actualReturnDate;
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
