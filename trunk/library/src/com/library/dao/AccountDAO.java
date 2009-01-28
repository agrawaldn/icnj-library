
package com.library.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.library.command.Account;
import com.library.command.User;


public class AccountDAO {
	
	private SessionFactory sessionFactory;
	
	public Account getAccount(int accountNumber){
		Session session = getSessionFactory().openSession();
		Account returnAccount = null;
		try
		{
			Transaction tx = session.beginTransaction();
			Query query = session.getNamedQuery("fetchAccount");
            query.setInteger("accountNumber", accountNumber);
            List list = query.list();
            if(list != null && !list.isEmpty()){
            	returnAccount = (Account)list.get(0);
            }
            tx.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return returnAccount;
	}
	public List<Account> getMatchingAccounts(String searchString){
		Session session = getSessionFactory().openSession();
		List<Account> returnAccounts = null;
		try
		{
			Transaction tx = session.beginTransaction();
			Query query = session.getNamedQuery("fetchAccounts");
            query.setString("pattern", "%"+searchString.toLowerCase()+"%");
            List list = query.list();
            if(list != null && !list.isEmpty()){
            	returnAccounts = (List<Account>)list;
            }
            tx.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return returnAccounts;
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
