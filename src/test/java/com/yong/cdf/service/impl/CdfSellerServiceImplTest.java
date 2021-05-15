package com.yong.cdf.service.impl;

import com.yong.cdf.service.CdfSellerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CdfSellerServiceImplTest {

    @Autowired
    private CdfSellerService cdfSellerService;

    @Test
    public void findByUsername(){
       System.out.println(cdfSellerService.findByUsername("wuji"));
    }

}