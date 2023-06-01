package qc.common.core.http;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ResponseStatusEnum
 *
 * @author QuCheng Tech
 */
@Getter
@AllArgsConstructor
public enum ResponseStatusEnum {
    SUCCESS(0, "成功"),
    WARN(1, "警告提示"),//输入不正确或其他提示信息，预期内的
    ERROR(2, "错误"),//错误或异常，非预期的
    AUTH_PERMISSION_DENIED(5001, "权限不足"),
    AUTH_INVALID_TOKEN(5002, "无效令牌"),
    AUTH_NO_TOKEN(5003, "无访问令牌"),
    AUTH_EXPIRED_TOKEN(5004, "令牌已过期"),
    AUTH_AUTHENTICATION_FAILED(5005, "未授权访问"),
    AUTH_LOGIN_FAIL(5006, "用户名或密码错误"),
    AUTH_LOGOUT(5007, "注销成功"),
    AUTH_UN_SUPPORT_GRANT_TYPE(5008, "不支持的认证方式"),
    AUTH_INVALID_CLIENT(5009, "非法客户端");

    private Integer value;
    private String desc;
}
