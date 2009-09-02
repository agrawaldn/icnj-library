/**
 * Created by: dagrawal on Jul 14, 2009
 * Email: dagrawal@research.att.com
 */
package com.library.domain;

import java.io.Serializable;

/**
 * @author dagrawal
 *
 */
public abstract class DomainVO implements Serializable{
	private int id;

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
}
