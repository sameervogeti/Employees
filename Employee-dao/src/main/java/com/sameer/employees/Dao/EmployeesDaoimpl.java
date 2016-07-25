package com.sameer.employees.Dao;
// default package
// Generated Jul 23, 2016 1:51:09 AM by Hibernate Tools 4.0.0.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.log4j.Logger;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sameer.employees.Model.Employees;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Employees.
 * @see .Employees
 * @author Hibernate Tools
 */
public class EmployeesDaoimpl {

	private static final Logger log = Logger.getLogger(EmployeesDaoimpl.class);

	@Autowired
	private  SessionFactory sessionFactory;
		public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void persist(Employees transientInstance) {
		log.debug("persisting Employees instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Employees instance) {
		log.debug("attaching dirty Employees instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Employees instance) {
		log.debug("attaching clean Employees instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Employees persistentInstance) {
		log.debug("deleting Employees instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Employees merge(Employees detachedInstance) {
		log.debug("merging Employees instance");
		try {
			Employees result = (Employees) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Employees findById(long id) {
		log.debug("getting Employees instance with id: " + id);
		try {
			Employees instance = (Employees) sessionFactory.getCurrentSession().get("Employees", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Employees> findByExample(Employees instance) {
		log.debug("finding Employees instance by example");
		try {
			List<Employees> results = (List<Employees>) sessionFactory.getCurrentSession().createCriteria("Employees")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
