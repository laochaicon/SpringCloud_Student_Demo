package qc.common.core.unify;

import qc.common.core.constants.QCConstant;

/**
 * 渠成统一返回值处理类，用于处理与返回值/结果有关的统一定义
 *
 * @author QuCheng Tech
 */
public class QCUnifyReturnValue {
    /**
     * 方法返回警告提醒结果，表示提醒信息
     *
     * @param promptInfo 提醒信息
     * @return java.lang.String
     * @author QuCheng Tech
     * @date 2022/12/11
     */
    public static final String Warn(String promptInfo) {
        return QCConstant.APP_PROMPT_PREFIX.concat(promptInfo);
    }

    /**
     * 方法返回成功结果，统一定义为返回null表示成功
     */
    public static final String Success() {
        return Success(null);
    }

    /**
     * 方法返回成功结果，统一定义为返回null表示成功
     */
    public static final String Success(String resultInfo) {
        return resultInfo;
    }
}
