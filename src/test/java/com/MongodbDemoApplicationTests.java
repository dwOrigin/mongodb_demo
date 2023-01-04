package com;

import com.entity.Student;
import com.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@SpringBootTest
class MongodbDemoApplicationTests {
    @Resource
    private StudentMapper studentMapper;

    @Test
    void addOneStudent(){
//        插入10行
        for (Integer count = 0; count < 10; count++) {
            Student student = new Student()
                    .setStudentId("student_"+count) //如果自己不去设置id则系统会分配给一个id
                    .setStudentName("Godfery"+count)
                    .setStudentAge(count)
                    .setStudentScore(98.5-count)
                    .setStudentBirthday(new Date());
            studentMapper.save(student);
        }
    }

    @Test
    void deleteOneStudentByStudentId(){
//        删除id为student_0的学生
        studentMapper.deleteById("student_0");
    }

    @Test
    void updateOneStudent(){
//        修改姓名为Godfery1的Student年龄为22
        Student student = studentMapper.getAllByStudentName("Godfery1");
        student.setStudentAge(22);
        studentMapper.save(student);

    }

    @Test
    void getOneStudentByStudentId(){
        System.out.println(studentMapper.findById("student_1"));
    }

    @Test
    void getAllStudent(){
        List<Student> studentList = studentMapper.findAll();
        studentList.forEach(System.out::println);
    }

}
