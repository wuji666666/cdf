package com.yong.cdf.service.impl;

import com.github.pagehelper.PageInfo;
import com.yong.cdf.entity.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@SpringBootTest
@Slf4j
class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoServiceImpl productInfoService;
    @Test
    public void findByNameTest(){
      List<ProductInfo> productInfoList= productInfoService.findByMsg("服饰皮具");
      System.out.println(productInfoList.size());
    }
    @Test
    public void selectInfoPage(){
       List<ProductInfo> lists= productInfoService.findByPage(3,4);
       System.out.println(lists.size());
    }

    @Test
    public void findByCreateTimeTest(){
        System.out.println(productInfoService.findByCreateTime("欧诗漫",7).size());
    }

    @Test
    public void findByPriceAsc(){
        System.out.println(productInfoService.findByPriceAsc("诗漫"));
    }

    @Test
    public void findAllTest(){
      List<ProductInfo> list= productInfoService.findAll();
      System.out.println(list.size());
    }

    @Test
    public void findByPriceDesc(){
        System.out.println(productInfoService.findByPriceDesc("诗漫"));
    }

    @Test
    public void findByPageGroupDescTest(){
        System.out.println(productInfoService.findByPageGroupDesc());
    }

    @Test
    public void findByFirstCategory(){
        System.out.println(productInfoService.findByFirstCategory("护肤品").size());
    }

    @Test
    public void findNewGoodsTest(){
        System.out.println(productInfoService.findNewGoods(4).size());
    }

    @Test
    public void findMostWelcome(){
        System.out.println(productInfoService.findMostWelcome());
    }

    @Test
    public void findSecondCategoryTest(){
        System.out.println(productInfoService.findSecondCategory("服饰皮具"));
    }

    @Test
    public void findByIdTest(){
        System.out.println(productInfoService.findById("bc55147fc2a94da6a4f967bfa4e923fb"));
    }

    @Test
    public void findByIdsTest(){
        Set set=new HashSet<String>();
        set.add("1a077d5bfcb041bf9d9078732779bb29");
        set.add("ab4e051c0b674e139a52d3b7f4b9549b");
        set.add("a423decfb05b46f5ac704b080fbfaec5");
        System.out.println(productInfoService.findByIds(set));
    }

    @Test
    public void findGoodsListTest(){
     PageInfo<ProductInfo> pageInfo= productInfoService.findGoodsList(1,6);
     log.info(String.valueOf(pageInfo.getList().size()));
     log.info(String.valueOf(pageInfo.getPages()));
    }

    @Test
    public void updateProductType(){
      ProductInfo productInfo=  productInfoService.findById("64289542b6d5453da987f7bd329b4fee");
      productInfo.setProduct_type(0);
      productInfoService.updateProductInfo(productInfo);
    }
}