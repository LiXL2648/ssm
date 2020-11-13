package com.zghky.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.zghky.entity.Departments;
import com.zghky.entity.Employees;
import com.zghky.service.DepartmentsService;
import com.zghky.service.EmployeesService;

@RequestMapping("/emp")
@Controller
public class EmployeesController {

	@Autowired
	private EmployeesService employeesService;

	@Autowired
	private DepartmentsService departmentsService;

	@ModelAttribute
	public void getEmployee(@RequestParam(value="empId", required=false) Integer empId, 
			Map<String, Object> map) {
		if (empId != null) {
			Employees employee = employeesService.getEmpById(empId);
			System.out.println("ModelAttribute" + ReflectionToStringBuilder.toString(employee,
					ToStringStyle.MULTI_LINE_STYLE));
			map.put("employee", employee);
		}
	}
	
	@RequestMapping("/getEmps")
	public String getEmps(@RequestParam(value="pageNo", required=false, defaultValue="1") 
		String pageNoStr, Map<String, Object> map) {
		PageInfo<Employees> info = employeesService.getEmps(pageNoStr);
		map.put("info", info);
		return "emps";
	}

	@RequestMapping("/getEmpById/{empId}")
	public String getEmpById(@PathVariable("empId") Integer empId,
			Map<String, Object> map) {
		List<Departments> departments = departmentsService.getDeps();
		map.put("departments", departments);
		Employees employee = employeesService.getEmpById(empId);
		map.put("employee", employee);
		return "emp";
	}
	
	@RequestMapping(value = "/updateEmp", method = RequestMethod.PUT)
	public String updateEmp(@ModelAttribute("employee") Employees employee) {
		System.out.println(ReflectionToStringBuilder.toString(employee,
				ToStringStyle.MULTI_LINE_STYLE));
		employeesService.updateEmp(employee);
		return "redirect:/emp/getEmps";
	}

}
