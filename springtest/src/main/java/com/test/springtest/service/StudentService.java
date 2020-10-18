package com.test.springtest.service;

import com.test.springtest.mapper.StudentMapper;
import com.test.springtest.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public Student findById(Long id){
        return studentMapper.selectByPrimaryKey(id);
    }
}
