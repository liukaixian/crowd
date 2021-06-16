package com.atguigu.crowd.util;

import com.atguigu.crowd.constant.CrowdConstant;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by xian
 * Data : 2021/5/27.
 * Time : 14:12.
 */
public class CrowdUtil {


    public static boolean judgeRequestType(HttpServletRequest request){
        //1获取请求头消息
        String acceptHeader  = request.getHeader("Accept");
        String xRequestHeader = request.getHeader("X-Requested-With");
            return (acceptHeader != null && acceptHeader.contains("application/json"))
                    ||
                    (xRequestHeader !=null && xRequestHeader.equals("XMLHttpRequest"));
    }


    public static String md5(String source){

        if (source == null || source.length() == 0){
           throw  new RuntimeException(CrowdConstant.MESSAGE_STRING_INVALIDATE);
        }
        String algorithm = "md5";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            byte[] input = source.getBytes();
            byte[] digest = messageDigest.digest(input);
            int signum = 1;
            BigInteger bigInteger = new BigInteger(signum, digest);
            int radix = 16;
            String encoded = bigInteger.toString(radix);
            return encoded;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }
}
