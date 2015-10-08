package com.mohan.springrestcrud.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mohan.springrestcrud.model.Employee;
import com.mohan.springrestcrud.model.Employeewrapper;
import com.mohan.springrestcrud.model.Manager;
import com.mohan.springrestcrud.model.ManagerWrapper;
import com.mohan.springrestcrud.model.Status;
import com.mohan.springrestcrud.services.DataServices;
import com.mohan.springrestcrud.services.DataServicesmanager;

@Controller
@RequestMapping("/insert-row/manager")
public class RestControllerManager {

	@Autowired
	DataServicesmanager datamgrServices;

	static final Logger logger = Logger.getLogger(RestControllerManager.class);
	
	@RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	List<Manager> addManager(@RequestBody ManagerWrapper manager) {
		
		List<Manager> managerList = new ArrayList<Manager>();
		
		for (Manager mgr :manager.getColumnList())
		{
				try {
						datamgrServices.addEntity(mgr);
				    } catch (Exception e) {
				    	e.printStackTrace();
				}
		}
		try {
			managerList = datamgrServices.getEntityList();
			} catch (Exception e) {
						// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return managerList;
	  }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Manager getManager(@PathVariable("id") long id) {
		Manager manager = null;
		try {
			manager = datamgrServices.getEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return manager;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<Manager> getManager() {

		List<Manager> managerList = null;
		try {
			managerList = datamgrServices.getEntityList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return managerList;
	}
	
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status deleteManager(@PathVariable("id") long id) {

		try {
			datamgrServices.deleteEntity(id);
			return new Status(1, "Manager deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
}
