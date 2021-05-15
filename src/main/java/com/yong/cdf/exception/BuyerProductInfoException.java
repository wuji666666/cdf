package com.yong.cdf.exception;

/**
 * @ClassName: SellerException
 * @Description: 局部异常处理
 * @Author
 * @Date 2021/5/9
 * @Time 13:53
 * @Version 1.0
 */


public class BuyerProductInfoException extends RuntimeException{
    private Integer code;
    private String message;


    public BuyerProductInfoException(Integer code, String message){
        this.code=code;
        this.message=message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
