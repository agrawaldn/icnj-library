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
public class Account implements Serializable {
	/**
	 * Field: serialVersionUID Field Type: long
	 */
	private static final long serialVersionUID = 1L;
	private int accountId;
	private int accountNumber;
	private Contact contact;
	private Date startDate;
	private Date endDate;
	private AccountType accountType;
	private char activeFlag;
	private String updatedBy;
	private Date updatedDate;
	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	/**
	 * @return the accountId
	 */
	public int getAccountId() {
		return accountId;
	}
	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	/**
	 * @return the accountNumber
	 */
	public int getAccountNumber() {
		return accountNumber;
	}
	/**
	 * @param contact the contact to set
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	/**
	 * @return the contact
	 */
	public Contact getContact() {
		return contact;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * @param accountType the accountType to set
	 */
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	/**
	 * @return the accountType
	 */
	public AccountType getAccountType() {
		return accountType;
	}
	/**
	 * @param activeFlag the activeFlag to set
	 */
	public void setActiveFlag(char activeFlag) {
		this.activeFlag = activeFlag;
	}
	/**
	 * @return the activeFlag
	 */
	public char getActiveFlag() {
		return activeFlag;
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
