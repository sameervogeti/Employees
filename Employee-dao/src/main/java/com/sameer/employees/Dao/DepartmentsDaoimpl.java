package com.sameer.employees.Dao;
// default package
// Generated Jul 23, 2016 1:51:09 AM by Hibernate Tools 4.0.0.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.log4j.Logger;

import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sameer.employees.Model.Departments;

import static org.hibernate.criterion.Example.create;


public class DepartmentsDaoimpl {

	
	private static final Logger log = Logger.getLogger(DepartmentsDaoimpl.class);

	@Autowired
	private  SessionFactory sessionFactory;
		public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void persist(Departments transientInstance) {
		log.debug("persisting Departments instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Departments instance) {
		log.debug("attaching dirty Departments instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Departments instance) {
		log.debug("attaching clean Departments instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Departments persistentInstance) {
		log.debug("deleting Departments instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Departments merge(Departments detachedInstance) {
		log.debug("merging Departments instance");
		try {
			Departments result = (Departments) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Departments findById(java.lang.String id) {
		log.debug("getting Departments instance with id: " + id);
		try {
			Departments instance = (Departments) sessionFactory.getCurrentSession().get("Departments", id);
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

	public List<Departments> findByExample(Departments instance) {
		log.debug("finding Departments instance by example");
		try {
			List<Departments> results = (List<Departments>) sessionFactory.getCurrentSession()
					.createCriteria("Departments").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
