package qc.common.core.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * DivisionLevelEnum
 *
 * @author QuCheng Tech
 * @create 2023/02/09
 */
@Getter
@AllArgsConstructor
public enum DivisionLevelEnum {
    PROVINCE(1,"省级"),
    MUNICIPAL(2,"地级"),
    COUNTY(3,"县级"),
    TOWNSHIP(4,"乡镇级"),
    VILLAGE(5,"村委会级");


    @EnumValue
    private int index;
    private String value;
}
