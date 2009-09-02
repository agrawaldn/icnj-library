/**
 * Created by: dagrawal on Dec 29, 2008
 * Contact: dev.agrawal@gmail.com for help
 */
package com.library.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.library.domain.Account;
import com.library.domain.AccountType;
import com.library.domain.Contact;
import com.library.domain.DomainVO;
import com.library.service.DomainService;
import com.library.util.DateUtil;

/**
 * @author dagrawal
 *
 */
public class AccountService {
	private final Log logger = LogFactory.getLog(getClass());
	private DomainService domainService;

	public Account getAccount(int accountNumber){
		String[] keys = {"accountNumber"};
		String[] values = {""+accountNumber}; 
		return (Account)this.getDomainService().executeNamedQuery("fetchAccount",keys, values).get(0);
	}
	public List<Account> getMatchingAccounts(String accountName){
		String[] keys = {"pattern"};
		String[] values = {"%"+accountName.toLowerCase()+"%"};
		return (List<Account>)this.getDomainService().executeNamedQuery("fetchAccounts", keys, values);
	}
	public void getAccount(Account account)throws Exception{
		if(account == null){
			//do nothing
		}else if(account.getId() <= 0 ){
			throw new Exception("accountId not set in account. Cannot refresh");
		}else{
			this.getDomainService().refreshDomainObject(account);
		}
	}
	/**
	 * @param acct
	 */
	public void createAccount(Account acct) {
		if(acct.getStartDate() == null){
			acct.setStartDate(new Date());
		}
		if(acct.getEndDate() == null){
			acct.setEndDate(DateUtil.addDays(new Date(),365));
		}
		String[] keys = {"accountType"};
		String[] values = {acct.getAccountType().getAccountType()};
		acct.setAccountType((AccountType)(this.getDomainService().executeNamedQuery("fetchAccountType", keys, values).get(0)));
		logger.debug("Creating account with acct no: "+acct.getContact().getContactHome());
		acct.setAccountNumber(acct.getContact().getContactHome());
		acct.setActiveFlag('y');
		String[] keys1 = {"contactHome","firstName"};
		String[] values1 = {""+acct.getContact().getContactHome(),acct.getContact().getFirstName()};
		Contact contact = (Contact)(this.getDomainService().executeNamedQuery("fetchContact", keys1, values1).get(0));
		if(contact.getId() > 0){
			acct.setContact(contact);
		}else{
			this.getDomainService().saveDomainObject(acct.getContact());
		}
		this.getDomainService().saveDomainObject(acct);
		
	}
	/**
	 * @param domainService the domainService to set
	 */
	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}
	/**
	 * @return the domainService
	 */
	public DomainService getDomainService() {
		return domainService;
	}
}
