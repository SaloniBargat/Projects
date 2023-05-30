package com.cg.bargat.ems.employeeManagementSystem;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.bargat.ems.employeeManagementSystem.model.Address;
import com.cg.bargat.ems.employeeManagementSystem.model.Employee;
import com.cg.bargat.ems.employeeManagementSystem.repository.DAO;
import com.cg.bargat.ems.employeeManagementSystem.service.EmpService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeManagementSystemApplicationTest {
	@Autowired
	private EmpService service;
	
	@MockBean
	private DAO dao;
	
	@Test
	public void getEmployeesTest()
	{
		when(dao.findAll()).thenReturn(Stream.of(new Employee(10,"Ashish","Sales","Manager",new Address(1,"Silver Valley","9","Airoli",400708))).collect(Collectors.toList()));
		assertEquals(1,service.getEmployees().size());
	}
	
}
