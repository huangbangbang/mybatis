package com.bj;

import com.bj.dao.StudentDao;
import com.bj.domain.Student;
import com.bj.utils.MybatisUtils;
import com.bj.vo.QueryParam;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MybatisTest {

    @Test
    public void  testSelectStudentById() throws IOException {

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        //System.out.println(dao.getClass().getName());
        Student student = dao.selectStudentById(119);

        System.out.println(student);
    }
    @Test
    public void  testselectMultiParam() throws IOException {

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        //System.out.println(dao.getClass().getName());
        List<Student> studentList= dao.selectMultiParam("张三",30);

        studentList.forEach(stu-> System.out.println(stu));
        sqlSession.close();
    }

    @Test
    public void  testselectMultiObject() throws IOException {

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        //System.out.println(dao.getClass().getName());
        QueryParam queryParam = new QueryParam("张三",30);
        List<Student> studentList= dao.selectMultiObject(queryParam);

        studentList.forEach(stu-> System.out.println(stu));
        sqlSession.close();
    }
    @Test
    public void  testselectMultiStudent() throws IOException {

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        //System.out.println(dao.getClass().getName());
        Student student = new Student();
        student.setName("张三");
        student.setAge(30);
        List<Student> studentList= dao.selectMultiStudent(student);

        studentList.forEach(stu-> System.out.println(stu));
        sqlSession.close();
    }
    @Test
    public void  testselectMultiPosition() throws IOException {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> studentList= dao.selectMultiPosition("张三",30);

        studentList.forEach(stu-> System.out.println(stu));
        sqlSession.close();
    }
    @Test
    public void  testselectMultiByMap() throws IOException {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Map<String,Object> data = new HashMap<>();
        data.put("name","张三");
        data.put("age",30);
        List<Student> studentList= dao.selectMultiByMap(data);

        studentList.forEach(stu-> System.out.println(stu));
        sqlSession.close();
    }

    @Test
    public void  testselectUser$() throws IOException {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> studentList= dao.selectUser$("'李四'");

        studentList.forEach(stu-> System.out.println(stu));
        sqlSession.close();
    }

    @Test
    public void  testselectUser$Order() throws IOException {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> studentList= dao.selectUser$Order("age");

        studentList.forEach(stu-> System.out.println(stu));
        sqlSession.close();
    }

}
