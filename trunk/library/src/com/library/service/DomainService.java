/**
 * Created by: dagrawal on Jul 14, 2009
 * Email: dev.agrawal@gmail.com
 */
package com.library.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.library.domain.DomainVO;
import com.library.domain.User;

public class DomainService {
	
	private final Log logger = LogFactory.getLog(DomainService.class); 
	private SessionFactory sessionFactory;
	
	public void saveDomainObject(DomainVO domainVO){
		Session session = getSessionFactory().openSession();
		try
		{
			Transaction tx = session.beginTransaction();
			
			session.save(domainVO);
			tx.commit();
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}finally{
			session.close();
		}
	}
	
	public void refreshDomainObject(DomainVO domainVO){
		Session session = getSessionFactory().openSession();
		try
		{
			Transaction tx = session.beginTransaction();
			
			session.refresh(domainVO);
			tx.commit();
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}finally{
			session.close();
		}
	}

	public List executeNamedQuery(String namedQuery, String[] keys, String[] values){
		Session session = getSessionFactory().openSession();
		List list = null;
		try
		{
			Transaction tx = session.beginTransaction();
			Query query = session.getNamedQuery(namedQuery);
            for(int i=0;i<keys.length;i++){
            	query.setString(keys[i], values[i]);
            }
            list = query.list();
            tx.commit();
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}finally{
			session.close();
		}
		return list;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
