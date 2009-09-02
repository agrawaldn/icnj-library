/**
 * Created by: dagrawal on Dec 29, 2008
 * Contact: dev.agrawal@gmail.com for help
 */
package com.library.business;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.library.command.formbean.CartBean;
import com.library.dao.MediaLendingDAO;
import com.library.domain.Account;
import com.library.domain.Media;
import com.library.domain.MediaLending;
import com.library.util.AuthenticationUtil;
import com.library.util.Constant;
import com.library.util.DateUtil;

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
		Date currentDate = new Date();
		Date returnDate = null;
		item.setAccount(account);
		item.setMedia(media);
		item.setLendingDate(currentDate);
		if(media.getMediaType().getMediaType().equalsIgnoreCase("book")){
			returnDate = DateUtil.addDays(currentDate,Constant.BOOK_RETURN_DAYS);
		}else{
			returnDate = DateUtil.addDays(currentDate,Constant.MEDIA_RETURN_DAYS);
		}
		item.setReturnDate(returnDate);
		item.setUpdatedBy(AuthenticationUtil.getUserName());
		item.setUpdatedDate(currentDate);
		return item;
	}

	/**
	 * @param mediaLendingId
	 */
	public void returnItem(MediaLending returnedItem) throws Exception{
		returnedItem.setUpdatedBy(AuthenticationUtil.getUserName());
		returnedItem.setUpdatedDate(new Date());
		returnedItem.setActualReturnDate(new Date());
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
