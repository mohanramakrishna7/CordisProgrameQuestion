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
import com.mohan.springrestcrud.model.Status;
import com.mohan.springrestcrud.services.DataServices;

@Controller
@RequestMapping("/insert-row/employee")
public class RestController {

	@Autowired
	DataServices dataServices;

	static final Logger logger = Logger.getLogger(RestController.class);

	/*
	 * Method to insert a row into the Employee Table : POST Method
	 */
	@RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	List<Employee> addEmployee(@RequestBody Employeewrapper employee) {
		
		List<Employee> employeeList = new ArrayList<Employee>();
		
		for (Employee emp :employee.getColumnList())
		{
				try {
						dataServices.addEntity(emp);
				    } catch (Exception e) {
				    	e.printStackTrace();
				}
		}
		try {
				employeeList = dataServices.getEntityList();
			} catch (Exception e) {
						// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return employeeList;
	}

	/*
	 * Retrieve the Employee record from the table : GET Method
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Employee getEmployee(@PathVariable("id") long id) {
		Employee employee = null;
		try {
			employee = dataServices.getEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}

	/*
	 * Retrieve entire Employee Records : GET Method
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<Employee> getEmployee() {

		List<Employee> employeeList = null;
		try {
			employeeList = dataServices.getEntityList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return employeeList;
	}

	/*
	 * Delete a Employee Record : DELETE Method
	 */
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status deleteEmployee(@PathVariable("id") long id) {

		try {
			dataServices.deleteEntity(id);
			return new Status(1, "Employee deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
}
