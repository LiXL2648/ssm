package com.zghky.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zghky.controller.EmployeesController;
import com.zghky.dao.DepartmentsMapper;
import com.zghky.dao.EmployeesMapper;
import com.zghky.entity.Departments;
import com.zghky.entity.Employees;
import com.zghky.utils.DateTimeUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml",
		"classpath:applicationContext-mvc.xml" })
public class TestConnection {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private EmployeesController employeesController;

	@Autowired
	private EmployeesMapper employeesMapper;
	
	@Autowired
	private EmployeesMapper employeesMapper1;

	@Autowired
	private DepartmentsMapper departmentsMapper;
	
	@Autowired
	private DepartmentsMapper departmentsMapper1;

	@Test
	public void testCache() {
		Employees emp = employeesMapper.getEmpById(20001);
		System.out.println(ReflectionToStringBuilder.toString(emp,
				ToStringStyle.MULTI_LINE_STYLE));
		emp = employeesMapper1.getEmpById(20001);
		System.out.println(ReflectionToStringBuilder.toString(emp,
				ToStringStyle.MULTI_LINE_STYLE));
	}

	@Test
	public void testGetDepByDepId() {
		Departments dep = departmentsMapper.getDepByDepId(10001);
		System.out.println(ReflectionToStringBuilder.toString(dep,
				ToStringStyle.MULTI_LINE_STYLE));
		
		dep = departmentsMapper1.getDepByDepId(10001);
	}

	@Test
	public void testGetDeps() {
		List<Departments> deps = departmentsMapper.getDeps();
		for (Departments dep : deps) {
			System.out.println(ReflectionToStringBuilder.toString(dep,
					ToStringStyle.MULTI_LINE_STYLE));
		}
	}

	@Test
	public void testUpdateEmp() {
		Employees emp = new Employees();
		emp.setEmpId(20001);
		emp.setEmpName("LiXL");
		emp.setEmail("LiXL@qq.com");
		emp.setGender(1);
		emp.setBirthday(DateTimeUtil.getDateFromStr("1996-05-04"));
		int row = employeesMapper.updateEmp(emp);
		System.out.println(row);
	}

	@Test
	public void testGetEmps() {
		List<Employees> emps = employeesMapper.getEmps();
		for (Employees emp : emps) {
			System.out.println("<---------------------------------");
			System.out.println(emp.getEmpName());
			// System.out.println(ReflectionToStringBuilder.toString(emp,
			// ToStringStyle.MULTI_LINE_STYLE));

			// System.out.println(ReflectionToStringBuilder.toString(emp.getDep(),
			// ToStringStyle.MULTI_LINE_STYLE));
			//
			// System.out.println("--------------------------------->");
		}
		emps = employeesMapper.getEmps();
	}

	@Test
	public void testConnection() throws SQLException {
		Connection connection = dataSource.getConnection();
		System.out.println(connection);
	}
}
