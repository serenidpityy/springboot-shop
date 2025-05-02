package com.wfit.springbootshop.service;

import com.wfit.springbootshop.entity.Student;

import java.util.List;

public interface StudentService {
    public void addStudent(Student student);
    public void updateStudent(Student student);
    public void delStudent(String id);
    public List<Student> queryStudent();

}
