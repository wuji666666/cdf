package com.yong.cdf.enums;
import lombok.Getter;

@Getter
public enum ResultEnum{
    SUCCESS(0,"成功"),
    FAILURE(1,"失败"),
    ;
    private final Integer code;
    private final String msg;


    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}
