package com.sameer.employees.Dao;
// default package
// Generated Jul 23, 2016 1:51:09 AM by Hibernate Tools 4.0.0.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.sameer.employees.Model.DeptManager;
import com.sameer.employees.Model.DeptManagerId;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class DeptManager.
 * @see .DeptManager
 * @author Hibernate Tools
 */
public class DeptManagerDaoimpl {

	private static final Log log = LogFactory.getLog(DeptManagerDaoimpl.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(DeptManager transientInstance) {
		log.debug("persisting DeptManager instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(DeptManager instance) {
		log.debug("attaching dirty DeptManager instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DeptManager instance) {
		log.debug("attaching clean DeptManager instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(DeptManager persistentInstance) {
		log.debug("deleting DeptManager instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DeptManager merge(DeptManager detachedInstance) {
		log.debug("merging DeptManager instance");
		try {
			DeptManager result = (DeptManager) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public DeptManager findById(DeptManagerId id) {
		log.debug("getting DeptManager instance with id: " + id);
		try {
			DeptManager instance = (DeptManager) sessionFactory.getCurrentSession().get("DeptManager", id);
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

	public List<DeptManager> findByExample(DeptManager instance) {
		log.debug("finding DeptManager instance by example");
		try {
			List<DeptManager> results = (List<DeptManager>) sessionFactory.getCurrentSession()
					.createCriteria("DeptManager").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
