package com.yong.cdf.enums;

/**
 * @ClassName: SellerException
 * @Description: 卖家端异常
 * @Author
 * @Date 2021/5/9
 * @Time 13:46
 * @Version 1.0
 */


public enum SellerOperateEnum {
    ADD_PRODUCT_SUCCESS(0,"商品插入成功"),
    ADD_PRODUCT_EXCEPTION(1,"商品插入异常"),
    UPDATE_PRODUCT_ID_ISNULL(2,"ID为空，无法查询到商品信息"),
    UPDATE_PRODUCT_MESSAGE_ERROR(3,"商品信息更新异常"),
    UPDATE_PRODUCT_SUCCESS(4,"商品信息修改成功"),
    ON_SALL_PRODUCT_NOT_EXSIST(5,"商品不存在"),
    OFF_SALE_PRODUCT_NOT_EXSIST(6,"商品不存在"),
    UPDATE_PRODUCT_STATE_SUCCESS(7,"商品状态修改成功"),


    ;


    private Integer code;
    private String message;

    SellerOperateEnum(Integer code, String message){
        this.code=code;
        this.message=message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
