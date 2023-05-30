package com.cg.bargat.ems.employeeManagementSystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.bargat.ems.employeeManagementSystem.model.Employee;

@Repository
public interface DAO extends MongoRepository<Employee, Integer>
{

}
