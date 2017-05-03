package org.mcgill.risk.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * Abstract Dao class
 * </p>
 * 
 * //
 * @author akamami
 * 
 * @since January 29, 2015
 * @version 1.0
 *
 */
public abstract class AbstractDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void persist(Object entity) {
		getSession().persist(entity);
	}

	public void delete(Object entity) {
		getSession().delete(entity);
	}

	public Object merge(Object entity) {
		return getSession().merge(entity);
	}

}
