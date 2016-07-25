package com.sameer.employees.Dao;
// default package
// Generated Jul 23, 2016 1:51:09 AM by Hibernate Tools 4.0.0.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.log4j.Logger;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sameer.employees.Model.DeptEmp;
import com.sameer.employees.Model.DeptEmpId;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class DeptEmp.
 * @see .DeptEmp
 * @author Hibernate Tools
 */
public class DeptEmpDaoimpl {

	private static final Logger log = Logger.getLogger(DeptEmpDaoimpl.class);

	@Autowired
	private  SessionFactory sessionFactory;
		public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void persist(DeptEmp transientInstance) {
		log.debug("persisting DeptEmp instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(DeptEmp instance) {
		log.debug("attaching dirty DeptEmp instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DeptEmp instance) {
		log.debug("attaching clean DeptEmp instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(DeptEmp persistentInstance) {
		log.debug("deleting DeptEmp instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DeptEmp merge(DeptEmp detachedInstance) {
		log.debug("merging DeptEmp instance");
		try {
			DeptEmp result = (DeptEmp) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public DeptEmp findById(DeptEmpId id) {
		log.debug("getting DeptEmp instance with id: " + id);
		try {
			DeptEmp instance = (DeptEmp) sessionFactory.getCurrentSession().get("DeptEmp", id);
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

	public List<DeptEmp> findByExample(DeptEmp instance) {
		log.debug("finding DeptEmp instance by example");
		try {
			List<DeptEmp> results = (List<DeptEmp>) sessionFactory.getCurrentSession().createCriteria("DeptEmp")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
