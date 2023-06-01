package qc.module.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("qc_depts")
public class Dept implements Serializable, Cloneable {
    /**
     * 部门/组织ID
     */
    @TableId
    private Integer id;
    /**
     * 部门/组织名称
     */
    private String name;
    /**
     * 父ID
     */
    private Integer parentid;
    /**
     * 排序号
     */
    private Integer odr;
    /**
     * 是否启用
     */
    private Boolean enable;
    /**
     * 备注
     */
    private String description;
}
