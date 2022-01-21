package com.boot.controller;

import com.boot.entity.Student;
import com.boot.mapper.StudentMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {
    @Resource
    private StudentMapper studentMapper;


    @GetMapping("get")
    public void test(){
        List<Student> studentList = studentMapper.selectList(null);
        studentList.forEach(student -> System.out.println(student.toString()));
    }


}
