package com.cg.bargat.ems.employeeManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bargat.ems.employeeManagementSystem.model.Address;
import com.cg.bargat.ems.employeeManagementSystem.model.Employee;
import com.cg.bargat.ems.employeeManagementSystem.repository.DAO;
import com.cg.bargat.ems.employeeManagementSystem.service.EmpService;


@RestController
public class Controller {
	
	@Autowired
	public EmpService service;
	@Autowired
	private DAO dAO;
	
	@RequestMapping(value="/employees", method=RequestMethod.POST)
	public Employee createEmployee(@RequestBody Employee emp) 
	{
		return service.createEmployee(emp);
	} 
	
	@RequestMapping(value="/employees", method=RequestMethod.GET)
	public List<Employee> readEmployees() 
	{
		return service.getEmployees();
		
	}
	
	@RequestMapping(value="/employees/{empId}", method=RequestMethod.PUT)
	public Employee readEmployees(@PathVariable(value = "empId") int id, @RequestBody Employee empDetails)
	{
		return service.updateEmployee(id, empDetails);
		
	}
	
	@RequestMapping(value="/employees/{empId}", method=RequestMethod.DELETE)
	public void deleteEmployees(@PathVariable(value = "empId") int id) 
	{
		service.deleteEmployee(id);
		
	}
	@RequestMapping(value="/address", method=RequestMethod.GET)
	public List<Employee> getAddresses()
	{
		return service.getAddress();
		
	}
	
	@RequestMapping(value="/address/{addressId}",method=RequestMethod.PUT)
	public Address readEmployee(@PathVariable(value = "addressId")int id, @RequestBody Address addressDetails) {
		return service.updateAddress(id, addressDetails);
	}
	

}
