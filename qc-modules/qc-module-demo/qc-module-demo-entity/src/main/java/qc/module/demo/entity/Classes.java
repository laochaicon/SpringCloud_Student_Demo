package qc.module.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
@TableName("class")
public class Classes implements Serializable,Cloneable{
    /** 班级编号 */
    @TableId
    private String NO;
    
    /** 班级名称 */
    private String NAME;


}
