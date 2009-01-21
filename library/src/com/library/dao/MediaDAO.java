
package com.library.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.library.command.User;


public class MediaDAO {
	
	private SessionFactory sessionFactory;
	
	public void saveUser(User user){
		Session session = getSessionFactory().openSession();
		try
		{
			Transaction tx = session.beginTransaction();
			
			session.save(user);
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}

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
