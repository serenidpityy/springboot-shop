package com.wfit.springbootshop.service.impl;

import com.wfit.springbootshop.mapper.StudentMapper;
import com.wfit.springbootshop.entity.Student;
import com.wfit.springbootshop.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;


    @Override
    public void addStudent(Student student) {
        studentMapper.saveStudent(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentMapper.updateStudent(student);
    }

    @Override
    public void delStudent(String id) {
        studentMapper.delStudent(id);
    }

    @Override
    public List<Student> queryStudent() {
        return studentMapper.queryStudent();
    }
}
