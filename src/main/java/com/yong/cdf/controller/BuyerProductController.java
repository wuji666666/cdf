package com.yong.cdf.controller;

import com.mysql.cj.util.StringUtils;
import com.yong.cdf.VO.ProductInfoPageSortVO;
import com.yong.cdf.VO.ResultVO;
import com.yong.cdf.entity.ProductInfo;
import com.yong.cdf.service.ProductInfoService;
import com.yong.cdf.util.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@Slf4j
@RequestMapping("/buyer")
public class BuyerProductController {

    @Autowired
    private ProductInfoService productInfoService;

    //@CrossOrigin(origins = "http://localhost:8088")
    @GetMapping("/search/goods")
    public ResultVO<List<ProductInfo>>  findByMsg(String productMsg) {
        if (StringUtils.isEmptyOrWhitespaceOnly(productMsg)) {
            return ResultVOUtil.success();
        }
        List<ProductInfo> list = productInfoService.findByMsg(productMsg);
        if(!StringUtils.isEmptyOrWhitespaceOnly(productMsg)){
            return ResultVOUtil.success(list);
        }
            return ResultVOUtil.error();

    }


    @RequestMapping("/search/all")
    public ResultVO<List<ProductInfo>> findAll(){
        List<ProductInfo> list=productInfoService.findAll();
        if(list!=null){
            return ResultVOUtil.success(list);
        }
        if(list==null){
            return ResultVOUtil.success();
        }
        return ResultVOUtil.error();
    }

    //Now it isn't be used
    @RequestMapping("search/title")
    public ResultVO<List<ProductInfo>>  findTitles(@RequestParam(value ="startPage",defaultValue = "1") Integer startPage,
                                                   @RequestParam(value = "pageSize",defaultValue = "6" ) Integer pageSize){
        List<ProductInfo> list=productInfoService.findByPage(startPage, pageSize);
        if(list!=null){
            return ResultVOUtil.success(list);
        }
        return ResultVOUtil.error();

    }

    @RequestMapping("/search/by/salequantity")
    public ResultVO<List<ProductInfo>>  findBySaleQuantity(String productMsg){
       List<ProductInfo> list=productInfoService.findBySaleQuantity(productMsg);
       if(StringUtils.isEmptyOrWhitespaceOnly(productMsg)){
           return ResultVOUtil.success();
       }
       if(!StringUtils.isEmptyOrWhitespaceOnly(productMsg)){
           return ResultVOUtil.success(list);
       }
       return ResultVOUtil.error();

    }

    @RequestMapping("/search/by/creatime")
    public ResultVO<List<ProductInfo>> findByCreateTime(@RequestParam("productMsg") String productMsg,
                                                        @RequestParam(value="days",defaultValue ="3")Integer days ){
       List<ProductInfo> list= productInfoService.findByCreateTime(productMsg,days);
        if(StringUtils.isEmptyOrWhitespaceOnly(productMsg)){
            return ResultVOUtil.success();
        }
        if(!StringUtils.isEmptyOrWhitespaceOnly(productMsg)){
            return ResultVOUtil.success(list);
        }
        return ResultVOUtil.error();
    }

    @RequestMapping("/search/by/price/asc")
    public ResultVO<List<ProductInfo>> findByPriceAsc(String productMsg){
        List<ProductInfo> list= productInfoService.findByPriceAsc(productMsg);
        if(StringUtils.isEmptyOrWhitespaceOnly(productMsg)){
            return ResultVOUtil.success();
        }
        if(!StringUtils.isEmptyOrWhitespaceOnly(productMsg)){
            return ResultVOUtil.success(list);
        }
        return ResultVOUtil.error();
    }


    @RequestMapping("/search/by/price/desc")
    public ResultVO<List<ProductInfo>> findByPriceDesc(String productMsg){
        List<ProductInfo> list= productInfoService.findByPriceDesc(productMsg);
        if(StringUtils.isEmptyOrWhitespaceOnly(productMsg)){
            return ResultVOUtil.success();
        }
        if(!StringUtils.isEmptyOrWhitespaceOnly(productMsg)){
            return ResultVOUtil.success(list);
        }
        return ResultVOUtil.error();
    }

    @RequestMapping("/search/by/page/group/desc")
    public ResultVO<List<Map<String,String>>> findByPageGroupDesc(){
       List<ProductInfoPageSortVO> list=productInfoService.findByPageGroupDesc();
       if(list==null){
           return ResultVOUtil.success();
       }
       if(list!=null){
           return ResultVOUtil.success(list);
       }
       return ResultVOUtil.error();
    }

