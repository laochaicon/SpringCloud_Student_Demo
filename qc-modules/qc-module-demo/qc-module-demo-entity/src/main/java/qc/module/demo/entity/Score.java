package qc.module.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@Data
@TableName("score")
public class Score {
    /**学生学号*/;
    private String  studentNo;
    /**课程编号*/
    @TableId
    private String  courseNo;
    /**分数*/
    private String score ;

}