package com.cg.bargat.ems.employeeManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bargat.ems.employeeManagementSystem.model.Address;
import com.cg.bargat.ems.employeeManagementSystem.model.Employee;
import com.cg.bargat.ems.employeeManagementSystem.repository.DAO;
import com.cg.bargat.ems.employeeManagementSystem.repository.addressRepository;

@Service
public class EmpService {

	@Autowired
	DAO dao;
	
	// CREATE 
	public Employee createEmployee(Employee emp) {
		return dao.save(emp);
		
	}
	
	// READ
	public List<Employee> getEmployees() {
		
		return dao.findAll();
		}
	
	 //DELETE
	public void deleteEmployee(int empId) {
		dao.deleteById(empId);
		}
	
	// UPDATE
	public Employee updateEmployee(int empId, Employee employeeDetails) {
		Employee emp = dao.findById(empId).get();
		emp.setId(employeeDetails.getId());
		emp.setName(employeeDetails.getName());
		emp.setDepartment(employeeDetails.getDepartment());
		emp.setDesignation(employeeDetails.getDesignation());
		emp.setAddress(employeeDetails.getAddress());
		return dao.save(emp);
		}

	public List<Employee> getAddress(){
		return dao.findAll();
	}
	
	public Address updateAddress(int addressId, Address addressDetails) {
		Address address = addressRepository.findById(addressId).get();
		address.setId(addressDetails.getId());
		address.setApartmentName(addressDetails.getApartmentName());
		address.setFloor(addressDetails.getFloor());
		address.setStreet(addressDetails.getStreet());
		address.setCity(addressDetails.getCity());
		address.setPin(addressDetails.getPin());
		
		return addressRepository.save(address);
	
		
	}
}
