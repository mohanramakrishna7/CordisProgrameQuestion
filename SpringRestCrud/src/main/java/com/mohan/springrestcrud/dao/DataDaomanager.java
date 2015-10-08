package com.mohan.springrestcrud.dao;

import java.util.List;


import com.mohan.springrestcrud.model.Manager;

/*
 * DAO interface of the Manager Table
 */
public interface DataDaomanager {
	
	public List<Manager> addEntity(Manager manager) throws Exception;
	public Manager getEntityById(long id) throws Exception;
	public List<Manager> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;

}
