package qc.module.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@TableName("qc_users")
@Data
public class User implements Serializable, Cloneable {
    /**
     * ID
     */
    @TableId
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 登录用户名
     */
    private String code;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 是否启用
     */
    private Boolean enable;
    /**
     * 过期时间
     */
    private Date expiredtm;
    /**
     * 部门ID
     */
    private Integer deptid;
}