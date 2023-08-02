package qc.module.demo.dto.student;
@lombok.Data
public class StudentAddDto {
    /**
     * 家庭住址
     */
    private String address;
    /**
     * 出生日期
     */
    private String birthday;
    /**
     * 班级编码
     */
    private String classno;
    /**
     * 入学日期
     */
    private String inday;
    /**
     * 姓名
     */
    private String name;
    /**
     * 学号
     */
    private String no;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 性别
     */
    private boolean sex;
}
