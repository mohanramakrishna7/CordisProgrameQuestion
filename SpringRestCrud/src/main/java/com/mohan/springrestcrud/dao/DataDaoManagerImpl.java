package com.mohan.springrestcrud.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;


import com.mohan.springrestcrud.model.Manager;

public class DataDaoManagerImpl implements DataDaomanager {
	
	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Manager> addEntity(Manager manager) throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(manager);
		List<Manager> managerList = session.createCriteria(Manager.class)
				.list();
		tx.commit();
		session.close();

		return managerList;
	}

	@Override
	public Manager getEntityById(long id) throws Exception {
		session = sessionFactory.openSession();
		Manager manager = (Manager) session.load(Manager.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return manager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Manager> getEntityList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Manager> managerList = session.createCriteria(Manager.class)
				.list();
		tx.commit();
		session.close();
		return managerList;
	}

	@Override
	public boolean deleteEntity(long id) throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(Manager.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}

}
