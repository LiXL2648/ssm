package com.zghky.entity;

import java.io.Serializable;
import java.util.List;

public class Departments implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer depId;
	private String depName;
	private String city;
	private List<Employees> emps;

	public Departments() {
		super();
	}

	public Departments(String depName, String city) {
		super();
		this.depName = depName;
		this.city = city;
	}

	public Departments(Integer depId, String depName, String city) {
		super();
		this.depId = depId;
		this.depName = depName;
		this.city = city;
	}

	public Integer getDepId() {
		return depId;
	}

	public String getDepName() {
		return depName;
	}

	public String getCity() {
		return city;
	}

	public List<Employees> getEmps() {
		return emps;
	}

	public void setDepId(Integer depId) {
		this.depId = depId;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setEmps(List<Employees> emps) {
		this.emps = emps;
	}

}
