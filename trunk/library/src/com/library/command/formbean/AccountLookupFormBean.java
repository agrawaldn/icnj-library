/**
 * Created by: dagrawal on Jan 2, 2009
 * Contact: dev.agrawal@gmail.com for help
 */
package com.library.command.formbean;

import java.io.Serializable;
import java.util.List;

import com.library.domain.Account;

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
	private String searchString;
	private List<Account> accountList;

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
	 * @param accountList the accountList to set
	 */
	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}
	/**
	 * @return the accountList
	 */
	public List<Account> getAccountList() {
		return accountList;
	}
	/**
	 * @param searchString the accountName to set
	 */
	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}
	/**
	 * @return the accountName
	 */
	public String getSearchString() {
		return searchString;
	}
}
