package com.wfit.springbootstudent.mapper;

import com.wfit.springbootstudent.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper //用在接口类上,在编译之后会生成相应的接口实现类，由MyBatis创建，交由Spring框架管理
public interface StudentMapper {
    public void saveStudent(Student student);
    public void updateStudent(Student student);
    public void delStudent(String id);
    public List<Student> queryStudent();
}
