package com.quan.myblog.utils;

import com.quan.myblog.contants.WebConst;
import com.quan.myblog.pojo.User;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import sun.misc.BASE64Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
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


    /**
     * @Author Hilda
     * @Description //TODO 设置用户登录Cookie
     * @Date 10:25 2022/1/20
     * @Param [response, uid]
     * @returnValue void
     **/
    public static void setCookie(HttpServletResponse response, Integer uid) {
        try {
            String aesCode = enAes(uid.toString(), WebConst.AES_SALT);
            boolean isSSL = false;

            Cookie cookie = new Cookie(WebConst.USER_COOKIE, aesCode);
            cookie.setPath("/");
            cookie.setMaxAge(60 * 30);  // 单位为秒。存留时间为30分钟
            cookie.setSecure(isSSL);

            response.addCookie(cookie);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * @Author Hilda
     * @Description //TODO
     *        （1）新建Cipher对象时需要传入一个参数"AES/CBC/PKCS5Padding"
     *        （2）cipher对象使用之前还需要初始化，共三个参数("加密模式或者解密模式","密匙","向量")
     *        （3）调用数据转换：cipher.doFinal(content)，其中content是一个byte数组
     * @Date 10:18 2022/1/20
     * @Param [data, key]
     * @returnValue java.lang.String
     **/
    private static String enAes(String data, String key) throws NoSuchPaddingException, NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        // 初始化Cipher类，选择aes加密算法
        Cipher cipherAes = Cipher.getInstance("AES");
        // 生成密钥
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
        // 正式初始化
        cipherAes.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        // 对加密结果进行一层包装后再返回,防止乱码及其他意外情况
        byte[] encrypedBytes = cipherAes.doFinal(data.getBytes());
        return new BASE64Encoder().encode(encrypedBytes);
    }


    @Test
    public void test_getMD5Code() {
        String msg = "test123";
        String md5 = DataProcessUtils.getMD5Code(msg);
        System.out.println(msg + " " + md5);
    }
}
