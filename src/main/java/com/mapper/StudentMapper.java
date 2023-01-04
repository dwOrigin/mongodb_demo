package com.mapper;

import com.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentMapper extends MongoRepository<Student, String> {
    //    可根据需求自己定义方法, 无需对方法进行实现
    Student getAllByStudentName(String studentName);
}



