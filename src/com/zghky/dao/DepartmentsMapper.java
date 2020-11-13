package com.zghky.dao;

import java.util.List;

import com.zghky.entity.Departments;

public interface DepartmentsMapper {

	public List<Departments> getDeps();
	
	public Departments getDepByDepId(Integer depId);
}
