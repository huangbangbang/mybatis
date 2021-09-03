package com.bj;

import com.bj.dao.StudentDao;
import com.bj.domain.Student;
import com.bj.utils.MybatisUtils;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MybatisTest {

    @Test
    public void  testSelectStudentById() throws IOException {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("张三");
        student.setAge(17);
        List<Student> studentList = dao.selectStudentIf(student);
        studentList.forEach(s-> System.out.println(s));
        sqlSession.close();
}
    @Test
    public void  testselectStudentWhere() throws IOException {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("张三");
        student.setAge(17);
        List<Student> studentList = dao.selectStudentWhere(student);
        studentList.forEach(s-> System.out.println(s));
        sqlSession.close();
    }
    @Test
    public void  testselectForeachOne() throws IOException {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        List<Integer> idlist = new ArrayList<>();
        idlist.add(101);
        idlist.add(102);
        idlist.add(109);
        List<Student> studentList = dao.selectForeachOne(idlist);
        studentList.forEach(s-> System.out.println(s));
        sqlSession.close();
    }
    @Test
    public void  testselectForeachTwo() throws IOException {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student s1 = new Student();
        s1.setId(101);
        Student s2 = new Student();
        s2.setId(102);
        List<Student> studentList1= new ArrayList<>();
        studentList1.add(s1);
        studentList1.add(s2);
        List<Student> studentList = dao.selectForeachTwo(studentList1);
        studentList.forEach(s-> System.out.println(s));
        sqlSession.close();
    }

    @Test
    public void  testselectStudentAll() throws IOException {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        PageHelper.startPage(1,3);
        List<Student> studentList = dao.selectStudentAll();
        studentList.forEach(s-> System.out.println(s));
        sqlSession.close();
    }
}
