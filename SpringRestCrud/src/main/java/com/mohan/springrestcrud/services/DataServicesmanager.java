package com.mohan.springrestcrud.services;

import java.util.List;

import com.mohan.springrestcrud.model.Manager;

public interface DataServicesmanager {
	
	public  List<Manager>  addEntity(Manager manager) throws Exception;
	public Manager getEntityById(long id) throws Exception;
	public List<Manager> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;

}
