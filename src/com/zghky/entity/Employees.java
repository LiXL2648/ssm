package com.zghky.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

// @Alias(value = "emp") 可以使用@Alias注解为java类型起别名
public class Employees implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer empId;
	private String firstName;
	private String empName;
	private String email;
	private String phoneNumber;
	private Integer gender;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	private String jobId;
	private Double salary;
	private Double commissionPct;
	private Integer managerId;
	private Integer depId;

	private Departments dep;
	private String birthdayStr;

	public Employees() {
	}

	public Employees(String firstName, String empName, String email,
			String phoneNumber, Integer gender, Date birthday, String jobId,
			Double salary, Double commissionPct, Integer managerId,
			Integer depId) {
		this.firstName = firstName;
		this.empName = empName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.birthday = birthday;
		this.jobId = jobId;
		this.salary = salary;
		this.commissionPct = commissionPct;
		this.managerId = managerId;
		this.depId = depId;
	}

	public Integer getEmpId() {
		return empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getEmpName() {
		return empName;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public Integer getGender() {
		return gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public String getJobId() {
		return jobId;
	}

	public Double getSalary() {
		return salary;
	}

	public Double getCommissionPct() {
		return commissionPct;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public Integer getDepId() {
		return depId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public void setCommissionPct(Double commissionPct) {
		this.commissionPct = commissionPct;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public void setDepId(Integer depId) {
		this.depId = depId;
	}

	public Departments getDep() {
		return dep;
	}

	public void setDep(Departments dep) {
		this.dep = dep;
	}

	public String getBirthdayStr() {
		return birthdayStr;
	}

	public void setBirthdayStr(String birthdayStr) {
		this.birthdayStr = birthdayStr;
	}
}
