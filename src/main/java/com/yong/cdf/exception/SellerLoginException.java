package com.yong.cdf.exception;

import lombok.Data;

/**
 * @ClassName: SellerLoginException
 * @Description: 用户登录异常
 * @Author
 * @Date 2021/5/11
 * @Time 15:22
 * @Version 1.0
 */

@Data
public class SellerLoginException extends RuntimeException{
    private  Integer code;

    private String message;

    public SellerLoginException (Integer code,String message){
        this.code=code;
        this.message=message;
    }


}
