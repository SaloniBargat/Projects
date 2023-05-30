//package com.cg.bargat.ems.employeeManagementSystem.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.cg.bargat.ems.employeeManagementSystem.model.Address;
//import com.cg.bargat.ems.employeeManagementSystem.model.Employee;
//import com.cg.bargat.ems.employeeManagementSystem.repository.DAO;
//
//public class AddressService {
//	
//	@Autowired
//	DAO dao;
//	
//	// CREATE 
//	public Employee createAddress(Address address) {
//		return dao.save(address);
//		
//	}
//	
//	// READ
//	public List<Address> getAddress() {
//		
//		return dao.findAll();
//		}
//	
//	 //DELETE
//	public void deleteAddress(int addressId) {
//		dao.deleteById(addressId);
//		}
//	
//	// UPDATE
//	public Address updateAddress(int empId, Employee employeeDetails) {
//		Employee emp = dao.findById(empId).get();
//		emp.setId(employeeDetails.getId());
//		emp.setName(employeeDetails.getName());
//		emp.setDepartment(employeeDetails.getDepartment());
//		emp.setDesignation(employeeDetails.getDesignation());
//		return dao.save(emp);
//		}
//
//
//}
