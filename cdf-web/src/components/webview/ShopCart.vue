<template>
    
   <div class="container">
    
      <h5 ref="gou">购物车</h5>
   <div class="header">
     
      <img class="png" src="../../images/cdf.png"/>
      <span class="cdf">cdf会员购</span>
      
      <span class="manage">管理</span>
   </div>
   <hr>
    <div class="cart">
     <div class="discount">
        <span class="man">满折</span>
        <span class="enjoy">已购满2件，可享受9折</span>
        <a class="more">查看活动></a>
     </div>
     <div class="product-show" v-for="(item,i) in productList" :key="item.product_id">
        <mt-switch v-model="item.product_id"></mt-switch>
        <router-link :to='"/shopcart/message/"+item.product_id'><img  class="picture" :src="item.product_icon" /></router-link>
      
        <span class="msg">
           <span class="info">{{item.product_description}}</span>
           <span class="shui" ref="dis">包邮包税</span>
 
      <span class="numbox">
         <span class="price" >折扣价：￥{{item.discount_price}}</span>
         <span   class="mui-numbox"    data-numbox-min='1' data-numbox-step='1'    style="height:25px;" >
               <button class="mui-btn mui-btn-numbox-minus" type="button" @click="minus">-</button>
               <input  ref="minusbox"   class="mui-input-numbox" type="number" v-bind:value="$store.getters.initCount[item.product_id]"
                @change="countChange(item.product_id,i)" readonly/>
               <button class="mui-btn mui-btn-numbox-plus" type="button" @click="plus">+</button>
        </span>
     </span> 
        </span>
     </div>
   </div>

   <div class="box"></div>
   <mastercategory></mastercategory>
   </div>
</template>


<script>
    import mui from "../../lib/mui/js/mui.js";
    import mastercategory from '../commonComponents/MasterCategory.vue';
   
export default{
   data() {
      return {
        productList:[], 
      }
   },
   created() {
       this.getGoodsList();
   },
   mounted() {
    mui(".mui-numbox").numbox();
   },

   methods: {
       getGoodsList(){
          var arr=[];
         this.$store.state.productInfo.forEach(item => {
               arr.push(item.id);
            }); 
         if(arr.length==0){
            return;
         }
         this.$http.get("http://localhost:8080/cdf/buyer/search/by/id?ids="+arr.join(",")).then(result=>{
            if(result.body.code===0){
               this.productList=result.body.data;     
            }
         })
        
       },
       minus(){
        mui(".mui-numbox").numbox().getValue()
       },
       plus(){
         mui(".mui-numbox").numbox().getValue();
       },
       countChange(id,i){
          
        
       var infor={id:id,quantity:this.$refs.minusbox[i].value}
       this.$store.commit("upDatedCounts",infor)
          
        
          this.$nextTick(()=>{
             
           // var value=this.$refs.minusbox[0].value;
            
           //  console.log(value) 
          })
            
       
         
       }

      
   },

     components:{
      "mastercategory":mastercategory 
   }
}


</script>


<style lang="scss" scoped>

.container{
   padding: 0;
   margin: 0;
}
.box{
   height: 120px;
   width: 100%;
}
.info{
   margin-top: 8px;
}
.shui{
 margin-top: 8px;
 color: rgb(247, 128, 128);
}
.price{
 margin-top: 8px;
 color: red;
}
.numbox{
   display: flex;
   flex-direction: row;
   flex-wrap: nowrap;
   position: relative;
}
.mui-numbox{
 margin-top: 6px;
 position: absolute;
 right: 10px;
 background-color: pink;
}
.mt{
   text-align: center;
}
.png{
   width: 30px;
   height: 30px;
   border-radius: 50%;
   background-color: hsl(0, 92%, 59%);
   text-align: center;
}
.manage{
 position: absolute;
 right: 10px;
}
.header{
   margin-left: 10px;
   position: relative;
 
}

.cart{
   position: relative;
   background-color: pink;
   margin-top: 0;
}
hr{
   margin: 7px auto;
}
.man{
   background-color: rgb(199, 37, 37);
   margin-left: 10px;
 
  
}
.more{
   position: absolute;
   right: 10px;
   background-color: rgb(247, 128, 128);
}
.product-show{
   margin-top: 7px;
   margin-left: 10px;
   display: flex;
   flex-direction: row;
   flex-wrap: nowrap;
   justify-content: space-around;
   position: relative;

}
.picture{
width: 120px;
height: 120px;
margin-left: 15px;
}
.msg{
   display: flex;
   flex-direction: column;
   
}
.discount{
   padding-top: 10px;
}


</style>