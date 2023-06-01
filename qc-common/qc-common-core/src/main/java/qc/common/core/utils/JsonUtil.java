package qc.common.core.utils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * JsonUtil
 *
 * @author QuCheng Tech
 */
public class JsonUtil {
    /**
     * object转json字符串(保留null)
     */
    public static String toJSONString(Object object){
        return JSONObject.toJSONString(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue);
    }
}
