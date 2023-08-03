package qc.module.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("course")
public class Course {
    /**
     * 课程名称
     */
    private String name;
    /**
     * 课程编码
     */
    @TableId
    private String no;
}
