package com.bj.dao;

import com.bj.domain.Student;
import com.bj.vo.QueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    Student selectStudentById(Integer id);
    List<Student> selectMultiParam(@Param("myname") String name,
                                   @Param ("myage") Integer age);

    List<Student> selectMultiObject(QueryParam param);

    List<Student> selectMultiStudent(Student student);
    List<Student> selectMultiPosition(String name,Integer age);


    List<Student> selectMultiByMap(Map<String,Object> map);

    List<Student> selectUser$(@Param("myname") String name);

    List<Student> selectUser$Order(@Param("a") String colName);
}
