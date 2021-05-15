package com.yong.cdf.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @ClassName: CdfSellerForm
 * @Description: 登录验证
 * @Author
 * @Date 2021/5/11
 * @Time 10:41
 * @Version 1.0
 */

@Data
public class CdfSellerForm {

    @NotBlank(message = "用户名不能为空")
    private  String username;

    @NotBlank(message = "密码不能为空")
    private String  password;
}
