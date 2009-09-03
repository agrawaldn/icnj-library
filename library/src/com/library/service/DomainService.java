/**
 * Created by: dagrawal on Jul 14, 2009
 * Email: dev.agrawal@gmail.com
 */
package com.library.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.library.domain.DomainVO;
import com.library.domain.Media;
import com.library.domain.User;
import com.library.util.AuthenticationUtil;

public class DomainService {
	
	private final Log logger = LogFactory.getLog(DomainService.class); 
	private SessionFactory sessionFactory;
	
	public void saveDomainObject(DomainVO domainVO){
		domainVO.setUpdatedBy(AuthenticationUtil.getUserName());
		domainVO.setUpdatedDate(new Date());
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
	public void updateDomainObject(DomainVO domainVO){
		domainVO.setUpdatedBy(AuthenticationUtil.getUserName());
		domainVO.setUpdatedDate(new Date());
		Session session = getSessionFactory().openSession();
		try
		{
			Transaction tx = session.beginTransaction();
			
			session.update(domainVO);
			tx.commit();
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}finally{
			session.close();
		}
	}
	public DomainVO getDomainObject(Class c, int id){
		DomainVO domainVO = null;
		Session session = getSessionFactory().openSession();
		try{
			Transaction tx = session.beginTransaction();
			domainVO = (DomainVO)session.get(c, new Integer(id));
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return domainVO;
	}
	public DomainVO getDomainObject(String namedQuery, String[] keys, String[] values){
		List list = this.executeNamedQuery(namedQuery, keys, values);
		DomainVO vo = null;
		if(list != null && !list.isEmpty()){
			vo = (DomainVO) list.get(0);
		}
		return vo;
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
