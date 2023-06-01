package qc.common.core.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 应用程序类型枚举
 *
 * @author QuCheng Tech
 * @create 2023/1/11
 */
@Getter
@AllArgsConstructor
public enum ApplicationTypeEnum {
    WEB(10, "Web"),//可扩展区分传统web应用、大屏应用
    FORM(20, "Form"),
    APP(30, "App");//可扩展区分安卓APP、微信小程序等

    @EnumValue
    private int index;
    private String name;
}
