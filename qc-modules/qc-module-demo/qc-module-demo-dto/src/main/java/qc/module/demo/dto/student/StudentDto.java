package qc.module.demo.dto.student;

import lombok.Data;

import java.util.Date;

@Data
public class StudentDto {
    //学号
    private String no;
    
    //姓名
    private String name;
    
    //性别
    private String sex;
    
    //出生日期
    private String birthday;
    
    //入学日期
    private String inSchoolDay;
    
    //班级编号
    private String classCode;
    
    //手机号
    private String phone;
    
    //家庭住址
    private String homeAddress;
    
}
