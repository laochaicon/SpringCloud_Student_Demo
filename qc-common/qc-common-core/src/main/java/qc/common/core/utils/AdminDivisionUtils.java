package qc.common.core.utils;

/**
 * AdminDivisionUtils
 * 该类中的方法在查询行政区划信息时，通过输入的行政区划编码获取行政区划编码对应的等级以及下一级行政区划编码的开头数字
 *
 * @author QuCheng Tech
 * @create 2023/02/09
 */
public class AdminDivisionUtils {
    /**
     * 据行政区划编码获取对应的行政区划级别
     * 行政区划编码有12位数字组成,第一、二位表示省级，1级；第三、四位表示地级，2级；第五、六位表示县级，3级；第七至九位表示乡、镇，4级；最后三位表示居委会、村委会，5级
     *
     * @param	code 行政区划编码
     * @return level 行政区划等级
     * @author QcCheng Tech
     * @since 2023/2/9
     */
    public static int getDivisionLevel(String code){
        //行政区划级别，初始值为1，省级，即输入编码的等级level最小都是1，对应省级行政区划
        int level = 1;

        //取出行政区划编码的第3~4位数字，若这个两位数大于零，说明该编码行政区划等级在地级及以下
        if (Integer.parseInt(code.substring(2,3)) > 0){
            //行政区划等级+1，对应地级
            level++;

            //取出行政区划编码的第5~6位数字，若这个两位数大于零，说明该编码行政区划等级在县级及以下
            if (Integer.parseInt(code.substring(4,5)) > 0){
                //行政区划等级+1，对县级
                level++;

                //取出行政区划编码的第7~9位数字组成一个三位数，若这个三位数大于零，说明该编码行政区划等级在乡镇级及以下
                if (Integer.parseInt(code.substring(6,8)) > 0){
                    //行政区划等级+1，对应乡镇级
                    level++;

                    //取出行政区划编码的第10~12位数字组成一个三位数，若这个三位数大于零，说明该编码行政区划等级为村委会级
                    if (Integer.parseInt(code.substring(9,11)) > 0){
                        //行政区划等级+1，对应村委会级
                        level++;
                    }
                }
            }
        }

        return level;
    }

    /**
     * 根据行政区划编码以及指定行政区划等级获取行政区划编码开头数字
     *
     * @param	code 行政区划编码
     * @param	level 行政区划等级
     * @return  行政区划等级下该行政区划编码对应的开头数字
     * @author QcCheng Tech
     * @since 2023/2/9
     */
    public static String getDivisionStartCode(String code , int level){
        //指定行政区划等级对应得行政区划编码开头数字
        String startCode = null ;

        //指定行政区划等级为1，截取输入行政区划编码的1~2位数字
        if (level == 1)
            startCode = code.substring(0,1);

        //指定行政区划等级为2，截取输入行政区划编码的1~4位数字
        if (level == 2)
            startCode = code.substring(0,3);

        //指定行政区划等级为3，截取输入行政区划编码的1~6位数字
        if (level == 3)
            startCode = code.substring(0,5);

        //指定行政区划等级为4，截取输入行政区划编码的1~9位数字
        if (level == 4)
            startCode = code.substring(0,8);

        //指定行政区划等级为5，行政区划编码开头数字就是输入的行政区划编码
        if (level == 5)
            startCode = code;

        return startCode;
    }

    /**
     * 判断输入的行政区划编码是否是12位数字组成，符合返回true，否则返回false
     *
     * @param	code 行政区划编码
     * @return boolean
     * @author QcCheng Tech
     * @since 2023/2/9
     */
    public static boolean isNum(String code){
        String regex = "\\d{12}";
        boolean result = code.matches(regex);

        return result;
    }
}
