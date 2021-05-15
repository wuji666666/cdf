<template>
     <div class="space">
       <h4>猜你喜欢</h4>
       <div  class="goods-show"  >
          <router-link :to='"/shopcart/message/"+item.product_id' class="goodsinfo" v-for="item in productList"  :key="item.product_id" >
                <img  class="picture" :src="item.product_icon" />
                <span class="subcripble">{{item.product_description}}</span>
                <span class="orginal-price">原价￥{{item.cost_price}}</span>
                <span class="now-price">抢购价<span class="price">￥{{item.discount_price}}</span></span>
          </router-link>
       </div>
     </div> 
    
</template>


<script>
export default {
  data() {
    return {
      productList:[],
    }
  },
  mounted() {
    this.searchMostWelcome();
  },
  methods: {
      searchMostWelcome(){
      this.$http.get('http://localhost:8080/cdf/buyer/search/goods/welcome').then(result=>{
           if(result.body.code===0){
             this.productList= result.body.data;  
            
           }     
      }).catch(error=>{
        console.log(error.body.msg)
      })
    },
  },
  
}
</script>


<style lang="less" scoped>
.space{
  padding: 0;
  padding: 0;
}
h4{
  margin-top: 50px;
  font-weight: bold;
 
}

 .goods-show {
      display: flex;
      flex-direction: row;
      flex-wrap: wrap;
      justify-content: space-between;
      align-content: flex-start;
      overflow: scroll;

    .goodsinfo {
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
      margin:5px 15px
      
   
    }
  }
</style>
