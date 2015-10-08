package com.mohan.springrestcrud.services;

import java.util.List;

import com.mohan.springrestcrud.model.Employee;

public interface DataServices {
	
	public  List<Employee>  addEntity(Employee employee) throws Exception;
	public Employee getEntityById(long id) throws Exception;
	public List<Employee> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
}
