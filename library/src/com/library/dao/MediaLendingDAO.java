
package com.library.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.library.command.Media;
import com.library.command.MediaLending;
import com.library.command.User;


public class MediaLendingDAO {
	
	private SessionFactory sessionFactory;
	
	public List<MediaLending> getMediaLendings(int accountNumber){
		Session session = getSessionFactory().openSession();
		List<MediaLending> returnMediaList = null;
		try{
			Transaction tx = session.beginTransaction();
			Query query = session.getNamedQuery("fetchMediaLending");
            query.setInteger("accountNumber", accountNumber);
            List list = query.list();
            if(list != null && !list.isEmpty()){
            	returnMediaList = (List<MediaLending>)list;
            }
            tx.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return returnMediaList;
	}
	public Media getMedia(int mediaId){
		Media media = null;
		Session session = getSessionFactory().openSession();
		try{
			Transaction tx = session.beginTransaction();
			media = (Media)session.get(Media.class, new Integer(mediaId));
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return media;
	}

	/**
	 * @return Returns the sessionFactory.
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	/**
	 * @param sessionFactory The sessionFactory to set.
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
