package qc.common.core.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 访问的客户端类型
 *
 * @author QuCheng Tech
 * @create 2023/1/11
 */
@Getter
@AllArgsConstructor
public enum ClientTypeEnum {
    UN_DEFINE(0, "未定义"),
    PC(10, "电脑"),
    PHONE(20, "手机"),
    PAD(30, "平板");

    @EnumValue
    private int index;
    private String name;
}
