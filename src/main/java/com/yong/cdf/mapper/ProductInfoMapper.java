package com.yong.cdf.mapper;

import com.yong.cdf.VO.ProductInfoPageSortVO;
import com.yong.cdf.entity.ProductInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Mapper
public interface ProductInfoMapper {
    Integer addProduct(ProductInfo productInfo);//It is for management system

    Integer updateProductInfo(ProductInfo productInfo);//It is for management system

    List<ProductInfo> findByMsg(String productMsg);

    List<ProductInfo> findAll();

    List<ProductInfo> findBySaleQuantity(String productMsg);

    List<ProductInfo> findByCreateTime(@Param("productMsg") String productMsg, @Param("lastDate") LocalDateTime lastDate);

    List<ProductInfo> findByPriceAsc(String productMsg);

    List<ProductInfo> findByPriceDesc(String productMsg);

    List<ProductInfoPageSortVO> findByPageGroupDesc();

    List<ProductInfo> findByFirstCategory(String firstCategory);

    List<ProductInfo> findNewGoods(LocalDateTime lastDate);

    List<String> findFirstCategory();// it is not useless

    List<String> findSecondCategory(String firstCategory); //it is not useless

    List<String> findThirdCategory(String secondCategory); //it is not useless

    List<String> findBrandName();

    ProductInfo findById(String id);

    List<ProductInfo> findByIds(@Param("ids") Set<String> ids);

    List<ProductInfo> findGoodsList();

    List<String> findSecondCategoryList();

    List<String> findThirdCategoryList();















}
