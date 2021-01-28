package com.test.springtest.Controller;

import com.test.springtest.annotation.LimitKey;
import com.test.springtest.pojo.Student;
import com.test.springtest.service.StudentService;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping
public class StudentController {

    @Autowired
    private StudentService studentService;

    @LimitKey(methodName="findById", url="hello")
    @PostMapping ("/hello")
    public Student findById(HttpServletRequest request,String id) {
        String ip = request.getRemoteAddr();
        System.out.println(ip);
        Student byId = studentService.findById(1L);
        StringUtils.isBlank(ip);
        return studentService.findById(Long.valueOf(id));
    }
}
