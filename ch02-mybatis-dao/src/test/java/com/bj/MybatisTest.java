package com.bj;

import com.bj.dao.StudentDao;
import com.bj.dao.impl.StudentDaoImpl;
import com.bj.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class MybatisTest {

    @Test
    public void  test() throws IOException {

        StudentDao dao = new StudentDaoImpl();

        List<Student> studentList = dao.selectStudents();

        studentList.forEach(stu-> System.out.println(stu));
        }
    @Test
    public void   testInsertStudent() throws IOException {

        StudentDao dao = new StudentDaoImpl();

        Student student = new Student(1009,"火狐","hh@163.com",30);
        int nums = dao.insertStudent(student);

        System.out.println(nums);
    }
}
