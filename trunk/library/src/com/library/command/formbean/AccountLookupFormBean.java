/**
 * Created by: dagrawal on Jan 2, 2009
 * Contact: dev.agrawal@gmail.com for help
 */
package com.library.command.formbean;

import java.io.Serializable;

/**
 * @author dagrawal
 *
 */
public class AccountLookupFormBean implements Serializable {
	/**
	 * Field: serialVersionUID Field Type: long
	 */
	private static final long serialVersionUID = 1L;
	private int accountNumber;

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
}
