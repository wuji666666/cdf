package com.yong.cdf.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @ClassName: ProductInfoForm
 * @Description: 接收前台传来的，需要添加的商品信息
 * @Author
 * @Date 2021/5/9
 * @Time 9:19
 * @Version 1.0
 */

@Data
public class ProductInfoForm {

    @NotBlank(message = "商品名称不能为空")
    private String product_name;

    @NotNull(message="原价不能为空")
    private Integer cost_price;

    @NotNull(message = "折扣价不能为空")
    private Integer discount_price;

    @NotNull(message = "库存不能为空")
    private Integer product_stock;

    @NotBlank(message = "商品描述不能为空")
    private String product_description;

    @NotBlank(message = "图片地址不能为空")
    private String product_icon;

    @NotBlank(message = "标题不能为空")
    private String product_title;

    @NotBlank(message = "一级目录不能为空")
    private String first_category;

    @NotBlank(message = "二级目录不能为空")
    private String second_category;

    @NotBlank(message ="三级目录不能为空")
    private String third_category;

    @NotBlank(message = "品牌名称不能为空")
    private String brand_name;
}
