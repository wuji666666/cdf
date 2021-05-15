package com.yong.cdf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yong.cdf.VO.ProductInfoPageSortVO;
import com.yong.cdf.bean.PageHelperConfig;
import com.yong.cdf.entity.ProductInfo;
import com.yong.cdf.mapper.ProductInfoMapper;
import com.yong.cdf.service.ProductInfoService;
import com.yong.cdf.util.UniqueKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Service
public class ProductInfoServiceImpl implements ProductInfoService {
    @Autowired
    private ProductInfoMapper productInfoMapper;


    @Override
    public List<ProductInfo> findByMsg(String productMsg) {
        List<ProductInfo> productInfos=productInfoMapper.findByMsg(productMsg);
        return productInfos;
    }

    @Override
    public List<ProductInfo> findByPage( Integer startPage, Integer pageSize) {
        PageHelperConfig pageHelperConfig=new PageHelperConfig();

        PageHelper.startPage(startPage,pageSize);
        List<ProductInfo> list=productInfoMapper.findAll();
        return list;
    }

    @Override
    public List<ProductInfo> findAll() {
        return productInfoMapper.findAll();
    }

    @Override
    public List<ProductInfo> findBySaleQuantity(String productMsg) {
        return  productInfoMapper.findBySaleQuantity(productMsg);
    }

    @Override
    public List<ProductInfo> findByCreateTime(String productMsg,Integer days) {
        LocalDateTime lastTime=LocalDateTime.now().minusDays(days);
        return productInfoMapper.findByCreateTime(productMsg,lastTime);
    }

    @Override
    public List<ProductInfo> findByPriceAsc(String productMsg) {
        return productInfoMapper.findByPriceAsc(productMsg);
    }

    @Override
    public List<ProductInfo> findByPriceDesc(String productMsg) {
        return productInfoMapper.findByPriceDesc(productMsg);
    }

    @Override
    public List<ProductInfoPageSortVO> findByPageGroupDesc() {
     PageHelper.startPage(1,6);
     List<ProductInfoPageSortVO> list=productInfoMapper.findByPageGroupDesc();
     return list;
    }

    @Override
    public List<ProductInfo> findByFirstCategory(String firstCategory) {
        return productInfoMapper.findByFirstCategory(firstCategory);
    }

    @Override
    public List<ProductInfo> findNewGoods(Integer days) {
        LocalDateTime lastDate=LocalDateTime.now().minusDays(days);
        List<ProductInfo> list=productInfoMapper.findNewGoods(lastDate);
        return list;
    }

    @Override
    public List<ProductInfo> findMostWelcome() {
        List<ProductInfo> productInfoList=new ArrayList<>();
        List<ProductInfoPageSortVO> list=productInfoMapper.findByPageGroupDesc().subList(0,6);
        for(ProductInfoPageSortVO productInfoPageSortVO:list) {
            List<ProductInfo> productInfos= productInfoMapper.findByMsg(productInfoPageSortVO.getProduct_name()).subList(0,2);
            productInfoList.addAll(productInfos);
        }
        return productInfoList;
    }

    @Override
    public List<String> findFirstCategory() {
        List<String> list=productInfoMapper.findFirstCategory();
        return list;
    }

    @Override
    public List<String> findSecondCategory(String firstCategory) {
        return productInfoMapper.findSecondCategory(firstCategory);
    }

    @Override
    public List<String> findThirdCategory(String secondCategory) {
        return productInfoMapper.findThirdCategory(secondCategory);
    }

    @Override
    public List<String> findBrandName() {
        return productInfoMapper.findBrandName();
    }

    @Override
    public ProductInfo findById(String productId) {
        return productInfoMapper.findById(productId);
    }

    @Override
    public List<ProductInfo> findByIds(Set<String> ids) {
        return productInfoMapper.findByIds(ids);
    }

    @Override
    public PageInfo<ProductInfo> findGoodsList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<ProductInfo> list=productInfoMapper.findGoodsList();
        PageInfo<ProductInfo> pageInfo=new PageInfo<>(list,pageNum);
        return pageInfo;
    }

    @Override
    public List<String> findSecondCategoryList() {
        return productInfoMapper.findSecondCategoryList();
    }

    @Override
    public List<String> findThirdCategoryList() {
        return productInfoMapper.findThirdCategoryList();
    }

    @Override
    @Transactional
    public Integer addProductInfo(ProductInfo productInfo) {
        productInfo.setProduct_id(UniqueKey.createId());
        Integer n=productInfoMapper.addProduct(productInfo);
        return n;
    }

    @Override
    @Transactional
    public Integer updateProductInfo(ProductInfo productInfo) {
        return productInfoMapper.updateProductInfo(productInfo);
    }


}
