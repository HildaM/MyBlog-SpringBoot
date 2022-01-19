package com.quan.myblog.utils;

import com.quan.myblog.contants.WebConst;
import com.quan.myblog.pojo.User;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName: DataProcessUtils
 * @Description: 数据处理工具类
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/1/19 16:06
 */
public class DataProcessUtils {

    /**
     * @Author Hilda
     * @Description //TODO 转换信息为MD5字符串
     * @Date 16:06 2022/1/19
     * @Param [msg]
     * @returnValue java.lang.String
     **/
    public static String getMD5Code(String msg) {
        // 空串处理
        if (StringUtils.isBlank(msg)) return null;

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] encode = messageDigest.digest(msg.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte anEncode : encode) {
                String hex = Integer.toHexString(0xff & anEncode);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException ignored) {
        }

        return "";
    }


    /**
     * @Author Hilda
     * @Description //TODO 获取Session工具类
     * @Date 18:01 2022/1/19
     * @Param []
     * @returnValue void
     **/
    public static User getUserSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (null == session) return null;
        // 获取指定Session下的User对象
        return (User) session.getAttribute(WebConst.LOGIN_SESSION_KEY);
    }


    @Test
    public void test_getMD5Code() {
        String msg = "test123";
        String md5 = DataProcessUtils.getMD5Code(msg);
        System.out.println(msg + " " + md5);
    }
}
