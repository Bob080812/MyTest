package com.test.springtest.mapper;

import com.test.springtest.pojo.Student;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface StudentMapper extends Mapper<Student> {
}
