package com.yong.cdf.service;


import com.github.pagehelper.PageInfo;
import com.yong.cdf.VO.ProductInfoPageSortVO;
import com.yong.cdf.entity.ProductInfo;

import java.util.List;
import java.util.Set;

public interface ProductInfoService {
    List<ProductInfo> findByMsg(String productMsg);

    //It is for paging and sorting but it is not used for some function.
    List<ProductInfo> findByPage( Integer startPage, Integer pageSize);

    List<ProductInfo> findAll();

    List<ProductInfo> findBySaleQuantity(String productMsg);

    List<ProductInfo> findByCreateTime(String productMsg,Integer days);

    List<ProductInfo> findByPriceAsc(String productMsg);

    List<ProductInfo> findByPriceDesc(String productMsg);

    List<ProductInfoPageSortVO> findByPageGroupDesc();

    List<ProductInfo> findByFirstCategory(String firstCategory);

    List<ProductInfo> findNewGoods(Integer days);

    List<ProductInfo> findMostWelcome();

    List<String> findFirstCategory();

    List<String> findSecondCategory(String firstCategory);

    List<String> findThirdCategory(String secondCategory);

    List<String> findBrandName();

    ProductInfo findById(String productId);

    List<ProductInfo> findByIds(Set<String> ids);

    PageInfo<ProductInfo> findGoodsList(Integer startPage, Integer pageSize);

    List<String> findSecondCategoryList();

    List<String> findThirdCategoryList();

    Integer addProductInfo(ProductInfo productInfoForm);

    Integer updateProductInfo(ProductInfo productInfo);







}
