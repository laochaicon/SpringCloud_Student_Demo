package qc.common.core.constants;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * 渠成-公用静态定义
 *
 * @author QuCheng Tech
 */
public interface QCConstant {
    /**
     * 应用程序中的提示信息前缀，在返回信息为String类型时，如使用该前缀表示错误提示信息
     */
    String APP_PROMPT_PREFIX = "@@QC_APP_PROMPT@@";

    /**
     * UTF8编码
     */
    Charset CHARSET_UTF8 = StandardCharsets.UTF_8;

    /**
     * 分页--默认的页码，默认为第1页
     */
    int PAGEING_DEFAULT_PAGE_NUM = 0X1;

    /**
     * 分页--默认的每页数量，默认为10
     */
    int PAGEING_DEFAULT_PAGE_SIZE = 0XA;
}
