package qc.common.core.http;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Response
 *
 * @author QuCheng Tech
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class Response<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private int code;

    private String msg;

    private T data;

    public static <T> Response<T> ok() {
        return restResult(null, ResponseStatusEnum.SUCCESS.getValue(), null);
    }

    public static <T> Response<T> ok(T data) {
        return restResult(data, ResponseStatusEnum.SUCCESS.getValue(), null);
    }

    public static <T> Response<T> ok(T data, String msg) {
        return restResult(data, ResponseStatusEnum.SUCCESS.getValue(), msg);
    }

    public static <T> Response<T> ok(T data, int code, String msg) {
        return restResult(data, code, msg);
    }

    public static <T> Response<T> warn() {
        return restResult(null, ResponseStatusEnum.WARN.getValue(), null);
    }

    public static <T> Response<T> warn(String msg) {
        return restResult(null, ResponseStatusEnum.WARN.getValue(), msg);
    }

    public static <T> Response<T> warn(T data) {
        return restResult(data, ResponseStatusEnum.WARN.getValue(), null);
    }

    public static <T> Response<T> warn(T data, String msg) {
        return restResult(data, ResponseStatusEnum.WARN.getValue(), msg);
    }

    public static <T> Response<T> error() {
        return restResult(null, ResponseStatusEnum.ERROR.getValue(), null);
    }

    public static <T> Response<T> error(String msg) {
        return restResult(null, ResponseStatusEnum.ERROR.getValue(), msg);
    }

    //public static <T> Response<T> error(T data) {
    //    return restResult(data, ResponseStatusEnum.ERROR.getValue(), null);
    //}

    public static <T> Response<T> error(T data, String msg) {
        return restResult(data, ResponseStatusEnum.ERROR.getValue(), msg);
    }

    private static <T> Response<T> restResult(T data, int code, String msg) {
        Response<T> apiResult = new Response<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }
}
