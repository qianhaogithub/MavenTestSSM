package com.github.service;

import com.github.beans.Employee;
import com.github.beans.EmployeeExample;
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

    public Long countEmployeeByName(String name) {
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andEmoNameEqualTo(name);

        return employeeMapper.countByExample(example);
    }

    public Employee getEmpByID(Integer empId) {
        Employee employee = employeeMapper.selectByPrimaryKey(empId);
        return employee;
    }
}
