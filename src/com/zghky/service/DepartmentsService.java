package com.zghky.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zghky.dao.DepartmentsMapper;
import com.zghky.entity.Departments;

@Service
public class DepartmentsService {

	@Autowired
	private DepartmentsMapper departmentsMapper;
	
	public List<Departments> getDeps() {
		return departmentsMapper.getDeps();
	}
}
