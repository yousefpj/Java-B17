package com.yousef.dao;

import java.util.List;

import com.yousef.model.Employee;

public interface EmployeeDAO 
{
	public List<Employee> listEmployees();
	public int addEmployee(Employee emp);
	public int editEmployee (Employee emp);
	public int deleteEmployee (int id);
	public Employee getEmployee(int id);
}
