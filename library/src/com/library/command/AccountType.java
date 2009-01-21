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
public class AccountType implements Serializable {

	/**
	 * Field: serialVersionUID Field Type: long
	 */
	private static final long serialVersionUID = 1L;
	private int accountTypeId;
	private String accountType;
	private int maxBorrowLimit;
	private String updatedBy;
	private Date updatedDate;
	/**
	 * @param accountTypeId the accountTypeId to set
	 */
	public void setAccountTypeId(int accountTypeId) {
		this.accountTypeId = accountTypeId;
	}
	/**
	 * @return the accountTypeId
	 */
	public int getAccountTypeId() {
		return accountTypeId;
	}
	/**
	 * @param accountType the accountType to set
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	/**
	 * @return the accountType
	 */
	public String getAccountType() {
		return accountType;
	}
	/**
	 * @param maxBorrowLimit the maxBorrowLimit to set
	 */
	public void setMaxBorrowLimit(int maxBorrowLimit) {
		this.maxBorrowLimit = maxBorrowLimit;
	}
	/**
	 * @return the maxBorrowLimit
	 */
	public int getMaxBorrowLimit() {
		return maxBorrowLimit;
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
