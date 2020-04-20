package com.github.controler;

import com.github.beans.Dept;
import com.github.beans.Msg;
import com.github.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author qianhao
 * @create 2020/4/19-15:05
 */
@Controller
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @RequestMapping("/getAllDept")
    @ResponseBody
    public Msg getAllDept(){
        List<Dept> list = deptService.getAllDept();
        return Msg.success().addExtend("depts",list);
    }
}
