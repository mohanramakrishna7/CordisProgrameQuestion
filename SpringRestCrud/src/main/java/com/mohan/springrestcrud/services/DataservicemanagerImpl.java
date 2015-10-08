package com.mohan.springrestcrud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mohan.springrestcrud.dao.DataDaomanager;
import com.mohan.springrestcrud.model.Manager;;


public class DataservicemanagerImpl  implements DataServicesmanager {
	
	@Autowired
	DataDaomanager datamgrDao;

	@Override
	public List<Manager> addEntity(Manager manager) throws Exception {
		return datamgrDao.addEntity(manager);
	}

	@Override
	public Manager getEntityById(long id) throws Exception {
		return datamgrDao.getEntityById(id);
	}

	@Override
	public List<Manager> getEntityList() throws Exception {
		return datamgrDao.getEntityList();
	}

	@Override
	public boolean deleteEntity(long id) throws Exception {
		return datamgrDao.deleteEntity(id);
	}

	

}
