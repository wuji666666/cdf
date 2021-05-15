package com.yong.cdf.service;

import com.yong.cdf.entity.CdfSeller;

/**
 * @ClassName: CdfSellerService
 * @Description: 卖家端登录、登出、注册
 * @Author
 * @Date 2021/5/11
 * @Time 14:01
 * @Version 1.0
 */


public interface CdfSellerService {
    Integer addUser(CdfSeller cdfSeller);

    CdfSeller findByUsername(String username);

    Integer updateSeller(CdfSeller cdfSeller);
}
