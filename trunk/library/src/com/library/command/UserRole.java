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
public class UserRole implements Serializable {
	/**
	 * Field: serialVersionUID Field Type: long
	 */
	private static final long serialVersionUID = 1L;
	private int userRoleId;
	private String userRole;
	private String updatedBy;
	private Date updatedDate;
	
	/**
	 * @param userRoleId the userRoleId to set
	 */
	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}
	/**
	 * @return the userRoleId
	 */
	public int getUserRoleId() {
		return userRoleId;
	}
	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	/**
	 * @return the userRole
	 */
	public String getUserRole() {
		return userRole;
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
