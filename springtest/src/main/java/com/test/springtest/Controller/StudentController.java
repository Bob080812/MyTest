package com.test.springtest.Controller;

import com.test.springtest.pojo.Student;
import com.test.springtest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("hello")
    public Student findById(){
        Long id = 1L;
        return studentService.findById(id);
    }

}
