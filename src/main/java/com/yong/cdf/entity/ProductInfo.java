package com.yong.cdf.entity;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
@Data
public class ProductInfo {
    private String product_id;
    private String product_name;
    private Integer cost_price;
    private Integer discount_price;
    private Integer product_stock;
    private String product_description;
    private String product_icon;
    private Integer sale_quantity;
    private LocalDateTime create_time;
    private LocalDateTime update_time;
    private Integer product_type;
    private String product_title;
    private String first_category;
    private String second_category;
    private String third_category;
    private String brand_name;
}
