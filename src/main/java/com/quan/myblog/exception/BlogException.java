package com.quan.myblog.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: BlogException
 * @Description: 统一的异常类
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/1/19 15:35
 */
public class BlogException extends RuntimeException {
    // 日志记录
    private static final Logger logger = LoggerFactory.getLogger(BlogException.class);
    // 异常类基本信息
    private String errorCode;
    private String[] errorMessageArgument;

    /***
     * 构造方法需要注意runtimeException的构造函数
     **/
    public BlogException() {
        this("");
    }

    public BlogException(String message) {
        super(message);
        this.errorCode = "fail";
        this.errorMessageArgument = new String[0];
    }

    public BlogException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = "fail";
        this.errorMessageArgument = new String[0];
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String[] getErrorMessageArgument() {
        return errorMessageArgument;
    }

    public void setErrorMessageArgument(String[] errorMessageArgument) {
        this.errorMessageArgument = errorMessageArgument;
    }

    // 静态方法
    // 存在错误的信息
    public static BlogException withErrorCode(String errorCode) {
        BlogException blogException = new BlogException();
        blogException.errorCode = errorCode;
        return blogException;
    }

    // 存在错误的变量
    public BlogException withErrorMessageAgruments(String... errorMessageAgruments) {
        if (errorMessageAgruments != null)
            this.errorMessageArgument = errorMessageAgruments;
        return this;
    }
}
