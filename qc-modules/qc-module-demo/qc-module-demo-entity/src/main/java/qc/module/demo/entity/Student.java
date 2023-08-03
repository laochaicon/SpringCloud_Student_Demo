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
    private String NO ;
    
    /** 姓名 */
    private String NAME ;
    
    /** 性别 */
    private String SEX ;
    
    /** 出生日期 */
    private Date BIRTHDAY ;
    
    /** 入学日期 */
    private Date INSCHOOLDAY ;
    
    /** 班级编号 */
    private String CLASSCODE ;
    
    /** 手机号 */
    private String PHONE ;
    
    /** 家庭住址 */
    private String HOMEADDRESS ;


}