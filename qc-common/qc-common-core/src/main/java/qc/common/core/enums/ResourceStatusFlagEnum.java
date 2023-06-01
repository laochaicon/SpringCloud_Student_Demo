package qc.common.core.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 资源状态标记Flag枚举
 *
 * @author QuCheng Tech
 * @create 2023/5/25
 */
@Getter
@AllArgsConstructor
public enum ResourceStatusFlagEnum {
    NORMAL(0, "正常"),
    DISABLE(5, "禁用"),
    DELETED(9, "已删除");

    @EnumValue
    private int index;
    private String name;
}
