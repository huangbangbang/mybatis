package com.bj.dao;

import com.bj.domain.Student;

import java.util.List;

public interface StudentDao {
    List<Student> selectStudents();
    int insertStudent(Student student);
}
