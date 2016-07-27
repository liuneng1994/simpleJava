package com.hand.ln.mybatis.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hand.ln.mybatis.model.Employee;

@Repository("employeeDao")
public interface EmployeeDao {
    public List<Employee> get();
}
