package com.yousef.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;

import com.yousef.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public List<Employee> listEmployees() {
		String sql = "select * from employee";
		
		return template.query(sql, new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee employee = new Employee();
				employee.setId(rs.getInt(1));
				employee.setName(rs.getString(2));
				employee.setDesignation(rs.getString(3));
				employee.setSalary(rs.getFloat(4));
				return employee;
			}
			
		});
	}

	@Override
	public int addEmployee(Employee emp) {
		String sql = "insert into employee (name,designation,salary) values (?,?,?)";
		
		return template.execute(sql, new PreparedStatementCallback<Integer>() {

			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, emp.getName());
				ps.setString(2, emp.getDesignation());
				ps.setFloat(3, emp.getSalary());
				return ps.executeUpdate();
			}
		});
	}

	@Override
	public int editEmployee(Employee emp) {
		
		String sql = "update employee set name = ?, designation = ?, salary = ? where id = ?";
		return template.execute(sql, new PreparedStatementCallback<Integer>() {

			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, emp.getName());
				ps.setString(2, emp.getDesignation());
				ps.setFloat(3, emp.getSalary());
				ps.setInt(4, emp.getId());
				return ps.executeUpdate();
			}
		});
	}

	@Override
	public int deleteEmployee(int id) {
		String sql = "delete from employee where id = ?" ;
		return template.update(sql, new Object[] {id} );	
	}

	@Override
	public Employee getEmployee(int id) {
		String sql = "select * from employee where id=?";
		return template.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<Employee>(Employee.class));
	}

}
