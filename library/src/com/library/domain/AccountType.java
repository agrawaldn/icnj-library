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
public class AccountType extends DomainVO {

	/**
	 * Field: serialVersionUID Field Type: long
	 */
	private static final long serialVersionUID = 1L;
	private String accountType;
	private int maxBorrowLimit;

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
}
