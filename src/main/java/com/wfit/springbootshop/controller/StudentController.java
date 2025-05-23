package com.wfit.springbootshop.controller;

import com.wfit.springbootshop.entity.Student;
import com.wfit.springbootshop.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController//@Controller 和 @ResponseBody
@RequestMapping("/student") // 添加类级别路径
public class StudentController {
    @Autowired
    StudentService studentService;

    /**
     * 新增学生信息
     * @param student
     * @return
     */
    @GetMapping("/add")
    public Object addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        Map map = new HashMap();
        map.put("code","200");
        map.put("msg","success");
        map.put("data",student);
        return map;
    }

    /**
     * 修改学生信息
     * @param student
     * @return
     */
    @PostMapping("/update")
    public Object updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
        Map map = new HashMap();
        map.put("code","200");
        map.put("msg","success");
        map.put("data",student);
        return map;
    }

    /**
     * 删除学生信息
     * @param id
     * @return
     */
    @GetMapping("/del")
    public Object delStudent(String id){
        studentService.delStudent(id);
        Map map = new HashMap();
        map.put("code","200");
        map.put("msg","success");
        map.put("data","删除学生id为:" + id);
        return map;
    }

    @GetMapping("/query")
    public Object queryStudent(){
        List<Student> list = studentService.queryStudent();
        Map map = new HashMap();
        map.put("code","200");
        map.put("msg","success");
        map.put("data",list);
        return map;
    }




}
