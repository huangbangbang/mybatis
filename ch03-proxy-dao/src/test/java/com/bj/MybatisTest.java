package com.bj;

import com.bj.dao.StudentDao;

import com.bj.domain.Student;
import com.bj.utils.MybatisUtils;
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

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        //System.out.println(dao.getClass().getName());
        List<Student> studentList = dao.selectStudents();

        studentList.forEach(stu-> System.out.println(stu));
    }
    @Test
    public void   testInsertStudent() throws IOException {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Student student = new Student(119,"会话","hh@163.com",30);
        int nums = dao.insertStudent(student);

        sqlSession.commit();
        System.out.println(nums);
    }
}
