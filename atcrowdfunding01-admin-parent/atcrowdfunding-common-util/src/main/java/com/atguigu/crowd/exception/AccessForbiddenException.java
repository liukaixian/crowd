package com.atguigu.crowd.exception;

/**
 * 没有登录拒绝访问异常
 * Created by xian
 * Data : 2021/6/3.
 * Time : 14:39.
 */

public class AccessForbiddenException extends RuntimeException {
    public AccessForbiddenException() {
    }

    public AccessForbiddenException(String message) {
        super(message);
    }

    public AccessForbiddenException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccessForbiddenException(Throwable cause) {
        super(cause);
    }

    public AccessForbiddenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
