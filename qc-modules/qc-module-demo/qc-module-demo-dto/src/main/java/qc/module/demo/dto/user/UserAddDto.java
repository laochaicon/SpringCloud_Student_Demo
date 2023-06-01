package qc.module.demo.dto.user;

/**
 * UserAddDto
 *
 * @author QuCheng Tech
 * @since 2023/6/1
 */
@lombok.Data
public class UserAddDto {
    private String code;
    private int deptid;
    private boolean enable;
    private String expiretime;
    private String name;
    private String phone;
}