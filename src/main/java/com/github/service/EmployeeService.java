package com.github.service;

import com.github.beans.Employee;
import com.github.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qianhao
 * @create 2020/4/18-16:00
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 查询所有员工
     * @return
     */
    public List<Employee> getAllEmployee(){
        List<Employee> employees = employeeMapper.selectByExampleWithDept(null);

        return  employees;
    }

    public void insertEmployee(Employee employee) {
        employeeMapper.insertSelective(employee);
    }
}
