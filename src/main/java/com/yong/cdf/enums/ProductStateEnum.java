package com.yong.cdf.enums;

import lombok.Getter;

/**
 * @ClassName: ProductStateEnum
 * @Description: 商品状态：在售与下架
 * @Author
 * @Date 2021/5/9
 * @Time 18:02
 * @Version 1.0
 */

@Getter
public enum ProductStateEnum {
    SALE_ON_PRODUCT(0,"在售"),
    SALE_OFF_PRODUCT(1,"已下架");



    private final Integer code;
    private final String message;

    ProductStateEnum(Integer code, String message){
        this.code=code;
        this.message=message;
    }

}
