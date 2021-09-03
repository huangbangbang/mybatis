package com.bj.dao;

import com.bj.domain.Student;


import java.util.List;

public interface StudentDao {
    List<Student> selectStudentIf(Student student);
    List<Student> selectStudentWhere(Student student);
    List<Student> selectForeachOne(List<Integer> idlist);
    List<Student> selectForeachTwo(List<Student> studentList);
    List<Student> selectStudentAll();

}
