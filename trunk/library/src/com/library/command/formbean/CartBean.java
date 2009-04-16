/**
 * Created by: dagrawal on Apr 15, 2009
 * Contact: dev.agrawal@gmail.com for help
 */
package com.library.command.formbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.library.command.Account;
import com.library.command.Media;
import com.library.command.MediaLending;

public class CartBean implements Serializable {
	/**
	 * Field: serialVersionUID Field Type: long
	 */
	private static final long serialVersionUID = 1L;
	private List<MediaLending> issuedItems;
	private List<MediaLending> checkoutItems;
	/**
	 * @param issuedItems the mediaLendingList to set
	 */
	public void setIssuedItems(List<MediaLending> issuedItems) {
		this.issuedItems = issuedItems;
	}
	/**
	 * @return the mediaLendingList
	 */
	public List<MediaLending> getIssuedItems() {
		return issuedItems;
	}
	public Account getAccount(){
		if (issuedItems!= null && !(issuedItems.isEmpty())){
			return issuedItems.get(0).getAccount();
		}else{
			return null;
		}
	}
	/**
	 * @param checkoutItems the checkoutItems to set
	 */
	public void setCheckoutItems(List<MediaLending> checkoutItems) {
		this.checkoutItems = checkoutItems;
	}
	/**
	 * @return the checkoutItems
	 */
	public List<MediaLending> getCheckoutItems() {
		return checkoutItems;
	}
	
	public void addItem(MediaLending ml){
		if(checkoutItems == null){
			checkoutItems = new ArrayList<MediaLending>();
		}
		checkoutItems.add(ml);
	}
	/**
	 * @param mediaId
	 */
	public void removeItem(int mediaId) {
		for(int i=0;i<checkoutItems.size();i++){
			if(checkoutItems.get(i).getMedia().getMediaId() == mediaId){
				checkoutItems.remove(i);
			}
		}
	}

}
