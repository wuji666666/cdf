<template>
  <div class="container">
     <h5>{{title}}</h5>
    <div class="mui-input-row mui-search">
      <input type="search" class="mui-input-clear search-goods" id="tx" placeholder="搜索店铺内的商品" v-model="msg"  @keyup.enter="searchByContent"/>
    </div>

    <div
      id="sliderSegmentedControl"
      class="mui-scroll-wrapper mui-slider-indicator mui-segmented-control mui-segmented-control-inverted">
      <div class="mui-scroll">
        <a class="mui-control-item mui-active" href="#" @click="searchByContent"> 综合 </a>
        <a class="mui-control-item" href="#" @click="searchBySaleQuantity"> 销量 </a>
        <a class="mui-control-item" href="#" @click="searchByCreateTime"> 新品 </a>
        <a class="mui-control-item choose" href="#" @click="searchByPriceAsc">价格</a>
        
        <a class="mui-control-item size" href="#"> 
          <span class="updown ">
            <a class="glyphicon glyphicon-triangle-bottom" @click="searchByPriceDesc"></a>
            <a class="glyphicon glyphicon-triangle-top" @click="searchByPriceAsc" ></a>
          </span> 
       </a>
        <a class="mui-control-item" href="#"> 筛选 </a>
      </div>
    </div>
  <div  class="goods-show">
    <div class="goodsinfo"  v-for="item in productList"  :key="item.product_id">
        <router-link :to='"/shopcart/message/"+item.product_id'><img  class="picture" :src="item.product_icon"/></router-link>
        <span class="subcripble">{{item.product_description}}</span>
        <span class="orginal-price">原价￥{{item.cost_price}}</span>
        <span class="now-price">抢购价<span class="price">￥{{item.discount_price}}</span></span>
      </div>
    </div>
  </div>
</template>

<script>
export default{
  data() {
    return {
     msg:"",
     title:"",
     productList:[],
    }
  },
 
 props:["parentmsg"],
 mounted() {
     var routeContent=this.$route.params.title;
     if(routeContent==="香喷"){
         this.title="--香水--";
         this.msg="香水";
     }else if(routeContent==="百货"){
         this.title="--日用百货--";
         this.msg="日用百货";
     }else if(routeContent==="精品"){
         this.title="--腕表首饰--";
         this.msg="腕表首饰";
     }else if(routeContent==="护肤品"){
         this.title="--面部护理--";
         this.msg="面部护理";
     }else if(routeContent==="新品上架"){
         this.title="--新品上架--";
         this.msg="";
       this.searchByLatest();
       return;
     }else{
         this.title=this.$route.params.title;
         this.msg=this.$route.params.title;
     }
   this.searchByContent();
 },
  methods: {
    
    searchByContent(){
      this.$http.get("http://localhost:8080/cdf/buyer/search/goods?productMsg="+this.msg).then(result=>{   
        if(result.body.code===0)  {
              this.productList=result.body.data; 
        }
      }).catch(error=>{
       console.log(error.body.msg);
      })
    },
    searchBySaleQuantity(){
      this.$http.get("http://localhost:8080/cdf/buyer/search/by/salequantity?productMsg="+this.msg).then(result=>{
            if(result.body.code===0)  {
              this.productList=result.body.data; 
        }
      }).catch(error=>{
        console.log(error.body.msg);
      })
    },
    searchByCreateTime(){
       this.$http.get("http://localhost:8080/cdf/buyer/search/by/creatime?productMsg="+this.msg).then(result=>{
            if(result.body.code===0)  {
              this.productList=result.body.data; 
        }
      }).catch(error=>{
        console.log(error.body.msg);
      })
    },
    searchByPriceAsc(){
      this.$http.get("http://localhost:8080/cdf/buyer/search/by/price/asc?productMsg="+this.msg).then(result=>{
             if(result.body.code===0)  {
              this.productList=result.body.data; 
        }
      }).catch(error=>{
        console.log(error.body.msg);
      })
    },
    searchByPriceDesc(){
       this.$http.get("http://localhost:8080/cdf/buyer/search/by/price/desc?productMsg="+this.msg).then(result=>{
             if(result.body.code===0)  {
              this.productList=result.body.data; 
        }
      }).catch(error=>{
        console.log(error.body.msg);
      })
    },

    searchByLatest(){
      this.$http.get("http://localhost:8080/cdf/buyer/search/goods/latest").then(result=>{
        if(result.body.code===0){
           this.productList=result.body.data;
        }
      }).catch(error=>{
        console.log(error.body.msg);
      })
    }





    
  },
}
</script>


<style lang="less" scoped>

.container {
  margin: 0;
  padding: 0;
overflow: scroll;
   .choose{
     padding-right: 0;
     margin-right: 0;
   }
   .size{
     padding: 0;
     margin:0;
     display: inline-block;
    
   .updown{
    
      display: flex;
      flex-direction: column;
      line-height: 15px;
      box-sizing: content-box;
      
     a{
       display: inline-block;
       padding: 0;
       margin: 0;
       height: 15px; 
       
     }
    
     .glyphicon,.glyphicon-triangle-top{
       padding: 0;
       margin: 0;
       margin-bottom: 3px;
       
     }
     }
    }


  .goods-show {
     
      display: flex;
      flex-direction: row;
      flex-wrap: wrap;
      justify-content: space-between;
      align-content: flex-start;
      overflow: scroll;

    .goodsinfo {
      margin: auto 18px;
      .picture{
        width:100%;
        
      }
      .orginal-price{
        color: coral;
        background: cornflowerblue;
        width: 80px;
       
      }
      .now-price{
        color:coral;

        .price{
          color: red;
        }
      }
       .subcripble{
          overflow: hidden;
          width: 170px;
          height: 40px;
       }
      width: 170px;
      display: flex;
      flex-direction: column;
      justify-content: space-between;
      margin-top: 5px;
      margin-bottom: 5px;
   
    }
  }
  h5 {
    margin-top: 10px;
    margin-bottom: 9px;
    margin-left: 6px;
  }
}

.mui-input-row,.mui-search{
  margin: 0 8px;
  padding:3px auto;
}

#sliderSegmentedControl{
  
.mui-scroll{
  
  width:100%;
  background-color: blanchedalmond;
  margin-bottom: 6px;
  
 
}
}
* {
    touch-action: pan-y;
}

</style>
