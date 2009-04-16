
package com.library.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.library.command.Media;
import com.library.command.User;


public class MediaDAO {
	
	private SessionFactory sessionFactory;
	
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


	/**
	 * @return
	 */
	public List<Media> getMatchingMedias(String searchString) {
		Session session = getSessionFactory().openSession();
		List<Media> returnMedias = null;
		try
		{
			Transaction tx = session.beginTransaction();
			Query query = session.getNamedQuery("fetchMedias");
            query.setString("pattern", "%"+searchString.toLowerCase()+"%");
            List list = query.list();
            if(list != null && !list.isEmpty()){
            	returnMedias = (List<Media>)list;
            }
            tx.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return returnMedias;
	}
}
