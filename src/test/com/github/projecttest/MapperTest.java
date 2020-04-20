package com.github.projecttest;

import com.github.beans.Dept;
import com.github.beans.Employee;
import com.github.dao.DeptMapper;
import com.github.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;
import java.util.UUID;

/**
 * @author qianhao
 * @create 2020/4/18-11:37
 *
 * Spring测试jar的使用
 * 1:  引入对应的spring-test jar
 * 2:  @ContextConfiguration注解标记测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {

    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private SqlSession sqlSession;

    private static final String[] NAME_PREFIX = {"赵","钱","孙","李","周","吴","郑","王"};
    private static final String[] NAME_SUFFIX = {"一","二","三","四","五","六","七","八","九"};

    @Test
   public void testUUID(){
       System.out.println(UUID.randomUUID().toString());
   }

    @Test
    public void testCRUD(){
        //1:创建spring容器
        // ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        /*Dept dept = new Dept();
        dept.setDeptName("测试二班");
        insertIntoDept(dept);*/
        Employee employee = null;
        Random random1 = new Random();
        int surname_index = 0;
        int name_index1 = 0;
        int name_index2 = 0;
        String name = "";
        for (int i=0; i<=21000; i++){
            employee = new Employee();
            surname_index = random1.nextInt(8);
            name_index1 = random1.nextInt(9);
            name_index2 = random1.nextInt(9);
            name = NAME_PREFIX[surname_index] + NAME_SUFFIX[name_index1] + NAME_SUFFIX[name_index2];
            employee.setEmoName(name);
            employee.setEmpGender(random1.nextInt(2) + "");
            employee.setDeptId(random1.nextInt(10) + 1);
            employee.setEmpEmail(UUID.randomUUID().toString().substring(0,8) + i + "@qq.com");
            insertEmployee(employee);
        }
    }

    private void insertIntoDept(Dept dept){
        deptMapper.insertSelective(dept);
    }

    private void insertEmployee(Employee employee){
        employeeMapper.insertSelective(employee);
    }

    private void insertEmployeeBatch(Employee employee){
        EmployeeMapper emp = sqlSession.getMapper(EmployeeMapper.class);
        employeeMapper.insertSelective(employee);
    }
}
