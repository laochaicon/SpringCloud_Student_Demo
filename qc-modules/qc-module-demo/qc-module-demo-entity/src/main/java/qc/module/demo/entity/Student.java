package qc.module.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;



@Data
@TableName("student")
public class Student implements Serializable,Cloneable{
    /** 学号 */
    @TableId
    private String no;
    
    /** 姓名 */
    private String name ;
    
    /** 性别 */
    private String sex ;
    
    /** 出生日期 */
    private Date birthday ;
    
    /** 入学日期 */
    private Date inSchoolDay ;
    
    /** 班级编号 */
    private String classCode ;
    
    /** 手机号 */
    private String phone ;
    
    /** 家庭住址 */
    private String homeAddress ;


}