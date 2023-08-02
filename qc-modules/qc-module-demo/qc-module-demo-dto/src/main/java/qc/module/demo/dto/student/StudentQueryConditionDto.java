package qc.module.demo.dto.student;

@lombok.Data
public class StudentQueryConditionDto {
    /**
     * 班级，班级编码，可以不指定
     */
    private String classno;
    /**
     * 关键字，关键字可输入姓名、学号、手机号、家庭地址中的一个
     */
    private String keywords;
    /**
     * 入学时间
     */
    private String tm;
}
