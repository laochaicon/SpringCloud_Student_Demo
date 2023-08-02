package qc.module.demo.dto.student;

import lombok.Data;

import java.util.Date;

@Data
public class StudentDto {
    //学号
    private String NO;
    
    //姓名
    private String NAME;
    
    //性别
    private String SEX;
    
    //出生日期
    private String BIRTHDAY;
    
    //入学日期
    private String INSCHOOLDAY;
    
    //班级编号
    private String CLASSCODE;
    
    //手机号
    private String PHONE;
    
    //家庭住址
    private String HOMEADDRESS;
    
}
