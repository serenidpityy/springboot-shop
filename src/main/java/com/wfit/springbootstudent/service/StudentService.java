package com.wfit.springbootstudent.service;

import com.wfit.springbootstudent.pojo.Student;

import java.util.List;

public interface StudentService {
    public void addStudent(Student student);
    public void updateStudent(Student student);
    public void delStudent(String id);
    public List<Student> queryStudent();

}
