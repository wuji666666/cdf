package com.yong.cdf.controller;

import com.github.pagehelper.PageInfo;
import com.mysql.cj.util.StringUtils;
import com.yong.cdf.entity.ProductInfo;
import com.yong.cdf.enums.SellerOperateEnum;
import com.yong.cdf.form.ProductInfoForm;
import com.yong.cdf.service.ProductInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: SellerProductController
 * @Description: 卖家端商品管理
 * @Author
 * @Date 2021/5/6
 * @Time 23:21
 * @Version 1.0
 */

@Controller
@Slf4j
@RequestMapping("/seller")
public class SellerProductController {

    @Autowired
    private ProductInfoService productInfoService;


    @RequestMapping("/product/list")
    public ModelAndView list(@RequestParam(value="pageNum",defaultValue = "1") Integer pageNum,
                             @RequestParam(value="pageSize",defaultValue = "6") Integer pageSize){
        PageInfo<ProductInfo> productPageInfo=productInfoService.findGoodsList(pageNum, pageSize);
        List<ProductInfo> productInfoList=productPageInfo.getList();
        Map<String,Object> map=new HashMap<>();
        map.put("productPageInfo",productPageInfo);
        map.put("productInfoList",productInfoList);

        return new ModelAndView("product/list",map);
    }

    @RequestMapping("/product/category")
    public ModelAndView findCategory(){
        List<String> firstCategorys= productInfoService.findFirstCategory();
        List<String> secondCategorys= productInfoService.findSecondCategoryList();
        List<String> thirdCategorys=productInfoService.findThirdCategoryList();
        Map<String,List<String>> map=new HashMap<>();
        map.put("firstCategorys",firstCategorys);
        map.put("secondCategorys",secondCategorys);
        map.put("thirdCategorys",thirdCategorys);
        return new ModelAndView("product/add",map);
    }

    @RequestMapping("/product/add")
    public ModelAndView add(@Valid ProductInfoForm productInfoForm, BindingResult bindingResult){
        Map<String,Object> map=new HashMap<>();
        if(bindingResult.hasErrors()){
          map.put("error",SellerOperateEnum.ADD_PRODUCT_EXCEPTION.getMessage());
          map.put("url","/cdf/seller/product/category");
          return new ModelAndView("common/error",map);
       }
        ProductInfo productInfo=new ProductInfo();
        BeanUtils.copyProperties(productInfoForm,productInfo);
        Integer n=productInfoService.addProductInfo(productInfo);
        map.put("success",SellerOperateEnum.ADD_PRODUCT_SUCCESS.getMessage());
        map.put("url","/cdf/seller/product/list");
        return new ModelAndView("common/success",map);
    }

    @RequestMapping("/product/msg/find")
    public ModelAndView findById(String productId){
        Map<String,Object> map=new HashMap<>();
        if(StringUtils.isEmptyOrWhitespaceOnly(productId)){
            map.put("error",SellerOperateEnum.UPDATE_PRODUCT_ID_ISNULL.getMessage());
            map.put("url","/cdf/seller/product/list");
            return new ModelAndView("common/error",map);
        }
        ProductInfo productInfo= productInfoService.findById(productId);
        List<String> firstCategorys= productInfoService.findFirstCategory();
        List<String> secondCategorys= productInfoService.findSecondCategoryList();
        List<String> thirdCategorys=productInfoService.findThirdCategoryList();
        map.put("firstCategorys",firstCategorys);
        map.put("secondCategorys",secondCategorys);
        map.put("thirdCategorys",thirdCategorys);
        map.put("productInfo",productInfo);
        return new ModelAndView("product/update",map);
    }


    @RequestMapping("/product/update")
    public ModelAndView update(@Valid ProductInfoForm productInfoForm,BindingResult bindingResult){
        Map<String,Object> map=new HashMap<>();
        if(bindingResult.hasErrors()){
            map.put("error",SellerOperateEnum.UPDATE_PRODUCT_MESSAGE_ERROR.getMessage());
            map.put("url","/cdf/seller/product/list");
            return new ModelAndView("common/error",map);
        }
//       if(StringUtils.isEmptyOrWhitespaceOnly(productInfoForm.getProduct_id())){
//           map.put("error",SellerOperateEnum.UPDATE_PRODUCT_ID_ISNULL.getMessage());
//           map.put("url","/cdf/seller/product/msg/find");
//           return new ModelAndView("common/error",map);
//       };
        ProductInfo productInfo=new ProductInfo();
        BeanUtils.copyProperties(productInfoForm,productInfo);
        productInfoService.updateProductInfo(productInfo);
        map.put("success",SellerOperateEnum.UPDATE_PRODUCT_SUCCESS.getMessage());
        map.put("url","/cdf/seller/product/list");
        return new ModelAndView("common/success",map);
    }

   @RequestMapping("/product/onsale")
    public ModelAndView onSale(String productId){
        Map<String,Object> map=new HashMap<>();
        if(StringUtils.isEmptyOrWhitespaceOnly(productId)){
            map.put("error",SellerOperateEnum.UPDATE_PRODUCT_ID_ISNULL.getMessage());
            return new ModelAndView("/product/list",map);
        }
      ProductInfo productInfo=  productInfoService.findById(productId);
        if(productInfo==null){
            map.put("error",SellerOperateEnum.ON_SALL_PRODUCT_NOT_EXSIST.getMessage());
            return new ModelAndView("product/list",map);
        }
      productInfo.setProduct_type(1);
      productInfoService.updateProductInfo(productInfo);
      map.put("success",SellerOperateEnum.UPDATE_PRODUCT_STATE_SUCCESS.getMessage());
       map.put("url","/cdf/seller/product/list");
      return new ModelAndView("common/success",map);
   }

    @RequestMapping("/product/offsale")
    public ModelAndView onOff(String productId){
        Map<String,Object> map=new HashMap<>();
        if(StringUtils.isEmptyOrWhitespaceOnly(productId)){
            map.put("error",SellerOperateEnum.UPDATE_PRODUCT_ID_ISNULL.getMessage());
            map.put("url","/cdf/seller/product/list");
            return new ModelAndView("/product/list",map);
        }
        ProductInfo productInfo=  productInfoService.findById(productId);
        if(productInfo==null){
            map.put("error",SellerOperateEnum.OFF_SALE_PRODUCT_NOT_EXSIST.getMessage());
            map.put("url","/cdf/seller/product/list");
            return new ModelAndView("product/list",map);
        }
        productInfo.setProduct_type(0);
        productInfoService.updateProductInfo(productInfo);
        map.put("success",SellerOperateEnum.UPDATE_PRODUCT_STATE_SUCCESS.getMessage());
        map.put("url","/cdf/seller/product/list");
        return new ModelAndView("common/success",map);
    }

}
