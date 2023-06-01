package qc.common.core.exception;

/**
 * 渠成通用定义异常--输入参数异常，用于在判断和验证过程中抛出该异常
 *
 * @author QuCheng Tech
 * @create 2022/12/12
 */
public class QCPromptException extends Exception {

    public QCPromptException(String message) {
        super(message);
    }
}
