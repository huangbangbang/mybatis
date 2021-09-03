package com.bj.dao.impl;

import com.bj.dao.StudentDao;
import com.bj.domain.Student;
import com.bj.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> selectStudents() {
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        String sqlId="com.bj.dao.StudentDao.selectStudents";
        List<Student> studentList =sqlSession.selectList(sqlId);

        studentList.forEach(stu-> System.out.println(stu));
        sqlSession.close();
        return studentList;
    }

    @Override
    public int insertStudent(Student student) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        String sqlId="com.bj.dao.StudentDao.insertStudent";
        int nums;
        nums=sqlSession.insert(sqlId,student);
        sqlSession.commit();
        sqlSession.close();

        return nums;

    }
}
