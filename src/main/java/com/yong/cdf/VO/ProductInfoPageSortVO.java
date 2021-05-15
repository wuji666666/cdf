package com.yong.cdf.VO;

import lombok.Data;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: PageSortVO
 * @Description: 产品分组分页排序
 * @Author
 * @Date 2021/4/14
 * @Time 12:12
 * @Version 1.0
 */

@Data
@Repository
public class ProductInfoPageSortVO {
    private String product_name;
    private Integer total_quantity;

}
