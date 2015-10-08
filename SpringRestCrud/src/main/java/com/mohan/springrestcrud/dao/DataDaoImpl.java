package com.mohan.springrestcrud.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.mohan.springrestcrud.model.Employee;

public class DataDaoImpl implements DataDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	/*
	 * To insert the record into the Employee Table
	 * @see com.mohan.springrestcrud.dao.DataDao#addEntity(com.mohan.springrestcrud.model.Employee)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> addEntity(Employee employee) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(employee);
		List<Employee> employeeList = session.createCriteria(Employee.class)
				.list();
		tx.commit();
		session.close();

		return employeeList;
	}

	/*
	 * To get the Employee record from the database
	 * @see com.mohan.springrestcrud.dao.DataDao#getEntityById(long)
	 */
	@Override
	public Employee getEntityById(long id) throws Exception {
		session = sessionFactory.openSession();
		Employee employee = (Employee) session.load(Employee.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return employee;
	}

	/*
	 * To get Entire Employee records
	 * @see com.mohan.springrestcrud.dao.DataDao#getEntityList()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEntityList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Employee> employeeList = session.createCriteria(Employee.class)
				.list();
		tx.commit();
		session.close();
		return employeeList;
	}
	
	/*
	 * Delete a record from the Employee table
	 * @see com.mohan.springrestcrud.dao.DataDao#deleteEntity(long)
	 */
	@Override
	public boolean deleteEntity(long id)
			throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(Employee.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}

}
