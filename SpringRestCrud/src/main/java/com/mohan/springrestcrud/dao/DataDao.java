package com.mohan.springrestcrud.dao;

import java.util.List;

import com.mohan.springrestcrud.model.Employee;

/*
 * DAO interface of the Employee Table
 */
public interface DataDao {

	public List<Employee> addEntity(Employee employee) throws Exception;
	public Employee getEntityById(long id) throws Exception;
	public List<Employee> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
}
