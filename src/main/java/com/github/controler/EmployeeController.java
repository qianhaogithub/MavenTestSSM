package com.github.controler;

import com.github.beans.Employee;
import com.github.beans.Msg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author qianhao
 * @create 2020/4/18-15:53
 */
@Controller
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/getEmp")
    public String getEmps(@RequestParam(value="pageNo",defaultValue = "1")Integer pageNo,
                          @RequestParam(value="pageSize",defaultValue = "20")Integer pageSize,
                          Model model){
        PageHelper.startPage(pageNo,pageSize);
        List<Employee> emps = employeeService.getAllEmployee();
        PageInfo<Employee> page = new PageInfo<Employee>(emps,10);//第二位参数标记连续显示的页数
        model.addAttribute("pageInfo",page);
        return "editEM";
    }

    @ResponseBody
    @RequestMapping("/listEmpByJson")
    public Msg getEmployeeByJson(@RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo,
                                 @RequestParam(value = "pageSize",defaultValue = "20") Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<Employee> emps = employeeService.getAllEmployee();
        PageInfo<Employee> page = new PageInfo<Employee>(emps,10);//第二位参数标记连续显示的页数
        return Msg.success().addExtend("pageInfo",page);
    }

    @ResponseBody
    @RequestMapping(value="/saveEmp",method = RequestMethod.POST)
    public Msg saveEmp(Employee employee){
        employeeService.insertEmployee(employee);
        return Msg.success();
    }
}
