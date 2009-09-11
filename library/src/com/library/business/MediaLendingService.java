/**
 * Created by: dagrawal on Dec 29, 2008
 * Contact: dev.agrawal@gmail.com for help
 */
package com.library.business;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.library.domain.Account;
import com.library.domain.Fee;
import com.library.domain.Media;
import com.library.domain.MediaLending;
import com.library.service.DomainService;
import com.library.util.AuthenticationUtil;
import com.library.util.Constant;
import com.library.util.DateUtil;

/**
 * @author dagrawal
 *
 */
public class MediaLendingService {
	private final Log logger = LogFactory.getLog(getClass());
	private DomainService domainService;

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

	public List<MediaLending> getMediaLendings(int accountId){
		String[] keys = {"accountId"};
		String[] values = {""+accountId}; 
		List<MediaLending> lendings = (List<MediaLending>)this.getDomainService().executeNamedQuery("fetchMediaLending", keys, values);
		for(MediaLending lending : lendings){
			if(lending.getReturnDate().before(new Date())){
				Fee fee = new Fee();
				int daysLate = DateUtil.daysBetween2Dates(lending.getReturnDate(), new Date());
				double weeksLate = Math.floor(daysLate/7);
				fee.setAmount(weeksLate*Constant.LATE_FEE_RATE);
				fee.setFeeType(Constant.LATE_FEE);
				fee.setPaid('n');
				lending.setFee(fee);
			}
		}
		return lendings; 
	}
	
	/**
	 * @param mediaId
	 * @param account
	 * @return
	 */
	public MediaLending getMediaLending(int mediaId, Account account) {
		Media media = (Media)this.getDomainService().getDomainObject(Media.class, mediaId);
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
		return item;
	}

	/**
	 * @param mediaLendingId
	 */
	public void returnItem(MediaLending returnedItem) throws Exception{
		returnedItem.setActualReturnDate(new Date());
		if(returnedItem.getFee() != null){
			this.getDomainService().saveDomainObject(returnedItem.getFee());
		}
		this.getDomainService().updateDomainObject(returnedItem);
	}

	/**
	 * @param checkoutItems
	 */
	public void checkout(List<MediaLending> checkoutItems) throws Exception{
		for(MediaLending checkoutItem:checkoutItems){
			this.getDomainService().saveDomainObject(checkoutItem);
		}
	}
}
