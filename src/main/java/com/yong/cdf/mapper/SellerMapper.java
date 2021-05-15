package com.yong.cdf.mapper;

import com.yong.cdf.entity.CdfSeller;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName: UserMapper
 * @Description: 用户登录
 * @Author
 * @Date 2021/5/10
 * @Time 23:32
 * @Version 1.0
 */

@Mapper
public interface SellerMapper {
    Integer addUser(CdfSeller user);

    CdfSeller findByUsername(String username);

    Integer updateSeller(CdfSeller cdfSeller);


}
