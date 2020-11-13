package com.zghky.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zghky.entity.Employees;

@Repository
public interface EmployeesMapper {

	public Employees getEmpById(Integer empId);
	
	public List<Employees> getEmps();
	
	public Integer updateEmp(Employees emp);
}
