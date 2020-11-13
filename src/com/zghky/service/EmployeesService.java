package com.zghky.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zghky.dao.EmployeesMapper;
import com.zghky.entity.Employees;
import com.zghky.utils.DateTimeUtil;

@Service
public class EmployeesService {

	@Autowired
	private EmployeesMapper employeesMapper;
	
	public Employees getEmpById(Integer empId) {
		return employeesMapper.getEmpById(empId);
	}
	
	public PageInfo<Employees> getEmps(String pageNumStr) {
		int pageNo = 1;
		try {
			pageNo = Integer.parseInt(pageNumStr);
			if (pageNo < 1) {
				pageNo = 1;
			}
		} catch (Exception e) {}
		PageHelper.startPage(pageNo, 10);
		List<Employees> emps = employeesMapper.getEmps();
		for (Employees emp : emps) {
			Date date = emp.getBirthday();
			emp.setBirthdayStr(DateTimeUtil.getDateStr(date));
		}
		PageInfo<Employees> info = new PageInfo<>(emps);
		return info;
	}
	
	@Transactional
	public Integer updateEmp(Employees emp){
		int row = 0;
		try {
			row = employeesMapper.updateEmp(emp);
			row = row / 0;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("出错了！");
		}
		return row;
	}
}
