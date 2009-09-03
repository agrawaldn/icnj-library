/**
 * Created by: dagrawal on Dec 29, 2008
 * Contact: dev.agrawal@gmail.com for help
 */
package com.library.domain;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.library.util.DateUtil;

/**
 * @author dagrawal
 *
 */
public class Account extends DomainVO {
	/**
	 * Field: serialVersionUID Field Type: long
	 */
	private final Log logger = LogFactory.getLog(getClass());
	private static final long serialVersionUID = 1L;
	private long accountNumber;
	private Contact contact;
	private Date startDate;
	private Date endDate;
	private AccountType accountType;
	private char activeFlag;

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	/**
	 * @return the accountNumber
	 */
	public long getAccountNumber() {
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
	private void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public void setStartDate(String startDate){
		this.setStartDate(DateUtil.parseDate(startDate, DateUtil.dateFormat));
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
	private void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public void setEndDate(String endDate){
		this.setEndDate(DateUtil.parseDate(endDate, DateUtil.dateFormat));
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
}
