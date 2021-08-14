package com.bean.manytomany;

import java.util.Set;

public class EmployeeBean {
	int employeeId;
	String name;
	int salary;

	Set<ProjectBean> projects;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Set<ProjectBean> getProjects() {
		return projects;
	}

	public void setProjects(Set<ProjectBean> projects) {
		this.projects = projects;
	}

}
