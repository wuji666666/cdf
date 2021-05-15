package com.yong.cdf.mapper;


import com.yong.cdf.VO.ProductInfoPageSortVO;
import com.yong.cdf.entity.ProductInfo;
import com.yong.cdf.util.UniqueKey;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
class ProductInfoMapperTest {

    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Test
    public void insertTest(){
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProduct_id(UniqueKey.createId());
        productInfo.setProduct_name("尿不湿");
        productInfo.setProduct_stock(287);
        productInfo.setCost_price(246);
        productInfo.setDiscount_price(238);
        productInfo.setProduct_description("保湿，去屑，润肤");
        productInfo.setProduct_icon("D:jiewoe/oepwe、oewr");
        productInfo.setFirst_category("日用百货");
        productInfo.setSecond_category("母婴用品");
        productInfo.setThird_category("尿不湿");
        productInfo.setBrand_name("帮宝舒");
       productInfo.setProduct_title("照亮你的美");

        Integer n=productInfoMapper.addProduct(productInfo);
        System.out.println(n);
    }

    @Test
    public void selectProductInfo(){
        List<ProductInfo> list=productInfoMapper.findByMsg("面部护理");
        System.out.println(list);
    }

    @Test
    public void selectById(){
        ProductInfo productInfo=productInfoMapper.findById("123098");
        System.out.println(productInfo);
    }

    @Test
    public void updateProductInfoTest(){
          ProductInfo productInfo=productInfoMapper.findById("64289542b6d5453da987f7bd329b4fee");
           productInfo.setProduct_type(1);
           productInfoMapper.updateProductInfo(productInfo);

    }

    @Test
    public void findByName(){
       List<ProductInfo> productInfo= productInfoMapper.findAll();
       System.out.println(productInfo.size());
    }

    @Test
    public  void findBySales(){
      List<ProductInfo> list= productInfoMapper.findBySaleQuantity("诗漫");
      for(ProductInfo productInfo:list){
         System.out.println(productInfo.getSale_quantity());
      }
    }

    @Test
    public  void findByCreateTime() {
        LocalDateTime now=LocalDateTime.now();
        LocalDateTime localdate=now.minusDays(2);
        List<ProductInfo> list = productInfoMapper.findByCreateTime("茅台",localdate);
        for (ProductInfo productInfo : list) {
            System.out.println(productInfo);
        }
    }

    @Test
    public void findByPriceAscTest(){
      List<ProductInfo> list=  productInfoMapper.findByPriceAsc("欧诗漫");
        for (ProductInfo productInfo : list) {
            System.out.println(productInfo.getDiscount_price());
        }
    }

    @Test
    public void findByPriceDescTest(){
        List<ProductInfo> list=  productInfoMapper.findByPriceDesc("欧诗漫");
        for (ProductInfo productInfo : list) {
            System.out.println(productInfo.getDiscount_price());
        }
    }

    @Test
    public void findByPageGroupDescTest(){
      List<ProductInfoPageSortVO> list=productInfoMapper.findByPageGroupDesc();
       for(ProductInfoPageSortVO productInfoPageSortVO:list ){
           String product_name=productInfoPageSortVO.getProduct_name();
           Integer total_quantity=productInfoPageSortVO.getTotal_quantity();
           System.out.println("total_quantity="+total_quantity+","+"product_name="+product_name);
       }

      //  System.out.println(list);




    }

    @Test
    public void findBygeneralTermTest(){
       List<ProductInfo> productInfo= productInfoMapper.findByFirstCategory("护肤品");
      System.out.println(productInfo.size());
    }

    @Test
    public void findNewGoodsTest(){
        LocalDateTime lastDate=LocalDateTime.now().minusDays(3);
        System.out.println(productInfoMapper.findNewGoods(lastDate).size());
    }

    @Test
    public void findFirstCategoryTest(){
       System.out.println(productInfoMapper.findFirstCategory());
    }

    @Test
    public void findSecondCategoryTest(){
        System.out.println(productInfoMapper.findSecondCategory("服饰皮具"));
    }

    @Test
    public void findThirdCategoryTest(){
        System.out.println(productInfoMapper.findThirdCategory("木林"));
    }

    @Test
    public void findBrandNameTest(){
        System.out.println(productInfoMapper.findBrandName());
    }

    @Test
    public void findByIdsTest(){
        Set set=new HashSet<String>();
        set.add("1a077d5bfcb041bf9d9078732779bb29");
        set.add("ab4e051c0b674e139a52d3b7f4b9549b");
        set.add("a423decfb05b46f5ac704b080fbfaec5");
        System.out.println(productInfoMapper.findByIds(set));
    }

    @Test
    public void findGoodsListTest(){
       System.out.println(productInfoMapper.findGoodsList().size());
    }

    @Test
    public void secondCategoryTests(){
        System.out.println(productInfoMapper.findSecondCategoryList());
    }
}