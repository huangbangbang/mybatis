package com.bj;

import com.bj.dao.StudentDao;
import com.bj.domain.Student;
import com.bj.utils.MybatisUtils;
import com.bj.domain.MyStudent;
import com.bj.vo.ViewStudent;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.io.IOException;
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
        sqlSession.close();
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
    public void  testselectViewStudentById() throws IOException {

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        //System.out.println(dao.getClass().getName());
        ViewStudent student = dao.selectViewStudentById(119);

        System.out.println(student);
        sqlSession.close();
    }
    @Test
    public void  testcountStudent() throws IOException {

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        int num = dao.countStudent();

        System.out.println(num);
        sqlSession.close();
    }
    @Test
    public void  testselectMapById() throws IOException {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Map<Object,Object> map = dao.selectMapById(119);

        System.out.println(map);
        sqlSession.close();
    }
    @Test
    public void  testselectAllStudent() throws IOException {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> studentList = dao.selectAllStudent();
        studentList.forEach(s-> System.out.println(s));
        sqlSession.close();
    }
    @Test
    public void  testselectMyStudent() throws IOException {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<MyStudent> studentList = dao.selectMyStudent();
        studentList.forEach(s-> System.out.println(s));
        sqlSession.close();
    }
    @Test
    public void  testselectDiffColProperty() throws IOException {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<MyStudent> studentList = dao.selectDiffColProperty();
        studentList.forEach(s-> System.out.println(s));
        sqlSession.close();
    }
    @Test
    public void  testselectLikeName() throws IOException {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        String name = "%李%";
        List<Student> studentList = dao.selectLikeName(name);
        studentList.forEach(s-> System.out.println(s));
        sqlSession.close();
    }
    @Test
    public void  selectLikeNameTwo() throws IOException {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        String name = "李";
        List<Student> studentList = dao.selectLikeNameTwo(name);
        studentList.forEach(s-> System.out.println(s));
        sqlSession.close();
    }
}
