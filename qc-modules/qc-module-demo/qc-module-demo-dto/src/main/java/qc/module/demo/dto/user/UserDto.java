package qc.module.demo.dto.user;

/**
 * UserDto
 *
 * @author QuCheng Tech
 * @since 2023/6/1
 */
@lombok.Data
public class UserDto {
    private String code;
    private int deptid;
    private boolean enable;
    private String expiredtm;
    private int id;
    private String name;
    private String phone;
}