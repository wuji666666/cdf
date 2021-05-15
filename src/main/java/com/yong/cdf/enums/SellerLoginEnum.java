package com.yong.cdf.enums;

import lombok.Getter;

/**
 * @ClassName: SellerLoginEnum
 * @Description: 卖家登录和注册
 * @Author
 * @Date 2021/5/11
 * @Time 14:32
 * @Version 1.0
 */

@Getter
public enum SellerLoginEnum {

    LOGIN_FAILURE(1,"用户名或者密码错误"),
    LOGIN_USERNAME_NOT_EXIST(2,"用户不存在"),
    REGISTER_USER_HAS_EXIST(3,"用户已经存在"),
    REGISTER_PASSWORD_IS_NOT_PERSISTENCE(4,"密码前后不一致"),
    REGISTER_PASSWORD_FORMAT_IS_ERROR(5,"密码不能小于6个字符"),
    REGISTER_PHONE_FORMAT_ERROR(6,"电话号码为11位数字"),
    REGISTER_EMAIL_FORMAT_ERROR(7,"邮箱格式不正确"),
    UPDATE_SELLER_HAS_LOGOUT(8,"请登录后再修改用户信息"),
    COOKIE_SELLER_LOGOUT_FAILURE(9,"清除cookie失败"),
    SELLER_MESSAGE_UPDATE_SUCCESS(10,"用户信息修改成功")



    ;
    private final Integer code;
    private final String message;

    SellerLoginEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
