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
public class Contact extends DomainVO{
	/**
	 * Field: serialVersionUID Field Type: long
	 */
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String alias;
	private String streetAddress;
	private String city;
	private String state;
	private String country;
	private long contactHome;
	private long contactCell;

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public long getContactHome() {
		return contactHome;
	}
	public void setContactHome(long contactHome) {
		this.contactHome = contactHome;
	}
	public long getContactCell() {
		return contactCell;
	}
	public void setContactCell(long contactCell) {
		this.contactCell = contactCell;
	}
}
