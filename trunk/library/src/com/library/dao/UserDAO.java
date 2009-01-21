
package com.library.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.library.command.User;


public class UserDAO {
	
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
	
	public User getUser(User user){
		Session session = getSessionFactory().openSession();
		User returnUser = user;
		try
		{
			Transaction tx = session.beginTransaction();
			Query query = session.getNamedQuery("validateUser");
            query.setString("userName", user.getUserName());
            query.setString("password", user.getPassword());
            List list = query.list();
            if(list != null && !list.isEmpty()){
            	returnUser = (User)list.get(0);
            }
            tx.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return returnUser;
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
