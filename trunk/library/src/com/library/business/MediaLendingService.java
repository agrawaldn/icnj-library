/**
 * Created by: dagrawal on Dec 29, 2008
 * Contact: dev.agrawal@gmail.com for help
 */
package com.library.business;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.library.command.Account;
import com.library.command.Media;
import com.library.command.MediaLending;
import com.library.command.formbean.CartBean;
import com.library.dao.MediaLendingDAO;

/**
 * @author dagrawal
 *
 */
public class MediaLendingService {
	private final Log logger = LogFactory.getLog(MediaLendingService.class);
	private MediaLendingDAO mediaLendingDAO;

	public List<MediaLending> getMediaLendings(int accountId){
		return getMediaLendingDAO().getMediaLendings(accountId);
	}
	
	/**
	 * @param mediaLendingDAO the mediaLendingDAO to set
	 */
	public void setMediaLendingDAO(MediaLendingDAO mediaLendingDAO) {
		this.mediaLendingDAO = mediaLendingDAO;
	}

	/**
	 * @return the mediaLendingDAO
	 */
	public MediaLendingDAO getMediaLendingDAO() {
		return mediaLendingDAO;
	}

	/**
	 * @param mediaId
	 * @param account
	 * @return
	 */
	public MediaLending getMediaLending(int mediaId, Account account) {
		Media media = mediaLendingDAO.getMedia(mediaId);
		logger.debug("mediaId "+mediaId+" retrieved: "+media.getTitle());
		MediaLending item = new MediaLending();
		item.setAccount(account);
		item.setMedia(media);
		item.setLendingDate(new Date());
		item.setUpdatedBy("");
		item.setUpdatedDate(new Date());
		return item;
	}

	/**
	 * @param mediaLendingId
	 */
	public void returnItem(MediaLending returnedItem) throws Exception{
		getMediaLendingDAO().returnItem(returnedItem);
	}

	/**
	 * @param checkoutItems
	 */
	public void checkout(List<MediaLending> checkoutItems) throws Exception{
		for(MediaLending checkoutItem:checkoutItems){
			getMediaLendingDAO().saveItem(checkoutItem);
		}
	}
}
