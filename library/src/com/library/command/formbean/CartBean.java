/**
 * Created by: dagrawal on Apr 15, 2009
 * Contact: dev.agrawal@gmail.com for help
 */
package com.library.command.formbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.library.domain.Account;
import com.library.domain.Media;
import com.library.domain.MediaLending;

public class CartBean implements Serializable {
	/**
	 * Field: serialVersionUID Field Type: long
	 */
	private static final long serialVersionUID = 1L;
	private List<MediaLending> issuedItems;
	private List<MediaLending> checkoutItems;
	private Account account;
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
	public void setAccount(Account account){
		this.account = account;
	}
	public Account getAccount(){
		return account;
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
	
	public void addToCart(MediaLending ml){
		if(checkoutItems == null){
			checkoutItems = new ArrayList<MediaLending>();
		}
		checkoutItems.add(ml);
	}
	/**
	 * @param mediaId
	 */
	public void removeFromCart(int mediaId) {
		for(int i=0;i<checkoutItems.size();i++){
			if(checkoutItems.get(i).getMedia().getId() == mediaId){
				checkoutItems.remove(i);
			}
		}
	}
	/**
	 * @param mediaLendingId
	 */
	public MediaLending returnItem(int mediaLendingId) {
		MediaLending returnedItem = null;
		for(int i=0;i<issuedItems.size();i++){
			if(issuedItems.get(i).getId() == mediaLendingId){
				returnedItem = issuedItems.remove(i);
				returnedItem.setActualReturnDate(new Date());
			}
		}
		return returnedItem;
	}
	public void moveItemsToIssuedList(){
		this.getIssuedItems().addAll(this.getCheckoutItems());
		this.setCheckoutItems(null);
	}
}
