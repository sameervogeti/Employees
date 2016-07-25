package com.sameer.employees.Dao;
// default package
// Generated Jul 23, 2016 1:51:09 AM by Hibernate Tools 4.0.0.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.log4j.Logger;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sameer.employees.Model.Salaries;
import com.sameer.employees.Model.SalariesId;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Salaries.
 * @see .Salaries
 * @author Hibernate Tools
 */
public class SalariesDaoimpl {

	private static final Logger log = Logger.getLogger(SalariesDaoimpl.class);

	@Autowired
	private  SessionFactory sessionFactory;
		public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void persist(Salaries transientInstance) {
		log.debug("persisting Salaries instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Salaries instance) {
		log.debug("attaching dirty Salaries instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Salaries instance) {
		log.debug("attaching clean Salaries instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Salaries persistentInstance) {
		log.debug("deleting Salaries instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Salaries merge(Salaries detachedInstance) {
		log.debug("merging Salaries instance");
		try {
			Salaries result = (Salaries) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Salaries findById(SalariesId id) {
		log.debug("getting Salaries instance with id: " + id);
		try {
			Salaries instance = (Salaries) sessionFactory.getCurrentSession().get("Salaries", id);
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

	public List<Salaries> findByExample(Salaries instance) {
		log.debug("finding Salaries instance by example");
		try {
			List<Salaries> results = (List<Salaries>) sessionFactory.getCurrentSession().createCriteria("Salaries")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
