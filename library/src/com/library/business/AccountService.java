/**
 * Created by: dagrawal on Dec 29, 2008
 * Contact: dev.agrawal@gmail.com for help
 */
package com.library.business;

import java.util.List;

import com.library.command.Account;
import com.library.dao.AccountDAO;

/**
 * @author dagrawal
 *
 */
public class AccountService {
	private AccountDAO accountDAO;

	public Account getAccount(int accountNumber){
		return accountDAO.getAccount(accountNumber);
	}
	public List<Account> getMatchingAccounts(String accountName){
		return accountDAO.getMatchingAccounts(accountName);
	}
	/**
	 * @param accountDAO the accountDAO to set
	 */
	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	/**
	 * @return the accountDAO
	 */
	public AccountDAO getAccountDAO() {
		return accountDAO;
	}
}
