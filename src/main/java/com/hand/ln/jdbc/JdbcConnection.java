package com.hand.ln.jdbc;

import java.util.List;

import com.hand.ln.jdbc.template.JdbcTemplate;
import com.hand.ln.jdbc.template.PrimaryJdbcTemplate;
import com.hand.ln.mybatis.model.Employee;

public class JdbcConnection {
    public static void main(String[] args) {
        final int employee_id = 100;
        JdbcTemplate template = new PrimaryJdbcTemplate();
        List<Employee> list = template.selectList(
                "select employee_id, first_name, last_name, salary from employees where employee_id = ?", (stat) -> {
                    stat.setInt(1, employee_id);
                }, (rs) -> {
                    Employee employee = new Employee();
                    employee.setEmployeeId(rs.getInt("employee_id"));
                    employee.setFirstName(rs.getString("first_name"));
                    employee.setLastName(rs.getString("last_name"));
                    employee.setSalary(rs.getInt("salary"));
                    return employee;
                });
        System.out.println(list);
    }
}
