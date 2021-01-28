package com.test.springtest.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Table(name = "student")
@Data
public class Student {
    @Id
    @KeySql(useGeneratedKeys = true)
    Long id;

    String name;
    String className;
    Date createTime;
    @Transient
    String remark;
}
