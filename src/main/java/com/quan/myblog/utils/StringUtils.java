package com.quan.myblog.utils;


/**
 * @ClassName: StringUtils
 * @Description: 自己写一个字符串工具类 (失败品)
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/1/19 15:15
 */
public class StringUtils {
    // 判定字符串是否存在空白符
    public static boolean isBlank(String str) {
        /**
         * 1. 先判断是否空字符串或者长度为零的字符串，是则返回true
         * 2. 若不为空串，再判断字符串里面是否存在空格字符
         **/
        int strLen;
        if (str != null && (strLen = str.length()) > 0) {
            // 删除空格后的字符串长度与之前不一致
            int len = str.trim().length();
            System.out.println(len);
            if (len != strLen) return false;
        }
        else return true;

        return true;
    }
}
