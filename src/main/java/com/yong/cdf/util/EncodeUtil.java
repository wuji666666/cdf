package com.yong.cdf.util;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.thoughtworks.xstream.core.util.Base64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncodeUtil {

    private static final HashFunction FUNCTION = Hashing.md5();
   
    public static String hashEncode(String msg){
       return FUNCTION.hashBytes(msg.getBytes()).toString();
    }

    public static String md5Encode(String msg) {

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] input=md.digest(msg.getBytes());
            Base64Encoder base64Encoder=new Base64Encoder();
            String base64_msg=base64Encoder.encode(input);
            return base64_msg;

        } catch (NoSuchAlgorithmException e) {
            e.getMessage();
          return  null;
        }

    }

}