    //This is unuseful
    @RequestMapping("/search/by/fcategory")
    public ResultVO<List<ProductInfo>> findByFirstCategory(String firstCategory){
      List<ProductInfo> list=productInfoService.findByFirstCategory(firstCategory);
      if(StringUtils.isEmptyOrWhitespaceOnly(firstCategory)){
          return ResultVOUtil.success();
      }
      if(list!=null){
          return ResultVOUtil.success(list);
      }
      if(list==null){
          return ResultVOUtil.success();
      }
      return ResultVOUtil.error();

    }

    @RequestMapping("/search/goods/latest")
    public ResultVO<List<ProductInfo>> findNewGoods(@RequestParam(value="days",defaultValue="15")Integer days){
       List<ProductInfo> list= productInfoService.findNewGoods(days);
       if(list==null){
          return  ResultVOUtil.success();
       }
       if(list!=null){
         return  ResultVOUtil.success(list);
       }
       return ResultVOUtil.error();

    }

    @RequestMapping("/search/goods/welcome")
    public ResultVO<List<ProductInfo>> findMostWelcome(){
      List<ProductInfo> list= productInfoService.findMostWelcome();
      if(list==null){
          return ResultVOUtil.success();
      }
      if(list!=null){
          return ResultVOUtil.success(list);
      }
      return ResultVOUtil.error();
    }

    @RequestMapping("/search/firstcategory")
    public ResultVO<List<String>> findFirstCategory(){
        List<String> list=productInfoService.findFirstCategory();
        if(list==null){
            return ResultVOUtil.success();
        }
        if(list!=null){
            return ResultVOUtil.success(list);
        }
        return ResultVOUtil.error();
    }

    @RequestMapping("/search/secondcategory")
    public ResultVO<List<String>>  findSecondCategory(String firstCategory){
        List<String> list=productInfoService.findSecondCategory(firstCategory);
        if(StringUtils.isEmptyOrWhitespaceOnly(firstCategory)){
            return ResultVOUtil.success();
        }
        if(list==null){
            return ResultVOUtil.success();
        }
        if(list!=null){
            return ResultVOUtil.success(list);
        }
        return ResultVOUtil.error();
    }

    @RequestMapping("/search/thirdcategory")
    public ResultVO<List<String>>  findThirdCategory(String secondCategory) {
        if(StringUtils.isEmptyOrWhitespaceOnly(secondCategory)){
            return ResultVOUtil.success();
        }
        List<String> list = productInfoService.findThirdCategory(secondCategory);
        if (list == null) {
            return ResultVOUtil.success();
        }
        if (list != null) {
            return ResultVOUtil.success(list);
        }
        return ResultVOUtil.error();
    }

    @RequestMapping("/search/brandname")
    public ResultVO<List<String>> findBrandName() {
        List<String> list = productInfoService.findBrandName();
        if (list == null) {
            return ResultVOUtil.success();
        }
        if (list != null) {
            return ResultVOUtil.success(list);
        }
        return ResultVOUtil.error();
    }

    @RequestMapping("search/product")
    public ResultVO<ProductInfo> findById(String productId){
        if (StringUtils.isEmptyOrWhitespaceOnly(productId)) {
            return ResultVOUtil.success();
        }
      ProductInfo productInfo=  productInfoService.findById(productId);
      if(productInfo==null){
          return ResultVOUtil.success();
      }
      if(productInfo!=null){
          return ResultVOUtil.success(productInfo);
      }
      return ResultVOUtil.error();
    }

    @RequestMapping("search/by/id")
    public ResultVO<ProductInfo> findByIds(String ids){

        String[] strArr=ids.split(",");
        List<String> list=Arrays.asList(strArr);
        Set<String> sets=new HashSet<String>(list);
        log.info(sets.toString());
        List<ProductInfo> listPro=productInfoService.findByIds(sets);
         if(listPro==null){
             return ResultVOUtil.success();
         }
         if(listPro!=null){
             return ResultVOUtil.success(listPro);
         }
        return ResultVOUtil.error();
    }

    @RequestMapping("search/by/{ids}")
    public Set findByIdt(@PathVariable String ids){
        String[] strArr=ids.split(",");
        List<String> list=Arrays.asList(strArr);
        Set<String> sets=new HashSet<String>(list);
        log.info(sets.toString());
        return  sets;
    }



}
