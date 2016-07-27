package com.hand.ln.spring.context;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hand.ln.mybatis.dao.EmployeeDao;
import com.hand.ln.mybatis.model.Employee;

public class ApplicationContextInit {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:ioc.xml");
        EmployeeDao employeeDao = (EmployeeDao) context.getBean("employeeDao");
        List<Employee> list = employeeDao.get();
        System.out.println(list);
    }

}
