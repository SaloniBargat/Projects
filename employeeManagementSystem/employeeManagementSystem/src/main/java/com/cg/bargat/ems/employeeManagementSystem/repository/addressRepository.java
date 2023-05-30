package com.cg.bargat.ems.employeeManagementSystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.bargat.ems.employeeManagementSystem.model.Address;
import com.cg.bargat.ems.employeeManagementSystem.model.Employee;

public interface addressRepository extends MongoRepository<Address, Integer>{

}
