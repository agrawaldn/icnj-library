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
public class MediaCategory extends DomainVO {

	/**
	 * Field: serialVersionUID Field Type: long
	 */
	private static final long serialVersionUID = 1L;
	private String category;

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
}
