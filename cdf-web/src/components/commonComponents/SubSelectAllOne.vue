<template>

<div class="container">

    <div class="mui-input-row mui-search">
        <!--查询区-->
        <input type="search" class="mui-input-clear search-goods" id="tx" placeholder="搜索店铺内的商品"  v-model="msg" @keyup.enter="searchByContent"/>
   </div>
   
    <!--标题区-->
         <div
      id="sliderSegmentedControl"
      class="mui-scroll-wrapper mui-slider-indicator mui-segmented-control mui-segmented-control-inverted">
      <div class="mui-scroll" >
        <a class="mui-control-item mui-active" href="#" @click="searchBySaleQuantity"> 综合 </a>
        <a class="mui-control-item" href="#" @click="searchByContent"> 销量 </a>
        <a class="mui-control-item" href="#" @click="searchByCreateTime"> 新品 </a>
        <a class="mui-control-item choose" href="#" @click="searchByPriceAsc">价格</a>
        
        <a class="mui-control-item size" href="#"> 
          <span class="updown">
            <a class="glyphicon glyphicon-triangle-bottom" @click="searchByPriceDesc"></a>
            <a class="glyphicon glyphicon-triangle-top" @click="searchByPriceAsc" ></a>
          </span> 
       </a>
        <a class="mui-control-item" href="#"> 筛选 </a>
      </div>
    </div>


    <!--商品展示区-->
    <router-link :to='"/shopcart/message/"+item.product_id' class="goods-show" v-for="item in productList" :key="item.product_id">
        <img class="picture" :src="item.product_icon">
        <div class="show" >
            <p class="title">{{item.product_description}}</p>
            <span class="price">
                <p class="cost-price">原价：￥{{item.cost_price}}</p>
             
                <p class="discount-price">活动价：￥{{item.discount_price}}</p>
              <span class="buyer">
                <button >立即抢购</button>
              </span>
            </span>
        </div>

    </router-link>
  
    </div>
   



    
</template>


<script>
export default {
      data() {
    return {
      msg:"",
      productList:[],
    }
  },
  props:["parentmsg"],
  mounted() {
    this.msg=this.parentmsg;
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
              //console.log(result.body.data[0].product_id);
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
    }
  
  },
    
}
</script>

<style lang="scss">

.container {
overflow: scroll;

   .goods-show{
    display: flex;
     width:100%;
     height: 122px;
     margin-bottom: 10px;
     margin-left: 15px;
    

     .picture{
       width:120px;
       margin-right: 15px;
      }
      .title{
        text-align: center;
        margin-top: 13px ;
        margin-bottom: 10px;
        font-weight: bold;
        text-align: center;
      }
      .price{
        
        .cost-price{
          font-size: 10px;
          color: red;
        }
        .discount-price{
          font-size: 10px;
          color: red;
          font-weight: bold;
        }
      }

   
   }
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
   

}
.show{
  text-align: center;
}
.mui-input-row,.mui-search{
  margin:0 8px
}
* {
    touch-action: pan-y;
}

</style>