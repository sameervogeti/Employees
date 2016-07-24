package com.sameer.employees.Dao;
// default package
// Generated Jul 23, 2016 1:51:09 AM by Hibernate Tools 4.0.0.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.log4j.Logger;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.sameer.employees.Model.Titles;
import com.sameer.employees.Model.TitlesId;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Titles.
 * @see .Titles
 * @author Hibernate Tools
 */
public class TitlesDaoimpl {

	private static final Logger log = Logger.getLogger(TitlesDaoimpl.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Titles transientInstance) {
		log.debug("persisting Titles instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Titles instance) {
		log.debug("attaching dirty Titles instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Titles instance) {
		log.debug("attaching clean Titles instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Titles persistentInstance) {
		log.debug("deleting Titles instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Titles merge(Titles detachedInstance) {
		log.debug("merging Titles instance");
		try {
			Titles result = (Titles) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Titles findById(TitlesId id) {
		log.debug("getting Titles instance with id: " + id);
		try {
			Titles instance = (Titles) sessionFactory.getCurrentSession().get("Titles", id);
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

	public List<Titles> findByExample(Titles instance) {
		log.debug("finding Titles instance by example");
		try {
			List<Titles> results = (List<Titles>) sessionFactory.getCurrentSession().createCriteria("Titles")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
