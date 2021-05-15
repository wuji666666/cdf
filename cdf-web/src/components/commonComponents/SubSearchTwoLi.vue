<template>

      <div  class="goods-show"  >
          <router-link :to='"/shopcart/message/"+item.product_id' class="goodsinfo" v-for="item in productList"  :key="item.product_id" >
                <img  class="picture" :src="item.product_icon" />
                <span class="subcripble">{{item.product_description}}</span>
                <span class="orginal-price">原价￥{{item.cost_price}}</span>
                <span class="now-price">抢购价<span class="price">￥{{item.discount_price}}</span></span>
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
    this.searchAll();
  
  },
  methods: {
    searchAll(){
      this.$http.get("http://localhost:8080/cdf/buyer/search/goods?productMsg="+this.msg).then(result=>{
           if(result.body.code===0){
             this.productList= result.body.data;  
             this.$emit("func",this.productList);  
           }     
      }).catch(error=>{
        console.log(error.body.msg)
      })
    },
  },  
}
</script>


<style lang="less" scoped>


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
      margin-top: 5px;
      margin-bottom: 5px;
      margin-left: 15px;
      margin-right: 15px;
   
    }
  }
  * {
    touch-action: pan-y;
}
</style>