package com.yong.cdf.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @ClassName: CdfSellerRegisterForm
 * @Description: 卖家端注册会员
 * @Author
 * @Date 2021/5/12
 * @Time 9:34
 * @Version 1.0
 */

@Data
public class CdfSellerRegisterForm {


    private String user_id;

    @NotBlank(message = "用户名不能为空")
    private  String username;

    @NotBlank(message = "密码不能为空")
    private String  password;

    @NotBlank(message = "电话号码不能为空")
    private String phone_number;

    @NotBlank(message = "邮箱格式不正确")
    private String email;

    @NotBlank(message = "确认密码不能为空")
    private String confirmPWD;
}
