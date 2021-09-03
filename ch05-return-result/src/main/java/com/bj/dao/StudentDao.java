package com.bj.dao;

import com.bj.domain.Student;
import com.bj.domain.MyStudent;
import com.bj.vo.ViewStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    Student selectStudentById(Integer id);
    List<Student> selectMultiParam(@Param("myname") String name,
                                   @Param ("myage") Integer age);

    ViewStudent selectViewStudentById(Integer id);

    int countStudent();

    Map<Object,Object> selectMapById(Integer stuid);


    List<Student> selectAllStudent();

    List<MyStudent> selectMyStudent();
    List<MyStudent> selectDiffColProperty();

    List<Student> selectLikeName(String name);
    List<Student> selectLikeNameTwo(String name);
}
