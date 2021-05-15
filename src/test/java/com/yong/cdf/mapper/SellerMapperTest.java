package com.yong.cdf.mapper;

import com.yong.cdf.entity.CdfSeller;
import com.yong.cdf.util.UniqueKey;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName: UserMapperTest
 * @Description: 用户登录测试
 * @Author
 * @Date 2021/5/10
 * @Time 23:33
 * @Version 1.0
 */

@SpringBootTest
 class SellerMapperTest {

    @Autowired
    private SellerMapper sellerMapper;

    @Test
    public void addSellerTest(){
        CdfSeller user=new CdfSeller();
        user.setUser_id(UniqueKey.generatedKey());
        user.setUsername("wuji");
        user.setPassword("yi120214");
        user.setEmail("2214222026@qq.com");
        user.setPhone_number("13476005890");
        int n=sellerMapper.addUser(user);
        System.out.println(n);
    }


    @Test
    public void findUsernameTest(){
        System.out.println(sellerMapper.findByUsername("wuji"));
    }

    @Test
    public void updateSellerTest(){
        CdfSeller cdfSeller=new CdfSeller();
        cdfSeller.setUser_id("16206989791690");
        cdfSeller.setPhone_number("13476005890");
        cdfSeller.setEmail("2214222026@qq.com");
        cdfSeller.setPassword("yi120213");
        Integer n=sellerMapper.updateSeller(cdfSeller);
        System.out.println(n);
    }
}
