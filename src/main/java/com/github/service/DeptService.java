package com.github.service;

import com.github.beans.Dept;
import com.github.dao.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qianhao
 * @create 2020/4/19-14:37
 */
@Service
public class DeptService {
    @Autowired
    private DeptMapper deptMapper;

    public List<Dept> getAllDept(){
        List<Dept> list = deptMapper.selectByExample(null);
        return list;
    }
}
