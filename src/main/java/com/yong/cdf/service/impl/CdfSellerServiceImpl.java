package com.yong.cdf.service.impl;

import com.yong.cdf.entity.CdfSeller;
import com.yong.cdf.mapper.SellerMapper;
import com.yong.cdf.service.CdfSellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: CdfSellerServiceImpl
 * @Description: 用户登入、登出、注册
 * @Author
 * @Date 2021/5/11
 * @Time 14:04
 * @Version 1.0
 */

@Service
public class CdfSellerServiceImpl implements CdfSellerService {

    @Autowired
    private SellerMapper sellerMapper;

    @Override
    public Integer addUser(CdfSeller cdfSeller) {
        return sellerMapper.addUser(cdfSeller);
    }

    @Override
    public CdfSeller findByUsername(String username) {
        return sellerMapper.findByUsername(username);
    }

    @Override
    public Integer updateSeller(CdfSeller cdfSeller) {
        return sellerMapper.updateSeller(cdfSeller);
    }
}
